package com.example.tf.service;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.tf.DTO.ProdutoDTO;
import com.example.tf.domain.Produto;
import com.example.tf.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	FotoService fotoService;

	public List<ProdutoDTO> findAll() {
		List<Produto> produtos = produtoRepository.findAll();
		List<ProdutoDTO> dtos = new ArrayList<>();
		for(Produto produto : produtos) {
			ProdutoDTO dto = adicionarImagemUri(produto);
			dtos.add(dto);
		}
		return dtos;
	}
	
	

	public Optional<Produto> findById(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return produto;
		}
		return null;
	}

	@Transactional
	public Produto PostProduto(ProdutoDTO produtoDTO) {
		Optional<Produto> produtoTemp = produtoRepository.findByNomeProduto(produtoDTO.getNomeProduto());
		if (produtoTemp.isPresent()) {
			return null;
		}
		Produto produto = new Produto(produtoDTO);
		produtoRepository.save(produto);
		return produto;
	}

	public Optional<Produto> PutProduto(ProdutoDTO produtoDTO, Long id) {
		Optional<Produto> produtoTemp = produtoRepository.findById(id);
		if (produtoTemp.isPresent()) {
			Produto produto = new Produto(produtoDTO, produtoTemp.get().getIdProduto());
			produto = produtoRepository.save(produto);
			return Optional.of(produto);
		}
		return null;
	}

	public Boolean Delete(Long id) {
		Optional<Produto> produtoTemp = produtoRepository.findById(id);
		if (produtoTemp.isPresent()) {
			produtoRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public ProdutoDTO adicionarImagemUri(Produto produto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produtos/{id}/foto")
				.buildAndExpand(produto.getIdProduto()).toUri();
		ProdutoDTO dto = new ProdutoDTO();
		dto.setNomeProduto(produto.getNomeProduto());
		dto.setDescricaoProduto(produto.getDescricaoProduto());
		dto.setQuantidadeEstoqueProduto(produto.getQuantidadeEstoqueProduto());
		dto.setDataCadastroProduto(produto.getDataCadastroProduto());
		dto.setValorUnitarioProduto(produto.getValorUnitarioProduto());
		dto.setUrl(uri.toString());
		return dto;
	}
	
	public ProdutoDTO buscar(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return adicionarImagemUri(produto.get());
	}

	public ProdutoDTO inserir(Produto produto, MultipartFile file) throws IOException {
		produto = produtoRepository.save(produto);
		fotoService.inserir(produto, file);
		return adicionarImagemUri(produto);
	}
}
