--1
select 	codart, descrip, precio
from 	articulo
where 	precio > (select  precio
		  from 	  articulo
		  where   codart = 'SATF4');
		  
--2
select 	codart, descrip, precio
from 	articulo
where 	lower(descrip) like '%caja%' and
	precio > (select  precio
		  from 	  articulo
		  where   codart = 'SATF4');
		  
--3
select 	codfac, fecha
from 	factura
where  	codcli = 96 and
	fecha > (select  fecha
		 from 	 factura
		 where   codfac = 26)
order by fecha asc;
		 
--4
select 	codfac, fecha
from 	factura
where 	codcli = 96 and
	fecha > (select  fecha
		 from 	 factura
		 where   codfac = 26) and
	fecha < (select  fecha
		 from 	 factura
		 where   codfac = 32)
order by fecha asc;
		 
--5
select 	distinct codfac
from 	factura_linea
where 	codart in (select  codart
		   from    factura_linea
		   where   codfac = 26)
order by codfac asc;

--6
select 	codcli, nombre, codpostal
from 	cliente
where 	codpostal in (select  codpostal
		      from    cpostal
		      where   codloc = '53596');
		      
--7
select 	codcli, nombre, codpostal
from 	cliente
where 	codpostal in (select  codpostal
		      from    cpostal
		      where   codloc in (select  codloc
					 from    localidad
					 where   nombre = 'VILLARREAL'));
					 
--8
select 	codloc, nombre
from 	localidad
where 	nombre like 'V%' and
	codprov in (select   codprov
		    from     provincia
		    where    nombre like 'Z%G%');