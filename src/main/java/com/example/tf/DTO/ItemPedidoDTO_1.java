package com.example.tf.DTO;

import com.example.tf.domain.Produto;

public class ItemPedidoDTO_1 {

	
	private Integer quantidadeItemPedido; 
	private Double percentualDescontoItemPedido; 
	private Produto produto;
	
	public ItemPedidoDTO_1() {
		super();
	}

	public ItemPedidoDTO_1(Integer quantidadeItemPedido, Double percentualDescontoItemPedido, Produto produto) {
		super();
		this.quantidadeItemPedido = quantidadeItemPedido;
		this.percentualDescontoItemPedido = percentualDescontoItemPedido;
		this.produto = produto;
	}

	public Integer getQuantidadeItemPedido() {
		return quantidadeItemPedido;
	}

	public void setQuantidadeItemPedido(Integer quantidadeItemPedido) {
		this.quantidadeItemPedido = quantidadeItemPedido;
	}

	public Double getPercentualDescontoItemPedido() {
		return percentualDescontoItemPedido;
	}

	public void setPercentualDescontoItemPedido(Double percentualDescontoItemPedido) {
		this.percentualDescontoItemPedido = percentualDescontoItemPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
