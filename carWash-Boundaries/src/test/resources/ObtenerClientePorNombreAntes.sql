Delete from turnos;
Delete from vehiculos;
Delete from clientes;

alter SEQUENCE "seq_vehiculo" restart with 1;
alter SEQUENCE "seq_turno" restart with 1;
alter SEQUENCE "seq_cliente" restart with 1;


INSERT INTO clientes(id_cliente,barrio,documento,domicilio,nombre) VALUES (nextval('seq_cliente'), 'Las Torres', '35678908','Chilecito','Bautista');
INSERT INTO clientes(id_cliente,barrio,documento,domicilio,nombre) VALUES (nextval('seq_cliente'), 'Paiman Sur', '56890098','Chilecito','Bautista');
INSERT INTO clientes(id_cliente,barrio,documento,domicilio,nombre) VALUES (nextval('seq_cliente'), 'EL Asfalto', '30987654','Davila San Roman','Lucas');

