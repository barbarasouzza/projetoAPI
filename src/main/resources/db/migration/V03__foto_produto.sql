create table foto (
id_foto serial primary key,
dados bytea,
tipo varchar(100),
nome varchar(100),
id_produto bigint,
foreign key (id_produto) references produto(id_produto)
);