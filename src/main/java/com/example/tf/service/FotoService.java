package com.example.tf.service;

import java.io.IOException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.tf.domain.Foto;
import com.example.tf.domain.Produto;
import com.example.tf.repository.FotoRepository;

@Service
public class FotoService {
	@Autowired
	private FotoRepository fotoRepository;
	public Foto inserir(Produto produto, MultipartFile file) throws IOException{
	Foto foto = new Foto();
	foto.setNome(file.getName());
	foto.setTipo(file.getContentType());
	foto.setDados(file.getBytes());
	foto.setProduto(produto);
	return fotoRepository.save(foto);
	}
	@Transactional
	public Foto buscarPorIdProduto(Long id) {
	Produto produto = new Produto();
	produto.setIdProduto(id);
	Optional<Foto> foto = fotoRepository.findByProduto(produto);
	if (!foto.isPresent()){
	return null;
	}
	return foto.get();
	}

}