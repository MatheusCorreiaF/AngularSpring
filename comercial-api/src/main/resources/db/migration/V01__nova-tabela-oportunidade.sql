create table oportunidade(
id bigint auto_increment not null primary key,
nome_prospecto varchar(80) not null,
descricao varchar(200) not null,
valor decimal(10,2)
);