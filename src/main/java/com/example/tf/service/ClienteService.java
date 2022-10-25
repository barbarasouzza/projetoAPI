package com.example.tf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tf.DTO.ClienteDTO_POST;
import com.example.tf.config.MailConfig;
import com.example.tf.domain.Cliente;
import com.example.tf.domain.Endereco;
import com.example.tf.exception.CpfException;
import com.example.tf.exception.EmailException;
import com.example.tf.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoService enderecoService;

	@Autowired
	private MailConfig mailConfig;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> findById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return cliente;
		}
		return null;
	}

	@Transactional
	public Cliente PostCliente(ClienteDTO_POST clienteDTO_POST) throws EmailException, CpfException {
		if (clienteRepository.findByEmailCliente(clienteDTO_POST.getEmailCliente()) != null) {
			throw new EmailException();
		}
		if (clienteRepository.findByCpfCliente(clienteDTO_POST.getCpfCliente()) != null) {
			throw new CpfException();
		}
		Endereco endereco = enderecoService.buscar(clienteDTO_POST.getCepEndereco(),
				clienteDTO_POST.getNumeroEndereco(), clienteDTO_POST.getComplementoEndereco());

		Cliente clienteBanco = new Cliente(clienteDTO_POST, endereco);

		clienteRepository.save(clienteBanco);
		mailConfig.sendEmailCadastro(clienteBanco);
		return clienteBanco;
	}

	@Transactional
	public Optional<Cliente> PutCliente(Cliente cliente, Long id) {
		Optional<Cliente> clienteTemp = clienteRepository.findById(id);
		if (clienteTemp.isPresent()) {
			cliente = new Cliente(clienteTemp.get().getIdCliente(), cliente);
			cliente = clienteRepository.saveAndFlush(cliente);
			return Optional.of(cliente);
		}
		return null;
	}

	public Boolean DeleteCliente(Long id) {
		Optional<Cliente> categoriaTemp = clienteRepository.findById(id);
		if (!categoriaTemp.isPresent()) {
			return false;
		}
		clienteRepository.deleteById(id);
		return true;
	}

}