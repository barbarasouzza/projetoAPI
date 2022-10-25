CREATE TABLE categoria(
	id_categoria serial PRIMARY KEY,
	nome_categoria varchar(30) NOT NULL UNIQUE,
	descricao_categoria varchar(200)
);
	
CREATE TABLE produto(
	id_produto serial PRIMARY KEY,
	nome_produto varchar(30) NOT NULL UNIQUE,
	descricao_produto varchar(200),
	quantidade_estoque_produto int,
	data_cadastro_produto date,
	valor_unitario_produto REAL NOT NULL,
	imagem_produto bytea,
	id_categoria int REFERENCES categoria(id_categoria)
);

CREATE TABLE endereco(
	id_endereco serial PRIMARY KEY,
	cep_endereco varchar(8) NOT NULL,
	rua_endereco varchar(80) NOT NULL,
	bairro_endereco varchar(50) NOT NULL,
	cidade_endereco varchar(80) NOT NULL,
	numero_endereco varchar(20) NOT NULL,
	complemento_endereco varchar(80),
	uf_endereco varchar(2) NOT NULL
);

CREATE TABLE cliente(
	id_cliente serial PRIMARY KEY,
	nome_completo_cliente varchar(50) NOT NULL,
	email_cliente varchar(80) NOT NULL unique,
	cpf_cliente varchar(11) NOT NULL unique,
	telefone_cliente varchar(40) NOT NULL,
	data_nascimento_cliente date,
	id_endereco int REFERENCES endereco(id_endereco) NOT NULL
);
	
CREATE TABLE pedido(
	id_pedido serial PRIMARY KEY,
	data_pedido date NOT NULL,
	data_entrega_pedido date,
	data_envio_pedido date,
	status varchar(1) NOT NULL,
	valor_total_pedido REAL NOT NULL,
	id_cliente int REFERENCES cliente(id_cliente)
);	
	
	CREATE TABLE itemPedido(
	id_item_pedido serial PRIMARY KEY,
	quantidade_item_pedido int NOT NULL,
	preco_venda_item_pedido REAL NOT NULL, 
	percentual_desconto_item_pedido REAL NOT NULL,
	valor_bruto_item_pedido REAL NOT NULL,	
	valor_liquido_item_pedido REAL NOT NULL,	
	id_produto int REFERENCES produto(id_produto) NOT NULL,
	id_pedido int REFERENCES pedido(id_pedido)NOT NULL
);
	
	
	
	
	
	