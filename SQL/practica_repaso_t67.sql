--1
create user pruebas
identified by pruebas
default tablespace users
temporary tablespace temp
quota unlimited on users;

grant create table, create session to pruebas;

--2
create table estudiante (
nia 	number(8)
	constraint estudiante_pk primary key,
nombre 	varchar2(50)
	constraint estudiante_nombre_vnn not null
);

--3
insert into estudiante
values (12345678, 'Manolito Computer');

--4
alter table estudiante
add (fnac date);

--5
insert into estudiante
values (11111111, 'Carmen Mouse', '30/09/08');

--6 (falla)
insert into estudiante
values (22222222, null, null);

--7
update 	estudiante
set 	fnac = '01/08/01'
where   nia = 12345678;

--8
delete	estudiante
where 	fnac < '01/01/05';

--9
alter table estudiante
drop constraint estudiante_nombre_vnn;

--10
insert into estudiante
values (22222222, null, null);

--extra
delete 	estudiante
where 	fnac is null;

--11 (falla)
alter table estudiante
add (constraint estudiante_nombre_vnn check (nombre is not null));

alter table estudiante
modify (nombre varchar2(50) constraint estudiante_nombre_vnn not null);

--12
alter table estudiante
add (constraint estudiante_nombre_unique unique (nombre));

--13
create table asignatura (
cod 		varchar2(7)
		constraint asignatura_pk primary key,
nombre 		varchar2(50),
creditos 	number(5,2)
);

--14
insert into asignatura
values ('BD', 'Bases de datos', 100);

--15 (falla)
alter table asignatura
add (hsem number(2) constraint asignatura_hsem_vnn not null);

--16
create table matricula (
nia 	number(8)
	constraint matricula_estudiante_fk references estudiante,
cod 	varchar2(7)
	constraint matricula_asignatura_fk references asignatura,
nota 	number(4,2),
constraint matricula_pk primary key (nia, cod)
);

--17
insert into matricula
values (11111111, 'BD', null);

--18
insert into matricula
values (22222222, 'BD', 10);

--19
update 	matricula
set 	nota = nota / 2
where  	substr(to_char(nia), 0, 1) != '1';

--20
alter table matricula
drop constraint matricula_estudiante_fk
drop constraint matricula_asignatura_fk;

alter table matricula
modify (nia number(8) constraint matricula_estudiante_fk references estudiante on delete cascade,
	cod varchar2(7) constraint matricula_asignatura_fk references asignatura on delete cascade
);

--21
delete 	estudiante
where  	to_char(nia) like '%2%';

--22 (falla)
drop table estudiante;

--23
drop table matricula;

--24
drop table asignatura;