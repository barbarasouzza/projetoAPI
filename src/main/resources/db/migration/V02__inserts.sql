INSERT INTO categoria (nome_categoria, descricao_categoria) VALUES
 ('Mercearia', 'Setor de Mercearia'),
 ('Laticinios', 'Setor de Laticínios '),
 ('Bebida', 'Setor de Bebidas'),
 ('Limpeza', 'Setor de Limpeza')
 
  ;


INSERT INTO produto (nome_produto, descricao_produto, quantidade_estoque_produto, data_cadastro_produto,
  valor_unitario_produto, id_categoria) VALUES 
  ('Arroz', 'Arroz integral Tio João', 30, '2022-01-01', 5.98, 1),
  ('Feijão', 'Feijão Carreteiro', 15, '2022-01-01', 6.99,  1),
  ('Macarrão' , 'Macarrão integral Barilla', 20, '2022-01-01', 12.99,  1),
  ('Leite', 'Leite Desnatado Parmalat', 15, '2022-01-01',  4.99, 2),
  ('Danoninho', 'Danoninho de morango', 20, '2022-01-02',  8.7, 2),
  ('Manteiga', 'Manteiga Itambé', 25, '2022-01-01',  12.99, 2),
  ('Leite em pó', 'Leite em pó Molico', 13, '2022-01-01',  9.9, 2),
  ('Guaraná', 'Guaraná Antarctica dois litros', 13, '2022-01-01', 7.8,  3),
  ('Chá ice tea', 'Chá ice tea Leão sabor limão', 31, '2022-01-01', 5.69,  3),
  ('Energético', 'Red Bull energético', 20, '2022-01-01', 8.99, 3),
  ('Amaciante', 'Amaciante Comfort concentrado', 10, '2022-01-01', 14.6, 4),
  ('Água sanitária', 'Água sanitária Brillux', 5, '2022-01-01', 4.99,  4),
  ('Sabão em pó',  'Sabão em pó Omo', 13, '2022-01-01', 18.99, 4)

  ;

INSERT INTO endereco (cep_endereco, rua_endereco, bairro_endereco, cidade_endereco, numero_endereco,
 complemento_endereco, uf_endereco) VALUES 
('22420040','Rua Prudente de Morais','Ipanema','Rio de Janeiro','1117', 'apto 303','RJ'),
('20510052','Rua Uruguai','Tijuca', 'Rio de Janeiro','263', 'casa 1','RJ'),
('25655030','Rua Abreu Lima','Petrópolis', 'Rio de Janeiro','13', ' apto 202', 'RJ')

 ;


INSERT INTO cliente (nome_completo_cliente, email_cliente, cpf_cliente, telefone_cliente, data_nascimento_cliente, 
 id_endereco) VALUES
('Gabriela Paixão','gab@gmail.com','57890315874', '21954783456','1990-04-02',1),
('Edna Freitas','ednaf@gmail.com','67914804367', '21947381406','1989-07-08',2),
('Jorge Teixeira','jorget@gmail.com','98743263801','21954824932','1991-03-13',3)

 ;


INSERT INTO pedido (data_pedido, data_entrega_pedido, data_envio_pedido, status, valor_total_pedido, id_cliente)
VALUES
('2022-10-10', '2022-10-10', '2022-10-10','c' ,12.99, 1)


 ;

INSERT INTO itempedido (quantidade_item_pedido, preco_venda_item_pedido, percentual_desconto_item_pedido, valor_bruto_item_pedido, valor_liquido_item_pedido, id_produto, id_pedido)
VALUES
(1, 12.99, 0, 12.99, 12.99, 3, 1)

 ;

