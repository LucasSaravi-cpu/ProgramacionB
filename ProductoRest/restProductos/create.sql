
create table Marca (marca  bigserial not null, mail varchar(255), nombre varchar(255), 
	primary key (marca));

create table Producto (producto  bigserial not null, descripcion varchar(255), marca bigint not null, 
	primary key (producto));

alter table if exists Producto add constraint FK6yfj7esubk6nl4y4xde8hw3xa 
	foreign key (marca) references Marca;

