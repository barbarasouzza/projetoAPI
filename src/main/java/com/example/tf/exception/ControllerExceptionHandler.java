package com.example.tf.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ErroCampo> erros = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			erros.add(new ErroCampo(error.getField(), error.getDefaultMessage()));
		}
		ErroResposta erroResposta = new ErroResposta(status.value(), "Existem Campos Inválidos", LocalDateTime.now(),
				erros);
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@ExceptionHandler(PedidoDataRetroativaException.class)
	protected ResponseEntity<Object> handlePedidoDataRetroativaException(PedidoDataRetroativaException ex) {
		List<ErroCampo> erros = new ArrayList<>();
		erros.add(new ErroCampo("dataPedido", "A data do pedido não pode ser anterior a data de hoje."));

		ErroResposta erroResposta = new ErroResposta(HttpStatus.BAD_REQUEST.value(), "Existem Campos Inválidos",
				LocalDateTime.now(), erros);
		return ResponseEntity.badRequest().body(erroResposta);
	}
	
	@ExceptionHandler(DescricaoException.class)
	protected ResponseEntity<Object> handleDescricaoException(DescricaoException ex) {
		List<ErroCampo> erros = new ArrayList<>();
		erros.add(new ErroCampo("descricaoProduto", "A descrição não pode ser identica à de um produto já cadastrado."));

		ErroResposta erroResposta = new ErroResposta(HttpStatus.BAD_REQUEST.value(), "Existem Campos Inválidos",
				LocalDateTime.now(), erros);
		return ResponseEntity.badRequest().body(erroResposta);
	}
	
	@ExceptionHandler(CpfException.class)
	protected ResponseEntity<Object> handleCpfException(CpfException ex) {
		List<ErroCampo> erros = new ArrayList<>();
		erros.add(new ErroCampo("cpfCliente", "CPF já cadastrado no sistema."));

		ErroResposta erroResposta = new ErroResposta(HttpStatus.BAD_REQUEST.value(), "Existem Campos Inválidos",
				LocalDateTime.now(), erros);
		return ResponseEntity.badRequest().body(erroResposta);
	}
	
	@ExceptionHandler(EmailException.class)
	protected ResponseEntity<Object> handleEmailException(EmailException ex) {
		List<ErroCampo> erros = new ArrayList<>();
		erros.add(new ErroCampo("emailCliente", "E-mail já cadastrado no sistema."));

		ErroResposta erroResposta = new ErroResposta(HttpStatus.BAD_REQUEST.value(), "Existem Campos Inválidos",
				LocalDateTime.now(), erros);
		return ResponseEntity.badRequest().body(erroResposta);
	}
}
