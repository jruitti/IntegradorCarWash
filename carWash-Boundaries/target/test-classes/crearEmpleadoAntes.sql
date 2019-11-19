Delete from turnos;
Delete from vehiculos;
Delete from clientes;
DELETE from empleados;

alter SEQUENCE "seq_vehiculo" restart with 1;
alter SEQUENCE "seq_turno" restart with 1;
alter SEQUENCE "seq_cliente" restart with 1;
alter SEQUENCE "seq_empleado" RESTART WITH 1;