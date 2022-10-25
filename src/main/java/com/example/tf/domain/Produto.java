package com.example.tf.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.example.tf.DTO.ProdutoDTO;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_produto", nullable = false)
	private Long idProduto;
	
	@NotBlank
	@Size(max = 30)
	@Column(name="nome_produto", nullable = false, unique = true, length = 30)
	private String nomeProduto; 
	
	@NotBlank
	@Size(max = 200)
	@Column(name="descricao_produto", length = 200)
	private String descricaoProduto ;
	
	@NotNull
	@Column(name= "quantidade_estoque_produto")
	private Integer quantidadeEstoqueProduto;
	
	@Column(name= "data_cadastro_produto")
	private LocalDate dataCadastroProduto;
	
	@NotNull
	@Column(name = "valor_unitario_produto", nullable = false) 
	private Double valorUnitarioProduto;
	
	//imagemProduto bytea,
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	
	public Produto() {
		super();
	}
	
	public Produto(ProdutoDTO produtoDTO) {
		this.nomeProduto = produtoDTO.getNomeProduto();
		this.descricaoProduto = produtoDTO.getDescricaoProduto();
		this.quantidadeEstoqueProduto = produtoDTO.getQuantidadeEstoqueProduto();
		this.valorUnitarioProduto = produtoDTO.getValorUnitarioProduto();
		this.categoria = produtoDTO.getCategoria();
		this.dataCadastroProduto = LocalDate.now();
	
	}
	public Produto(ProdutoDTO produtoDTO, Long id) {
		this.nomeProduto = produtoDTO.getNomeProduto();
		this.descricaoProduto = produtoDTO.getDescricaoProduto();
		this.quantidadeEstoqueProduto = produtoDTO.getQuantidadeEstoqueProduto();
		this.valorUnitarioProduto = produtoDTO.getValorUnitarioProduto();
		this.categoria = produtoDTO.getCategoria();
		this.dataCadastroProduto = LocalDate.now();
		this.idProduto  = id;
	
	}
	
	

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
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

	public LocalDate getDataCadastroProduto() {
		return dataCadastroProduto;
	}

	public void setDataCadastroProduto(LocalDate dataCadastroProduto) {
		this.dataCadastroProduto = dataCadastroProduto;
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

	@Override
	public int hashCode() {
		return Objects.hash(idProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(idProduto, other.idProduto);
	}

	
}
