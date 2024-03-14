drop table equipo cascade constraints;
drop table ciclista cascade constraints;
drop table etapa cascade constraints;
drop table puerto cascade constraints;
drop table maillot cascade constraints;
drop table llevar cascade constraints;

create table equipo (
nomeq 		varchar2(25)
		constraint equipo_pk primary key,
director 	varchar2(100)
);

create table ciclista (
dorsal 	number(3)
	constraint ciclista_pk primary key,
nombre 	varchar2(30)
	constraint nombre_vnn not null,
edad 	number(2),
nomeq 	varchar2(25)
	constraint ciclista_equipo_fk references equipo (nomeq)
	constraint nomeq_vnn not null
);

create table etapa (
netapa 	number(2)
	constraint netapa_pk primary key,
km 	number(3),
salida 	varchar2(35),
llegada varchar2(35),
dorsal 	number(3)
	constraint etapa_ciclista_fk references ciclista (dorsal)
);

create table puerto (
nompuerto 	varchar2(25)
		constraint puerto_pk primary key,
altura 		number(4),
categoria 	char(1),
pendiente 	number(3,2),
netapa 		number(2)
		constraint puerto_etapa_fk references etapa (netapa)
		constraint netapa_vnn not null,
dorsal 		number(3)
		constraint puerto_ciclista_fk references ciclista (dorsal)
);

create table maillot (
codigo 	char(3)
	constraint maillot_pk primary key,
tipo 	varchar2(30),
color 	varchar2(20),
premio 	number(7)
);

create table llevar (
netapa 	number(2)
	constraint llevar_etapa_fk references etapa,
codigo 	char(3)
	constraint llevar_maillot_fk references maillot,
dorsal 	number(3)
	constraint llevar_ciclista_fk references ciclista
	constraint dorsal_vnn not null,
constraint llevar_pk primary key (netapa, codigo)
);
