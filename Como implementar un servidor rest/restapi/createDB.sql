create table Marca (marca  bigserial not null, mail varchar(255), nombre varchar(255), 
	primary key (marca));

create table Producto (producto  bigserial not null, descripcion varchar(255), marca bigint not null, 
	primary key (producto));

alter table if exists Producto add constraint FK6yfj7esubk6nl4y4xde8hw3xa 
	foreign key (marca) references Marca;

insert into Marca (mail, nombre) values 
  ('ford@gmail.com', 'Ford'),
  ('fiat@gmail.com', 'Fiat'),
  ('vw@gmail.com', 'VW');

insert into Producto (descripcion, marca) values 
  ('Territory', 1),
  ('Toro', 2),
  ('Golf', 3),
  ('Ranger', 1),
  ('Cronos', 2),
  ('Amarok', 3),
  ('Kuga', 1),
  ('Moby', 2),
  ('T-Cross', 3);
