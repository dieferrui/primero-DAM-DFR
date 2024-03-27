insert into pieza
values ('A01', 'Armario', 'Rojo', 50);

insert into pieza
values ('S01', 'Sofa', 'Azul', 23.5);

insert into pieza
(cod_pieza, nombre, color)
values ('E03', 'Estanteria', 'Verde');

insert into pieza
(cod_pieza, nombre, peso)
values ('S00', 'Silla', 120);

insert into pieza
(cod_pieza, nombre, color)
values ('A02', 'Armario', 'Azul');

insert into pieza
(cod_pieza, color, peso)
values ('M00', 'Azul', 30);

insert into pieza
values ('LP1', 'Lampara', 'Rojo', 2.5);

insert into vendedor2
(cod_ven, nomven, salario)
values ('V1', 'Genaro', 1500);

insert into vendedor2
values ('V2', 'Amelia', 3000, 'V1');

insert into vendedor2
values ('V3', 'Cinta', 1000, 'V4');

insert into vendedor2
(cod_ven, nomven, salario)
values ('V5', 'Juan', 1000);

insert into asignacion
values ('LP1', 'V1', '01/01/2004', '15/01/2004');

insert into asignacion
values ('LP1', 'V1', '21/03/2004', '15/06/2004');

insert into asignacion
(cod_pieza, cod_ven, fecha_inicio)
values ('A01', 'V1', '01/09/2004');

insert into asignacion
(cod_pieza, cod_ven, fecha_inicio)
values ('A01', 'V6', '01/02/2005');

insert into asignacion
values('LP1', 'V2', '01/03/2004', '01/08/2004');

insert into asignacion
(cod_pieza, cod_ven, fecha_inicio)
values ('M01', 'V2', '01/01/2005');

insert into asignacion
values ('S01', 'V1', '01/09/2004', '01/10/2004');

insert into asignacion
values ('S01', 'V2', null,  '23/02/2005');

insert into asignacion
values ('LP1', 'V5', '07/02/2005', '07/02/2005');

update 	pieza
set 	peso = peso/2
where 	lower(color) = 'amarillo';

delete 	vendedor2
where	cod_ven = 'V1';

delete 	pieza
where  	lower(color) = 'rojo';

delete 	asignacion;
delete 	vendedor2;
delete 	pieza;

COMMIT;
