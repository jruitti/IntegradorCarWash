Delete from turnos;
Delete from vehiculos;
Delete from clientes;

alter SEQUENCE "seq_vehiculo" restart with 1;
alter SEQUENCE "seq_turno" restart with 1;
alter SEQUENCE "seq_cliente" restart with 1;


INSERT INTO clientes(id_cliente,barrio,documento,domicilio,nombre) VALUES (nextval('seq_cliente'), 'Cable Carril', '34724669','La Mejicana 56','Matías de la Fuente');
INSERT INTO clientes(id_cliente,barrio,documento,domicilio,nombre) VALUES (nextval('seq_cliente'), 'Las Torres', '35678908','Chilecito','Bautista');
INSERT INTO clientes(id_cliente,barrio,documento,domicilio,nombre) VALUES (nextval('seq_cliente'), 'Paiman Sur', '56890098','Chilecito','Bautista');
INSERT INTO vehiculos (id_vehiculo, marca, matricula, modelo, cliente_id) VALUES (nextval('seq_vehiculo'), 'Toyota Etios', 'NRP374', '2016', 1);
INSERT INTO vehiculos (id_vehiculo, marca, matricula, modelo, cliente_id) VALUES (nextval('seq_vehiculo'), 'Ford Escort', 'UDQ707', '1995', 2);
INSERT INTO vehiculos (id_vehiculo, marca, matricula, modelo, cliente_id) VALUES (nextval('seq_vehiculo'), 'Fiat Siena', 'IZI243', '2010', 3);
