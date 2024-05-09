--1
select 	codcli, count(*)
from 	factura
group by codcli;

--2
select 	codcli, count(*)
from 	factura
group by codcli
having  count(*) > 15;

--3
select 	to_char(fecha, 'YYYY') "Año", count(*) "Núm. facturas"
from 	factura
group by to_char(fecha, 'YYYY')
order by to_char(fecha, 'YYYY') asc;

--4
select 	codloc, count(*)
from 	cpostal
where 	codloc like '3%'
group by codloc;

--5
select 	max(count(*))
from 	cpostal
group by codloc;

select 	codloc, count(*)
from 	cpostal
group by codloc
having 	count(*) = (select   max(count(*))
		    from     cpostal
		    group by codloc);

--6
select 	codart, sum(cant) "Cantidad vendida"
from 	factura_linea
where 	codart like 'F%'
group by codart;

--7
select 	codven, count(*) "Facturas vendidas"
from 	factura
where 	to_char(fecha, 'YYYY') = '2002'
group by codven
having  count(*) > 3;

select 	codven, count(*) "Facturas vendidas"
from 	factura
where 	to_number(to_char(fecha, 'YYYY')) = to_number(to_char(sysdate, 'YYYY') - 1)
group by codven
having  count(*) > 3;

--8
select 	codart
from 	factura_linea
group by codart
having  sum(cant * precio) > 6000;

--9
select 	codcli, iva, count(*) "Núm. facturas"
from 	factura
where  	codcli between 241 and 250
group by codcli, iva
order by codcli asc;

--10
select 	codfac, sum(cant * precio) "Importe total"
from 	factura_linea
group by codfac
order by codfac asc;

--11
select 	round(avg(sum(cant * precio)), 2) "Valor medio de las facturas"
from 	factura_linea
group by codfac;

select 	codfac, round(avg(cant * precio), 2) "Media de líneas"
from 	factura_linea
group by codfac
order by codfac asc;

--12
select 	max(sum(cant * precio)) "Máximo importe de factura"
from 	factura_linea
group by codfac;

select 	codfac, sum(cant * precio) "Máximo importe de factura"
from 	factura_linea
group by codfac
having 	sum(cant * precio) = (select   max(sum(cant * precio))
			      from     factura_linea
			      group by codfac);
			      
--13
select 	codart, max(precio), min(precio)
from 	factura_linea
group by codart;

--14
select 	min(iva)
from 	factura
where 	codven between 100 and 200 and
	to_char(fecha, 'YYYY') = '2002'
group by to_char(fecha, 'MM')
order by to_char(fecha, 'MM');

select 	min(iva)
from 	factura
where 	codven between 100 and 200 and
	to_numbr(to_char(fecha, 'YYYY')) = to_number(to_char(sysdate, 'YYYY')) - 1
group by to_char(fecha, 'MM')
order by to_char(fecha, 'MM');

--15
select 	F.codcli, sum(FL.cant) "Núm. artículos" 
from 	factura F, factura_linea FL
where 	F.codfac = FL.codfac
group by F.codcli
having 	sum(FL.cant) >= 600;

select 	F.codcli, C.nombre, sum(FL.cant) "Núm. artículos" 
from 	factura F, factura_linea FL, cliente C
where 	F.codfac = FL.codfac and
	F.codcli = C.codcli
group by F.codcli, C.nombre
having 	sum(FL.cant) >= 600;

--16
select 	F.codcli, C.nombre, FL.codart, sum(FL.cant) "Núm. artículos" 
from 	factura F, factura_linea FL, cliente C
where 	F.codfac = FL.codfac and
	C.codcli = F.codcli
group by F.codcli, FL.codart, C.nombre
having 	sum(FL.cant) >= 20;

--17
select 	C.nombre, C.codpostal, sum(FL.cant * FL.precio) "Facturación"
from 	cliente C, factura_linea FL, factura F
where 	C.codcli = F.codcli and
	F.codfac = FL.codfac
group by F.codcli, C.nombre, C.codpostal
having 	sum(FL.cant * FL.precio) >= 6000;

--18
select 	F.codven, V.nombre, count(distinct FL.codart) "Artículos diferentes"
from 	factura F, factura_linea FL, vendedor V
where 	V.codven = F.codven and
	F.codfac = FL.codfac and
	lower(FL.codart) like 'b%'
group by F.codven, V.nombre
having 	count(distinct FL.codart) >= 8;

--19
select 	C.nombre, C.direccion, count(*) "Facturas año 2002"
from 	cliente C, cpostal CP, provincia P, factura F, localidad L
where 	C.codcli = F.codcli and
	C.codpostal = CP.codpostal and
	CP.codloc = L.codloc and
	L.codprov = P.codprov and
	P.nombre = 'CASTELLON' and
	to_char(fecha, 'YYYY') = '2002'
group by F.codcli, C.nombre, C.direccion;

--20
select 	P.nombre, count(*) "Clientes"
from 	provincia P, localidad L, cpostal CP, cliente C
where 	P.codprov = L.codprov and
	L.codloc = CP.codloc and
	CP.codpostal = C.codpostal
group by L.codprov, P.nombre
having 	count(*) > 5;

--21
select 	F.codcli, C.nombre, sum(cant * precio) "Cantidad gastada"
from 	cliente C, factura F, factura_linea FL
where 	C.codcli = F.codcli and
	F.codfac = FL.codfac
group by F.codcli, C.nombre, F.fecha
having 	to_char(F.fecha, 'MM/YYYY') = '12/2002' and
	sum(cant * precio) > 60
order by codcli asc;

--22
select 	P.nombre "Provincia", L.nombre "Localidad", count(*) "Número de clientes"
from 	localidad L, provincia P, cpostal CP, cliente C
where 	L.codprov = P.codprov and
	L.codloc = CP.codloc and
	CP.codpostal = C.codpostal and
	((P.codprov like '12%') or (P.codprov like '46%') or (P.codprov like '03%'))
group by L.nombre, P.nombre
order by P.nombre;

--23
select 	max(count(*)) "Máximos clientes"
from 	localidad L, cpostal CP, cliente C
where 	L.codloc = CP.codloc and
	CP.codpostal = C.codpostal
group by L.nombre;

select 	CP.codloc, count(*) "Máximos clientes"
from 	cpostal CP, cliente C
where 	CP.codpostal = C.codpostal
group by CP.codloc
having 	count(*) =   (select   max(count(*))
		      from     cpostal CP2, cliente C2
		      where    CP2.codpostal = C2.codpostal
		      group by CP2.codloc);
		      
--24
select 	V.nombre, F.codven, count(*) "Máximo de facturas"
from 	vendedor V, factura F
where 	V.codven = F.codven
group by F.codven, V.nombre
having 	count(*) =   (select   max(count(*))
		      from     vendedor V, factura F
		      where    V.codven = F.codven
		      group by V.codven);