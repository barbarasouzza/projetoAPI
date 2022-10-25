package com.example.tf.DTO;

import com.example.tf.domain.ItemPedido;
import com.example.tf.domain.Produto;

public class ItemPedidoDTO_GET {

	

	private Long idItemPedido;
	private Integer quantidadeItemPedido; 
	private Double precoVendaItemPedido; 
	private Double percentualDescontoItemPedido; 
	private Double valorBrutoItemPedido; 
	private Double valorLiquidoItemPedido; 
	private Produto produto;
	
	
	
	public ItemPedidoDTO_GET(Long idItemPedido, Integer quantidadeItemPedido, Double precoVendaItemPedido,
			Double percentualDescontoItemPedido, Double valorBrutoItemPedido, Double valorLiquidoItemPedido,
			Produto produto) {
		super();
		this.idItemPedido = idItemPedido;
		this.quantidadeItemPedido = quantidadeItemPedido;
		this.precoVendaItemPedido = precoVendaItemPedido;
		this.percentualDescontoItemPedido = percentualDescontoItemPedido;
		this.valorBrutoItemPedido = valorBrutoItemPedido;
		this.valorLiquidoItemPedido = valorLiquidoItemPedido;
		this.produto = produto;
	}
	
	public ItemPedidoDTO_GET(ItemPedido itemPedido) {
		this.idItemPedido = itemPedido.getIdItemPedido();
		this.quantidadeItemPedido = itemPedido.getQuantidadeItemPedido();
		this.precoVendaItemPedido = itemPedido.getPrecoVendaItemPedido();
		this.percentualDescontoItemPedido = itemPedido.getPercentualDescontoItemPedido();
		this.valorBrutoItemPedido = itemPedido.getValorBrutoItemPedido();
		this.valorLiquidoItemPedido = itemPedido.getValorLiquidoItemPedido();
		this.produto = itemPedido.getProduto();
	}
	
	public ItemPedidoDTO_GET() {
		super();
	}
	public Long getIdItemPedido() {
		return idItemPedido;
	}
	public void setIdItemPedido(Long idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	public Integer getQuantidadeItemPedido() {
		return quantidadeItemPedido;
	}
	public void setQuantidadeItemPedido(Integer quantidadeItemPedido) {
		this.quantidadeItemPedido = quantidadeItemPedido;
	}
	public Double getPrecoVendaItemPedido() {
		return precoVendaItemPedido;
	}
	public void setPrecoVendaItemPedido(Double precoVendaItemPedido) {
		this.precoVendaItemPedido = precoVendaItemPedido;
	}
	public Double getPercentualDescontoItemPedido() {
		return percentualDescontoItemPedido;
	}
	public void setPercentualDescontoItemPedido(Double percentualDescontoItemPedido) {
		this.percentualDescontoItemPedido = percentualDescontoItemPedido;
	}
	public Double getValorBrutoItemPedido() {
		return valorBrutoItemPedido;
	}
	public void setValorBrutoItemPedido(Double valorBrutoItemPedido) {
		this.valorBrutoItemPedido = valorBrutoItemPedido;
	}
	public Double getValorLiquidoItemPedido() {
		return valorLiquidoItemPedido;
	}
	public void setValorLiquidoItemPedido(Double valorLiquidoItemPedido) {
		this.valorLiquidoItemPedido = valorLiquidoItemPedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
