package com.example.tf.DTO;

import java.time.LocalDate;

import com.example.tf.domain.Categoria;

public class ProdutoDTO {

	private String nomeProduto;
	private String descricaoProduto;
	private Integer quantidadeEstoqueProduto;
	private Double valorUnitarioProduto;
	private Categoria categoria;
	private LocalDate dataCadastroProduto;
	private String url;

	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(String nomeProduto, String descricaoProduto, Integer quantidadeEstoqueProduto,
			Double valorUnitarioProduto, LocalDate dataCadastroProduto, Categoria categoria) {
		super();
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.quantidadeEstoqueProduto = quantidadeEstoqueProduto;
		this.valorUnitarioProduto = valorUnitarioProduto;
		this.dataCadastroProduto = dataCadastroProduto;
		this.categoria = categoria;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Integer getQuantidadeEstoqueProduto() {
		return quantidadeEstoqueProduto;
	}

	public void setQuantidadeEstoqueProduto(Integer quantidadeEstoqueProduto) {
		this.quantidadeEstoqueProduto = quantidadeEstoqueProduto;
	}

	public Double getValorUnitarioProduto() {
		return valorUnitarioProduto;
	}

	public void setValorUnitarioProduto(Double valorUnitarioProduto) {
		this.valorUnitarioProduto = valorUnitarioProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public LocalDate getDataCadastroProduto() {
		return dataCadastroProduto;
	}

	public void setDataCadastroProduto(LocalDate dataCadastroProduto) {
		this.dataCadastroProduto = dataCadastroProduto;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



}