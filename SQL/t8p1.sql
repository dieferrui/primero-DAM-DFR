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
group by to_char(fecha, 'YYYY');

--4
select 	codloc, count(codpostal)
from 	cpostal
where 	codloc like '3%'
group by codloc;

--5
select 	max(count(codpostal))
from 	cpostal
group by codloc;

select 	codloc, count(*)
from 	cpostal
group by codloc
having 	count(*) = (select   max(count(*))
		    from     cpostal
		    group by codloc);

--6
select 	codart, sum(linea * cant) "Cantidad vendida"
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
group by codcli, iva;

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