create table if not exists tb_consumerloan (
    id int,
    descripcion varchar(100) not null,
    estado int default 1,
    fecha datetime
);