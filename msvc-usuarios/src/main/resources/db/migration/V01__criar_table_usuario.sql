CREATE TABLE tb_usuarios
(
    id integer not null auto_increment,
    nome varchar(100) not null,
    email varchar(80) unique not null,
    password varchar(254) not null,
    primary key (id)
);