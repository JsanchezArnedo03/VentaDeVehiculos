create database comprayventa;
use comprayventa;
CREATE TABLE tipoDocumento (
    idDocumento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre NVARCHAR(500)
);
CREATE TABLE cargo (
    idCargo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre NVARCHAR(500)
);
CREATE TABLE cliente (
    idCliente INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    primerNombre NVARCHAR(500) NOT NULL,
    segundoNombre NVARCHAR(500) NOT NULL,
    primerApellido NVARCHAR(500) NOT NULL,
    segundoApellido NVARCHAR(500) NOT NULL,
    telefono NVARCHAR(15) NOT NULL,
    email NVARCHAR(500) NOT NULL
);
CREATE TABLE empleado (
    idEmpleado INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    primerNombre NVARCHAR(500) NOT NULL,
    segundoNombre NVARCHAR(500) NOT NULL,
    primerApellido NVARCHAR(500) NOT NULL,
    segundoApellido NVARCHAR(500) NOT NULL,
    telefono NVARCHAR(15) NOT NULL,
    email NVARCHAR(500) NOT NULL,
    cargoFK INT,
    CONSTRAINT FOREIGN KEY (cargoFK)
        REFERENCES comprayventa.cargo (idCargo)
);
CREATE TABLE login (
    idLogin INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username NVARCHAR(500) NOT NULL,
    psw NVARCHAR(500) NOT NULL,
    cargoFk INT,
    CONSTRAINT FOREIGN KEY (cargoFk)
        REFERENCES comprayventa.cargo (idCargo),
    empleadoFK INT,
    CONSTRAINT FOREIGN KEY (empleadoFK)
        REFERENCES comprayventa.empleado(idEmpleado)
);	
insert into cargo values(1,"Admin");
insert into empleado values (1,"juan","sebastian","sanchez","arnedo","3054590280","jssa",1);
insert into empleado values (2,"junior","xx","Noguera","xx","0000","0000",1);
insert into login values(1,"juan",10,1,1);
insert into login values(2,"junior",11,1,2);
select l.username,l.psw,l.cargoFK,CONCAT(e.primerNombre," ",e.segundoNombre," ",e.primerApellido," ",e.segundoApellido)
"empleado" from login l inner join empleado e on l.empleadoFK = e.idEmpleado where l.username ="junior" and l.psw =11;