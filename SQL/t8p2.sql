--1
select 	C.nombre, count(F.codfac) "Núm. facturas"
from 	cliente C left join factura F on C.codcli = F.codcli
where 	C.nombre like 'B%'
group by C.codcli, C.nombre
order by count(F.codfac) desc;

--2
select 	A.codart, count(distinct F.codfac) "Veces vendido"
from 	articulo A left join factura_linea F on A.codart = F.codart
where 	lower(A.codart) like 'a%'
group by A.codart;

--3
select 	A.codart "Nunca vendidos"
from 	articulo A left join factura_linea F on A.codart = F.codart
group by A.codart, A.descrip
having 	count(F.codfac) = 0;

--4
select 	A.codart, A.descrip, sum(nvl(F.cant, 0)) "Cantidad vendida"
from 	articulo A left join factura_linea F on A.codart = F.codart
where 	A.codart like 'IM2%' and
	A.descrip like '%INTERRUPTOR%'
group by A.codart, A.descrip;

--5
select 	P.codprov, P.nombre, count(codloc) "Núm. localidades"
from 	provincia P left join localidad L on P.codprov = L.codprov
group by P.codprov, P.nombre
order by count(codloc) desc;

--6
select 	C.nombre, C.direccion, count(codfac) "Núm. facturas"
from 	cliente C left join cpostal CP on C.codpostal = CP.codpostal left join
	localidad L on CP.codloc = L.codloc left join
	provincia P on L.codprov = P.codprov left join
	factura F on C.codcli = F.codcli
where 	P.nombre = 'CASTELLON' and
	(to_char(F.fecha, 'YYYY') = '2002' or fecha is null)
group by C.nombre, C.direccion
order by count(codfac) desc;

--7
select 	codfac, fecha, nvl(to_char(F.codven), 'Sin vendedor') "Codigo vendedor", nvl(nombre, 'Sin vendedor') "Nombre vendedor"
from 	factura F left join vendedor V on F.codven = V.codven
where 	to_char(fecha, 'YYYY') = '2002' and
	to_char(fecha, 'MM') = '12'
order by V.nombre, codfac;