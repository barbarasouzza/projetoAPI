package com.example.tf.DTO;

import java.time.LocalDate;
import java.util.List;

import com.example.tf.domain.Cliente;

public class PedidoDTO_POST {

	private LocalDate dataPedido;
	private LocalDate dataEntregaPedido;
	private LocalDate dataEnvioPedido;
	private String status; 
	private Cliente cliente;
	private List<ItemPedidoDTO_1> itemPedidoDTO_1;
	
	public PedidoDTO_POST() {
		super();
	}

	public PedidoDTO_POST(LocalDate dataPedido, LocalDate dataEntregaPedido, LocalDate dataEnvioPedido, String status,
			Cliente cliente, List<ItemPedidoDTO_1> itemPedidoDTO_1) {
		super();
		this.dataPedido = dataPedido;
		this.dataEntregaPedido = dataEntregaPedido;
		this.dataEnvioPedido = dataEnvioPedido;
		this.status = status;
		this.cliente = cliente;
		this.itemPedidoDTO_1 = itemPedidoDTO_1;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEntregaPedido() {
		return dataEntregaPedido;
	}

	public void setDataEntregaPedido(LocalDate dataEntregaPedido) {
		this.dataEntregaPedido = dataEntregaPedido;
	}

	public LocalDate getDataEnvioPedido() {
		return dataEnvioPedido;
	}

	public void setDataEnvioPedido(LocalDate dataEnvioPedido) {
		this.dataEnvioPedido = dataEnvioPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedidoDTO_1> getItemPedidoDTO_POST() {
		return itemPedidoDTO_1;
	}

	public void setItemPedidoDTO_POST(List<ItemPedidoDTO_1> itemPedidoDTO_1) {
		this.itemPedidoDTO_1 = itemPedidoDTO_1;
	}
	
}
