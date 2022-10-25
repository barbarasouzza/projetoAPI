package com.example.tf.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_endereco", nullable = false)
	private Long idEndereco;
	
	@NotBlank
	@Size(max = 8)
	@Column(name="cep_endereco", nullable = false, length = 8)
	private String cepEndereco; 
	
	@NotBlank
	@Size(max = 80)
	@Column(name="rua_endereco", nullable = false, length = 80)
	private String ruaEndereco;
	
	@NotBlank
	@Size(max = 50)
	@Column(name="bairro_endereco", nullable = false, length = 50)
	private String bairroEndereco;
	
	@NotBlank
	@Size(max = 80)
	@Column(name="cidade_endereco", nullable = false, length = 80)
	private String cidadeEndereco;
	
	@NotBlank
	@Size(max = 20)
	@Column(name="numero_endereco", nullable = false, length = 20)
	private String numeroEndereco;
	
	@NotBlank
	@Size(max = 200)
	@Column(name="complemento_endereco", length = 200)
	private String complementoEndereco;
	
	@NotBlank
	@Size(max = 2)
	@Column(name = "uf_endereco", length = 2)
	private String UF;
	
	

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCepEndereco() {
		return cepEndereco;
	}

	public void setCepEndereco(String cepEndereco) {
		this.cepEndereco = cepEndereco;
	}

	public String getRuaEndereco() {
		return ruaEndereco;
	}

	public void setRuaEndereco(String ruaEndereco) {
		this.ruaEndereco = ruaEndereco;
	}

	public String getBairroEndereco() {
		return bairroEndereco;
	}

	public void setBairroEndereco(String bairroEndereco) {
		this.bairroEndereco = bairroEndereco;
	}

	public String getCidadeEndereco() {
		return cidadeEndereco;
	}

	public void setCidadeEndereco(String cidadeEndereco) {
		this.cidadeEndereco = cidadeEndereco;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEndereco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(idEndereco, other.idEndereco);
	}
	
	
	
}
