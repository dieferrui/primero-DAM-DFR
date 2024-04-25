select 	E.*, D.*, E2.emp_no "Superior"
from 	emple E, depart D, emple E2
where 	E.dept_no = D.dept_no and
	E.dir = E2.emp_no;
	
--1
select 	A.codart, A.descrip
from 	articulo A, factura_linea F
where 	A.codart = F.codart and
	F.codfac = 26;
	
--2
select 	L.nombre, P.nombre "Provincia"
from 	localidad L, provincia P
where  	L.codprov = P.codprov and
	lower(L.nombre) like 'v%t'
order by P.nombre asc;

--3
select 	C.nombre, P.codloc
from 	cliente C, cpostal P
where 	C.codpostal = P.codpostal
order by P.codloc asc;

--4
select 	C.nombre, L.nombre "Localidad"
from 	cliente C, localidad L, cpostal P
where 	C.codpostal = P.codpostal and
	P.codloc = L.codloc
order by C.nombre asc;

--5
select 	V.nombre, V2.nombre "Superior"
from 	vendedor V, vendedor V2
where 	V.codjefe = V2.codven
order by V.nombre asc;

--6
select 	C.nombre, L.nombre "Localidad"
from 	cliente C, localidad L, provincia P, cpostal CP
where 	C.codpostal = CP.codpostal and
	CP.codloc = L.codloc and
	L.codprov = P.codprov and
	lower(P.nombre) = 'cuenca';
	
--7
select 	V.nombre, V2.nombre "Superior"
from 	vendedor V, vendedor V2, localidad L, cpostal C
where 	V.codjefe = v2.codven and
	V.codpostal = C.codpostal and
	C.codloc = L.codloc and
	lower(L.nombre) = 'montanejos';
	
--8
select 	V.nombre, L.nombre "Localidad", V2.nombre "Superior"
from 	vendedor V, vendedor V2, localidad L, provincia P, cpostal CP
where 	V.codjefe = V2.codven and
	V.codpostal = CP.codpostal and
	CP.codloc = L.codloc and
	L.codprov = P.codprov and
	lower(P.nombre) = 'castellon';
	
--9
select 	F.codfac, C.nombre "Nombre cliente", V.nombre "Nombre vendedor"
from 	factura F, cliente C, vendedor V
where 	F.codcli = C.codcli and
	F.codven = V.codven and
	F.codfac = 26;
	
--10
select 	C.nombre "Nombre cliente", V.nombre "Nombre vendedor", FL.*
from 	cliente C, vendedor V, factura_linea FL, factura F
where 	F.codfac = FL.codfac and
	F.codcli = C.codcli and
	F.codven = V.codven and
	F.codfac = 26;
	
--11
select 	distinct L.nombre "Nombre duplicado"
from 	localidad L, localidad L2
where 	L.nombre = L2.nombre and
	L.codprov = '12' and
	L2.codprov != '12';
	
--12
select 	distinct L.nombre "Nombre duplicado"
from 	localidad L, localidad L2, provincia P
where 	L.nombre = L2.nombre and
	L.codprov = P.codprov and
	lower(P.nombre) = 'castellon' and
	L2.codprov != L.codprov;
