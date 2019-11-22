Delete from turnos;
Delete from vehiculos;
Delete from clientes;
DELETE from empleados;

alter SEQUENCE "seq_empleado" RESTART WITH 1;
alter SEQUENCE "seq_vehiculo" restart with 1;
alter SEQUENCE "seq_turno" restart with 1;
alter SEQUENCE "seq_cliente" restart with 1;


INSERT INTO clientes(id_cliente,barrio,documento,domicilio,nombre) VALUES (nextval('seq_cliente'), 'Cable Carril', '34724669','La Mejicana 56','Matías de la Fuente');
INSERT INTO clientes(id_cliente,barrio,documento,domicilio,nombre) VALUES (nextval('seq_cliente'), 'Las Torres', '35678908','Chilecito','Bautista');
INSERT INTO clientes(id_cliente,barrio,documento,domicilio,nombre) VALUES (nextval('seq_cliente'), 'Paiman Sur', '56890098','Chilecito','Bautista');
INSERT INTO clientes(id_cliente,barrio,documento,domicilio,nombre) VALUES (nextval('seq_cliente'), 'Porahi', '3322646','Los pinos 22','Pepe');
INSERT INTO clientes(id_cliente,barrio,documento,domicilio,nombre) VALUES (nextval('seq_cliente'), 'Poralla', '35228908','Los álamos 523','Pipo');
INSERT INTO clientes(id_cliente,barrio,documento,domicilio,nombre) VALUES (nextval('seq_cliente'), 'Paiman Sur', '36891008','Los robles 113 ','Pepo');

INSERT INTO vehiculos (id_vehiculo, marca, matricula, modelo, cliente_id) VALUES (nextval('seq_vehiculo'), 'Toyota Etios', 'NRP374', '2016', 1);
INSERT INTO vehiculos (id_vehiculo, marca, matricula, modelo, cliente_id) VALUES (nextval('seq_vehiculo'), 'Ford Escort', 'UDQ707', '1995', 1);
INSERT INTO vehiculos (id_vehiculo, marca, matricula, modelo, cliente_id) VALUES (nextval('seq_vehiculo'), 'Fiat Siena', 'IZI243', '2010', 1);
INSERT INTO vehiculos (id_vehiculo, marca, matricula, modelo, cliente_id) VALUES (nextval('seq_vehiculo'), 'Ford Falcon', 'RKF574', '1980', 2);
INSERT INTO vehiculos (id_vehiculo, marca, matricula, modelo, cliente_id) VALUES (nextval('seq_vehiculo'), 'Fiat Toro', 'TDV123', '2019', 2);
INSERT INTO vehiculos (id_vehiculo, marca, matricula, modelo, cliente_id) VALUES (nextval('seq_vehiculo'), 'Peugeot 405', 'RWE696', '2012', 3);

Insert into empleados(id_empleado, nombre, legajo) VALUES (nextval('seq_empleado'), 'juan', 0303455);
Insert into empleados(id_empleado, nombre, legajo) VALUES (nextval('seq_empleado'), 'jose', 0303456);
Insert into empleados(id_empleado, nombre, legajo) VALUES (nextval('seq_empleado'), 'pedro', 0303457);
Insert into empleados(id_empleado, nombre, legajo) VALUES (nextval('seq_empleado'), 'pablo', 0303458);
Insert into empleados(id_empleado, nombre, legajo) VALUES (nextval('seq_empleado'), 'pachu', 0303459);

insert into turnos(id_pedido,fecha,precio,empleado_id,vehiculo_id) values (nextval('seq_turno'),to_date('20191120','YYYYMMDD'),150.00,2,1);
insert into turnos(id_pedido,fecha,precio,empleado_id,vehiculo_id) values (nextval('seq_turno'),to_date('20191121','YYYYMMDD'),150.00,3,2);
insert into turnos(id_pedido,fecha,precio,empleado_id,vehiculo_id) values (nextval('seq_turno'),to_date('20191201','YYYYMMDD'),150.00,2,3);
insert into turnos(id_pedido,fecha,precio,empleado_id,vehiculo_id) values (nextval('seq_turno'),to_date('20191202','YYYYMMDD'),150.00,2,4);
insert into turnos(id_pedido,fecha,precio,empleado_id,vehiculo_id) values (nextval('seq_turno'),to_date('20191205','YYYYMMDD'),150.00,3,5);
insert into turnos(id_pedido,fecha,precio,empleado_id,vehiculo_id) values (nextval('seq_turno'),to_date('20191219','YYYYMMDD'),150.00,2,6);
insert into turnos(id_pedido,fecha,precio,empleado_id,vehiculo_id) values (nextval('seq_turno'),to_date('20191219','YYYYMMDD'),150.00,1,1);