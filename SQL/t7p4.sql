--1
select 	count(*)
from 	cliente;

--2
select 	min(precio), round(avg(precio), 2), max(precio)
from 	articulo;

--3
select 	count(*)
from 	localidad
where 	codprov in ('03', '12', '46');

--4
select 	count(*)
from 	localidad
where 	codprov = (select   codprov
		   from     provincia
		   where    lower(nombre) = 'albacete');
		      
--5
select 	count(distinct codcli)
from 	factura;

--6
select 	count(distinct iva)
from 	factura
where 	codcli = 93;

--7
select 	round(avg(dto), 2)
from  	factura;

--8
select 	count(*)
from 	factura
where  	to_char(fecha, 'YYYY') = '2002';

--9
select 	round(count(*) / 12)
from 	factura
where  	to_char(fecha, 'YYYY') = '2002';

--10
select 	count(*), min(stock), round(avg(stock)), max(stock)
from 	articulo
where 	precio >= 100 and
	precio <= 300;
	
--11
select 	sum(stock * precio) "Valor total"
from 	articulo;

--12
select 	max(stock), min(stock), max(stock) - min(stock) "Diferencia"
from 	articulo
where 	precio >= 9 and
	precio <= 12;
	
--13
select 	round(avg(precio), 2)
from 	articulo
where 	stock > 15;

--14
select 	sum(cant * precio)
from 	factura_linea
where 	codfac = 26;

--15
select 	sum(cant * precio)
from 	factura_linea;

--16
select 	sum(cant * precio) / count(distinct codfac)
from 	factura_linea;

select 	round(avg(cant * precio), 2)
from 	factura_linea; --Esto es el importe medio por línea, no por factura

--17
select 	count(distinct codloc)
from 	cpostal
where  	codpostal like '12%';

--18
select 	count(*)
from 	articulo
where 	precio >= 100 and
	precio <= 300 and
	codart in (select   codart
		   from     factura_linea);
			     
--19
select 	count(*)
from 	articulo
where 	precio >= 100 and
	precio <= 300 and
	codart not in (select   codart
		       from     factura_linea);
			     
--20
select 	codart, descrip, precio
from 	articulo
where 	precio = (select   max(precio)
		  from 	   articulo);
			 
--21
select 	codven, nombre
from 	vendedor V
where  	15 < (select   count(*)
	      from     factura
	      where    codven = V.codven);
			 
--22
select 	codcli, nombre
from 	cliente C
where  	5 > (select   count(*)
	     from     factura
	     where    codcli = C.codcli);
			 
--23
select 	codprov, nombre
from 	provincia P
where 	5 = (select   count(*)
	     from     localidad
	     where    codprov = P.codprov);
			 
--24
select 	F.codfac, F.fecha, C.nombre "Nombre cliente", V.nombre "Nombre vendedor"
from 	factura F, cliente C, vendedor V
where	F.codcli = C.codcli and
	F.codven = V.codven and
	(select   count(*)
	 from 	  factura_linea FL
	 where 	  F.codfac = FL.codfac) between 4 and 6;