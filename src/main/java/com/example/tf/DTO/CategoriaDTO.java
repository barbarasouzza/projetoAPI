package com.example.tf.DTO;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.tf.domain.Categoria;

public class CategoriaDTO {
	
	
	private String nomeCategoria;
	private String descricaoCategoria;
	
	public CategoriaDTO() {
		super();
	}

	
	public CategoriaDTO(@NotBlank @Size(max = 30) String nomeCategoria,
			@NotBlank @Size(max = 200) String descricaoCategoria) {
		super();
		this.nomeCategoria = nomeCategoria;
		this.descricaoCategoria = descricaoCategoria;
	}


	public CategoriaDTO(Optional<Categoria> categoria) {
		this.nomeCategoria = categoria.get().getNomeCategoria();
		this.descricaoCategoria = categoria.get().getDescricaoCategoria();
	}
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}
	
	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}
	
	
}
