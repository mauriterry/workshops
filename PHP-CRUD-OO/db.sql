create database Agenda;
use Agenda;

create table Localidad(
	id int PRIMARY KEY,
	nombre varchar(20)
)ENGINE=InnoDB;

insert into Localidad values (1,'BOSA');
insert into Localidad values (2,'SUBA');
insert into Localidad values (3,'USME');
insert into Localidad values (4,'CIUDAD BOLIVAR');
insert into Localidad values (5,'KENNEDY');
insert into Localidad values (6,'SAN CRISTOBAL');
insert into Localidad values (7,'USAQUEN');
insert into Localidad values (8,'RAFAEL URIBE');
insert into Localidad values (9,'ENGATIVA');
insert into Localidad values (10,'FONTIBON');
insert into Localidad values (11,'SANTA FE');
insert into Localidad values (12,'CHAPINERO');
insert into Localidad values (13,'PUENTE ARANDA');
insert into Localidad values (14,'TUNJUELITO');
insert into Localidad values (15,'ANTONIO NARINO');
insert into Localidad values (16,'TEUSAQUILLO');
insert into Localidad values (17,'LocalidadS UNIDOS');
insert into Localidad values (18,'LOS MARTIRES');

create table Persona(
	cedula 			int PRIMARY KEY,
	nombre 			varchar(25),
	apellido 		varchar(25),
	apodo			varchar(25),
	fechaNacimiento	date,
	empresa			varchar(20),
	localidad 		int,
	genero			boolean,
	
	FOREIGN KEY (localidad) REFERENCES Localidad(id)
			ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB;

create table Telefono(
	numero 	varchar(12) PRIMARY KEY,
	cedula 		int,
	tipo 		varchar(10),
	
	FOREIGN KEY (cedula) REFERENCES Persona(cedula) 
			ON DELETE NO ACTION ON UPDATE CASCADE
)ENGINE=InnoDB;

create table Direccion(
	direccion 	varchar(12) PRIMARY KEY,
	cedula 		int,
	tipo 		varchar(10),
	
	FOREIGN KEY (cedula) REFERENCES Persona(cedula) 
		ON DELETE NO ACTION ON UPDATE CASCADE
)ENGINE=InnoDB;

create table Correo(
	direccion 	varchar(12) PRIMARY KEY,
	cedula 		int,
	tipo 		varchar(10),
	FOREIGN KEY (cedula) REFERENCES Persona(cedula) 
		ON DELETE NO ACTION ON UPDATE CASCADE
)ENGINE=InnoDB;

CREATE VIEW listarTelefonos AS SELECT CONCAT(Persona.nombre, ' ',Persona.apellido) as "Nombre", Persona.apodo as "Apodo", 
		Telefono.numero "Numero de Telefono", Telefono.tipo "Tipo" FROM Persona INNER JOIN Telefono on Telefono.cedula = Persona.cedula;

CREATE VIEW listarDirecciones AS SELECT CONCAT(Persona.nombre, ' ',Persona.apellido) as "Nombre", Persona.apodo as "Apodo", 
		Direccion.direccion "Direccion", Direccion.tipo "Tipo" FROM Persona INNER JOIN Direccion on Direccion.cedula = Persona.cedula;
		
CREATE VIEW contarTelefono AS SELECT CONCAT(Persona.nombre, ' ',Persona.apellido) as "Nombre", Persona.empresa as "Empresa", 
		COUNT(Direccion.direccion) "Cantidad Direcciones" FROM Persona INNER JOIN Direccion on Direccion.cedula = Persona.cedula GROUP BY Persona.cedula;
