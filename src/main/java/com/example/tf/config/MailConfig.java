package com.example.tf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.example.tf.DTO.Relatorio;
import com.example.tf.domain.Cliente;

@Configuration
public class MailConfig {
	@Autowired
	JavaMailSender javaMailSender;

	public void sendEmailProduto(Relatorio relatorio, Cliente cliente) {
		StringBuffer sb = new StringBuffer();
		sb.append("Olá, " + cliente.getNomeCompletoCliente() + " seja muito bem-vindo a nossa loja! obrigado por comprar conosco e volte sempre! \n");
		sb.append("ID do Pedido: " + relatorio.toString().replaceAll(",", "\n") + "\n");
	
		
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("serratec.api@gmail.com");
		message.setSubject("Produto cadastrado com sucesso");
		message.setText(sb.toString());
		message.setTo(cliente.getEmailCliente());
		javaMailSender.send(message);
	}
	
	public void sendEmailCadastro(Cliente cliente) {
		StringBuffer sb = new StringBuffer();
		sb.append("Olá, " + cliente.getNomeCompletoCliente() + " seja muito bem-vindo a nossa loja! obrigado por efetuar o cadastro em nosso site! \n");
			
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("serratec.api@gmail.com");
		message.setSubject("Cliente cadastrado com sucesso");
		message.setText(sb.toString());
		message.setTo(cliente.getEmailCliente());
		javaMailSender.send(message);
	}
	
	
}
