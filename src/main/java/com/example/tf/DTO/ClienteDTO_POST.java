package com.example.tf.DTO;

import java.time.LocalDate;


public class ClienteDTO_POST {
	
	
	private String nomeCompletoCliente; 
	private String emailCliente;
	private String cpfCliente; 
	private String telefoneCliente;
	private LocalDate dataNascimentoCliente;
	private String cepEndereco; 
	private String numeroEndereco;
	private String complementoEndereco;

	public ClienteDTO_POST() {
		super();
	}

	public ClienteDTO_POST(String nomeCompletoCliente, String emailCliente, String cpfCliente, String telefoneCliente,
			LocalDate dataNascimentoCliente, String cepEndereco, String numeroEndereco, String complementoEndereco) {
		super();
		this.nomeCompletoCliente = nomeCompletoCliente;
		this.emailCliente = emailCliente;
		this.cpfCliente = cpfCliente;
		this.telefoneCliente = telefoneCliente;
		this.dataNascimentoCliente = dataNascimentoCliente;
		this.cepEndereco = cepEndereco;
		this.numeroEndereco = numeroEndereco;
		this.complementoEndereco = complementoEndereco;
		
	}


	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public String getNomeCompletoCliente() {
		return nomeCompletoCliente;
	}

	public void setNomeCompletoCliente(String nomeCompletoCliente) {
		this.nomeCompletoCliente = nomeCompletoCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public LocalDate getDataNascimentoCliente() {
		return dataNascimentoCliente;
	}

	public void setDataNascimentoCliente(LocalDate dataNascimentoCliente) {
		this.dataNascimentoCliente = dataNascimentoCliente;
	}

	public String getCepEndereco() {
		return cepEndereco;
	}

	public void setCepEndereco(String cepEndereco) {
		this.cepEndereco = cepEndereco;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	
}
