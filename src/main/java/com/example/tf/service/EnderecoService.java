package com.example.tf.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.tf.DTO.EnderecoViaCepDTO;
import com.example.tf.domain.Endereco;
import com.example.tf.repository.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco buscar(String cep, String numeroEndereco, String complementoEndereco) {
	       Optional<Endereco>  endereco = Optional.ofNullable(enderecoRepository.findByCepEndereco(cep));
	       if (endereco.isPresent()) {
	           return endereco.get();
	       } else {
	    	   
	           RestTemplate restTemplate = new RestTemplate(); 
	           
	           String uri = "http://viacep.com.br/ws/"+cep+"/json";

	           Optional<EnderecoViaCepDTO> enderecoViaCep = Optional.ofNullable(restTemplate.getForObject(uri, EnderecoViaCepDTO.class));
	           if (enderecoViaCep.get().getCep()!=null) {
	               String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
	               enderecoViaCep.get().setCep(cepSemTraco);
	               Endereco enderecoBanco = new Endereco();
	               enderecoBanco.setCepEndereco(cepSemTraco);
	               enderecoBanco.setBairroEndereco(enderecoViaCep.get().getBairro());
	               enderecoBanco.setCidadeEndereco(enderecoViaCep.get().getLocalidade());
	               enderecoBanco.setRuaEndereco(enderecoViaCep.get().getLogradouro());
	               enderecoBanco.setUF(enderecoViaCep.get().getUf());
	               enderecoBanco.setComplementoEndereco(complementoEndereco);
	               enderecoBanco.setNumeroEndereco(numeroEndereco);
	               return enderecoRepository.save(enderecoBanco);
	           } else {
	               return null;
	           }

	       }}}
