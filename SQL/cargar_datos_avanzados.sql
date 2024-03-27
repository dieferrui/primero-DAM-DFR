--ELIMINAR TABLAS ANTERIORES
drop table asignacion cascade constraints;
drop table vendedor2 cascade constraints;
drop table pieza cascade constraints;

--GENERAR TABLAS
create table pieza (
cod_pieza	varchar2(3)
		constraint pieza_pk primary key,
nombre 		varchar2(100)
		constraint nombre_pieza_vnn not null,
color 		varchar2(8)
		constraint color_chk
			check (lower(color) in ('rojo', 'azul', 'amarillo')),
peso 		number(5,2)
		constraint peso_chk
			check (peso >= 0 and peso <= 100)
);

create table vendedor2 (
cod_ven 	varchar2(2)
		constraint vendedor_pk primary key,
nomven 		varchar2(100)
		constraint nombre_vendedor_vnn not null
		constraint nombre_vendedor_uni unique,
salario 	number(6,2)
		default 600
		constraint salario_chk
			check (salario >= 0 and salario <= 3000),
jefe 		varchar2(2)
		constraint vendedor_vendedor_fk references vendedor2 (cod_ven)
);

create table asignacion (
cod_pieza 	varchar2(3)
		constraint asignacion_pieza_fk references pieza (cod_pieza)
			on delete cascade,
cod_ven 	varchar2(2)
		constraint asignacion_vendedor_fk references vendedor2 (cod_ven)
			on delete cascade,
fecha_inicio 	date
		default sysdate
		constraint fecha_inicio_vnn not null,
fecha_fin 	date,
constraint asignacion_pk primary key (cod_pieza, cod_ven, fecha_inicio),
constraint fecha_fin_chk check (fecha_fin > fecha_inicio)
);

--INSERTS EN PIEZA
insert into pieza
values ('A01', 'ARMARIO ZEN', 'rojo', 50);

insert into pieza
values ('A02', 'ARMARIO JUVENIL', 'AZUL', 23);

insert into pieza
values ('E01', 'ESTANTERIA ZEN', 'ROJO', 8);

insert into pieza
values ('E02', 'ESTANTERIA CLASICA', 'AMARILLO', 10);

insert into pieza
values ('S00', 'SILLA GENERICA', 'ROJO', 5);

insert into pieza
values ('M01', 'MESA COLONIAL', 'azul', 50);

insert into pieza
values ('LP1', 'LAMPARA PIE', 'AZUL', 0.5);

--INSERTS EN VENDEDOR
insert into vendedor2
(cod_ven, nomven, salario)
values ('V1', 'GENARO FERNANDEZ', 3000);

insert into vendedor2
values ('V2', 'AMELIA TES', 3000, 'V1');

insert into vendedor2
values ('V3', 'CINTIA RUS', 3000, 'V2');

insert into vendedor2
values ('V4', 'CARMELO RESAL', 1000, 'V1');

--INSERTS EN ASIGNACION
insert into asignacion
values ('LP1', 'V1', '01/01/2004', '15/01/2004');

insert into asignacion
values ('LP1', 'V1', '21/03/2004', '15/06/2004');

insert into asignacion
(cod_pieza, cod_ven, fecha_inicio)
values ('A01', 'V1', '01/09/2004');

insert into asignacion
values ('LP1', 'V2', '01/03/2004', '01/08/2004');

insert into asignacion
(cod_pieza, cod_ven, fecha_inicio)
values ('M01', 'V2', '01/01/2005');

insert into asignacion
(cod_pieza, cod_ven, fecha_inicio)
values ('A01', 'V3', '01/02/2005');

insert into asignacion
values ('E01', 'V2', '23/01/2005', '23/02/2005');

insert into asignacion
(cod_pieza, cod_ven, fecha_inicio)
values ('M01', 'V1', '07/02/2005');
