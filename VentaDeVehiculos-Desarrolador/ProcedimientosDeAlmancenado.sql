/*PROCEDIMIENTOS DE ALMACENADO*/
delimiter //
create procedure login(Pusername nvarchar(500),Ppsw nvarchar(500))
begin
select l.username,l.psw,l.cargoFK,CONCAT(e.primerNombre," ",e.segundoNombre," ",e.primerApellido," ",e.segundoApellido)
"empleado" from login l inner join empleado e on l.empleadoFK = e.idEmpleado where l.username = Pusername and l.psw =Ppsw;
end;//

//
create procedure Reportedelosvehículoscompradosenunrangodefecha()
begin
SELECT *
FROM factura
WHERE fecha_compra BETWEEN 'fecha_inicio' AND 'fecha_fin'
and tipoTransaccion=1;
end;//

//create procedure crearVehiculo(P_marca VARCHAR(100),P_modelo varchar(200),P_descripcion TEXT,P_precio float,P_estado boolean)
begin
insert into Productos (marca,modelo,descripcion,precio,estado) values(P_marca,P_modelo,P_descripcion,P_precio,P_estado);
end;//
