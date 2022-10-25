package com.example.tf.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.tf.DTO.ClienteDTO_POST;
import com.example.tf.domain.Cliente;
import com.example.tf.exception.CpfException;
import com.example.tf.exception.EmailException;
import com.example.tf.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> cliente = clienteService.findAll();
		if(cliente.isEmpty()) {
			return  ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(cliente);
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> findById(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Cliente> PostItemPedido(@Valid @RequestBody ClienteDTO_POST clienteDTO) throws EmailException, CpfException {
		Cliente clienteTemp = clienteService.PostCliente(clienteDTO);
		if (clienteTemp == null) {
			return ResponseEntity.notFound().build();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clienteTemp.getIdCliente())
				.toUri();
		return ResponseEntity.created(uri).body(clienteTemp);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> Putcliente(@Valid @RequestBody Cliente cliente, @PathVariable Long id) {
		Optional<Cliente> clienteTemp = clienteService.PutCliente(cliente, id);
		if (!clienteTemp.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(clienteTemp);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (clienteService.DeleteCliente(id)) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
