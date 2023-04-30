CREATE TABLE tb_cursos_usuarios
(
    id SERIAL not null,
    curso_id integer not null,
    usuario_id integer not null,
    primary key (id)
);