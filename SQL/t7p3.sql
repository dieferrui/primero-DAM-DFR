--1
select 	A.codart, A.descrip, A.precio
from 	articulo A, articulo A2
where 	A.precio > A2.precio and
	A2.codart = 'SATF4';
	
--2
select 	F.codcli, F.fecha, F2.fecha
from 	factura F, factura F2
where 	F.fecha > F2.fecha and
	F.codcli = 96 and
	F2.codfac = 26
order by F.fecha asc;

--3
select 	distinct F.codfac
from 	factura_linea F, factura_linea F2
where 	F.codart = F2.codart and
	F2.codfac = 26;
	
--4
select 	C.codcli, C.nombre, C.codpostal
from 	cliente C, cpostal CP
where 	C.codpostal = CP.codpostal and
	CP.codloc = '53596';
	
--5
select 	C.codcli, C.nombre, C.codpostal, L.nombre, L.codprov
from 	cliente C, cpostal CP, localidad L
where 	C.codpostal = CP.codpostal and
	CP.codloc = L.codloc and
	lower(L.nombre) = 'villarreal';
	
--6
select 	L.codloc, L.nombre
from 	localidad L, provincia P
where 	L.nombre like 'V%' and
	P.nombre like 'Z%G%' and
	L.codprov = P.codprov;