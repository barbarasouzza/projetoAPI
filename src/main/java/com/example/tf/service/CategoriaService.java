package com.example.tf.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tf.DTO.CategoriaDTO;
import com.example.tf.domain.Categoria;
import com.example.tf.repository.CategoriaRepository;


@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Optional<Categoria> findById(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(categoria.isPresent()) {
		return categoria;
		}
		return null; 
	}

	@Transactional
	public Categoria PostCategoria(CategoriaDTO categoriaDTO) {
		Optional<Categoria> categoriaTemp = categoriaRepository.findByNomeCategoria(categoriaDTO.getNomeCategoria());
		if (!categoriaTemp.isPresent()) {
			Categoria categoria = new Categoria(categoriaDTO);
			categoriaRepository.save(categoria);
			return categoria;
		}
		return null;
	}

	public Optional<Categoria> PutCategoria(Categoria categoria, Long id) {
		Optional<Categoria> categoriaTemp = categoriaRepository.findById(id);
		if (categoriaTemp.isPresent()) {
			categoria.setIdCategoria(id);
			categoriaRepository.save(categoria);
			return Optional.of(categoria);
		}
		return null;
	}

	public Boolean Delete(Long id) {
		Optional<Categoria> categoriaTemp = categoriaRepository.findById(id);
		if (!categoriaTemp.isPresent()) {
			return false;
		}
		categoriaRepository.deleteById(id);
		return true;
	}

}
