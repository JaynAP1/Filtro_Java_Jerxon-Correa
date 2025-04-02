## Aldeas

Proyecto filtro de java en el que establecemos un sistema crud para las misiones de una aldea de ninjas.
```sql
 create database `brwhnvouktlyex7hdtjy`;
use `brwhnvouktlyex7hdtjy`;

create table if not exists ninja(
	id int primary key auto_increment,
    nombre varchar(60) not null,
    rango varchar(1) not null,
    aldea varchar (60) not null
);
create table if not exists mision(
	id int primary key auto_increment,
    descripcion varchar(255) not null,
    rango varchar(1) not null,
    completada tinyint not null,
    recompensa int not null
);	
create table if not exists misionNinja(
	id int primary key auto_increment,
	id_ninja int not null,
    id_mision int not null,
    fecha_inicio varchar(100),
    fecha_fin varchar(100),
    foreign key (id_ninja) references ninja(id),
    foreign key (id_mision) references mision(id)    
);
create table if not exists habilidad(
	id int primary key auto_increment,
	id_ninja int not null,
    nombre varchar(60) not null,
    descripcion varchar (255) not null,
    foreign key (id_ninja) references ninja(id)
);

insert into ninja (nombre, rango, aldea) values ("Jerxon","E","Aldea de la hoja");
insert into habilidad(id_ninja, nombre, descripcion) values(1,"Dragones de agua","crea un gran dragon de agua que ataca a un objetivo");
insert into habilidad(id_ninja, nombre, descripcion) values(1,"Muralla de agua","crea una gran muralla de agua que es capaz de detener cualqui");

insert into ninja (nombre, rango, aldea) values ("Jose","E","Aldea de la hoja");
insert into habilidad(id_ninja, nombreHabilidad, descripcion) values(2,"Dragones de fuego","crea un gran dragon de fuego que ataca a un objetivo");
insert into habilidad(id_ninja, nombreHabilidad, descripcion) values(2,"Muralla de fuego","crea una gran muralla de fuego que es capaz de detener cualqui");


insert into mision (descripcion, rango,completada, recompensa)values ("gran mision de alto desempeño muy peligrosa", "E",1,1000);
insert into mision (descripcion, rango,completada, recompensa)values ("Atrapar un gato", "E",0,200);
insert into mision (descripcion, rango,completada, recompensa)values ("Atrapar un perro", "E",0,200);

insert into mision (descripcion, rango,completada, recompensa)values ("Atrapar una iguana", "E",0,200);

update mision set completada = 2 where id = 2;

select * from misionNinja inner join mision on misionNinja.id_mision = mision.id where id_ninja = 1 and mision.completada = 1;


insert into misionNinja(id_ninja, id_mision, fecha_inicio, fecha_fin) values(1,1,"2024-11-10","2024-12-10");
insert into misionNinja(id_ninja, id_mision, fecha_inicio, fecha_fin) values(1,2,"2024-11-10","0");


select * from misionNinja inner join mision on misionNinja.id_mision = mision.id;
select * from misionNinja inner join mision on misionNinja.id_mision = mision.id where id_ninja = 1 and fecha_fin = "0";

update misionNinja set fecha_fin = "2025-01-11" where id = 2;

select * from ninja inner join habilidad on ninja.id = habilidad.id_ninja;
```
