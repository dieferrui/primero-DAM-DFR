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
