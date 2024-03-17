create database comprayventa;
use comprayventa;
CREATE TABLE tipoDocumento (
    idDocumento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre NVARCHAR(500)
);
insert into tipoDocumento values(1,"CC");

create table tipoTransaccion(
idTransaccion int primary key not null auto_increment,
tipoTransaccion nvarchar(500)/*Compra o venta*/
);
insert into tipoTransaccion values(1,"Compra");

CREATE TABLE cargo (
    idCargo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre NVARCHAR(500)
);
insert into cargo values(1,"Admin");

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
        REFERENCES comprayventa.cargo (idCargo),
        estado boolean not null
);
insert into empleado values (1,"juan","sebastian","sanchez","arnedo","3054590280","jssa",1,true);
insert into empleado values (2,"junior","xx","Noguera","xx","0000","0000",1,true);

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
insert into login values(1,"juan",10,1,1);
insert into login values(2,"junior",11,1,2);

CREATE TABLE Productos (
    id_producto INT PRIMARY KEY not null,
    marca VARCHAR(100)not null,
    modelo varchar(200)not null,
    descripcion TEXT not null,
    precio float not null,
    estado boolean not null
);
insert into Productos values(1,"mazda","2022","buen estado",1000.00,true);

CREATE TABLE factura (
    idFactura INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fecha_emision DATE,
    id_cliente INT,
    total float,
    FOREIGN KEY (id_cliente)
        REFERENCES comprayventa.cliente (idCliente),
    tipoTransaccion INT,
    CONSTRAINT FOREIGN KEY (tipoTransaccion)
        REFERENCES comprayventa.tipoTransaccion (idTransaccion)
);
CREATE TABLE Detalles_factura (
    id_detalle INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_factura INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario float NOT NULL,
    FOREIGN KEY (id_factura)
        REFERENCES factura (idFactura),
    FOREIGN KEY (id_producto)
        REFERENCES Productos (id_producto)
);



select l.username,l.psw,l.cargoFK,CONCAT(e.primerNombre," ",e.segundoNombre," ",e.primerApellido," ",e.segundoApellido)
"empleado" from login l inner join empleado e on l.empleadoFK = e.idEmpleado where l.username ="junior" and l.psw =11;