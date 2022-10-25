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

import com.example.tf.DTO.CategoriaDTO;

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_categoria", nullable = false)
	private Long idCategoria;
	
	@NotBlank
	@Size(max = 30)
	@Column(name="nome_categoria", nullable = false, unique = true, length = 30)
	private String nomeCategoria;

	@NotBlank
	@Size(max = 200)
	@Column(name="descricao_categoria", length = 200)
	private String descricaoCategoria;

	
	
	public Categoria() {
		super();
	}

	public Categoria(CategoriaDTO categoriaDTO) {
		this.nomeCategoria = categoriaDTO.getNomeCategoria();
		this.descricaoCategoria = categoriaDTO.getDescricaoCategoria();
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCategoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(idCategoria, other.idCategoria);
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

		
	
}
