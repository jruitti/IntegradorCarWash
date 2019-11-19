DELETE from empleados;

alter SEQUENCE "seq_empleado" RESTART WITH 1;

Insert into empleados(id_empleado, nombre, legajo) VALUES (nextval('seq_empleado'), 'juan', 123345);
Insert into empleados(id_empleado, nombre, legajo) VALUES (nextval('seq_empleado'), 'jose', 765355);
Insert into empleados(id_empleado, nombre, legajo) VALUES (nextval('seq_empleado'), 'juan', 987763);
Insert into empleados(id_empleado, nombre, legajo) VALUES (nextval('seq_empleado'), 'pepe', 123642);