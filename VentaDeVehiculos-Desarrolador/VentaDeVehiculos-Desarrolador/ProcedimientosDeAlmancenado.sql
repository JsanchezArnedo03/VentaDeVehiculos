/*PROCEDIMIENTOS DE ALMACENADO*/
delimiter //
create procedure login(Pusername nvarchar(500),Ppsw nvarchar(500))
begin
select l.username,l.psw,l.cargoFK,CONCAT(e.primerNombre," ",e.segundoNombre," ",e.primerApellido," ",e.segundoApellido)
"empleado" from login l inner join empleado e on l.empleadoFK = e.idEmpleado where l.username = Pusername and l.psw =Ppsw;
end;//
call login("junior",10);