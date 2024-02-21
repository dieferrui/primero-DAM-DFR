--1
select	'Quedan ' || to_char(stock) || 
	' unidades en el almacén del artículo con código ' ||
	codart
from	articulo
where	upper(codart) like 'L%' and 
	length(descrip) < 20;

--2
select 	codfac, fecha, nvl(iva, 0)
from	factura
where 	to_char(fecha, 'mm') = '03' and 
	nvl(iva, 0) = 0
order by fecha asc;

--3
select 	codart, stock, stock_min,
	decode(sign(nvl(stock, 0) - nvl(stock_min, 0)), 
	1, 'Stock suficiente', 
	-1, 'Stock insuficiente',
	0, 'Stock ajustado') "Cantidad en stock"
from 	articulo
where 	precio < 0.5;

--4
select 	nombre
from 	provincia
where 	substr(lower(nombre), 4, 1) = 'e' and 
	substr(lower(nombre), length(nombre), 1) = 'a';
	
--5
select 	codfac, fecha, codcli
from 	factura
where 	to_char(fecha, 'yyyy') = 2002 and 
	mod(codcli, 10) = 0;

select 	codfac, fecha, codcli
from 	factura
where 	to_number(to_char(fecha, 'yyyy')) = 
	to_number(to_char(sysdate, 'yyyy')) - 1 and 
	mod(codcli, 10) = 0;

--6
select 	distinct to_char(fecha, 'Month') "mes"
from 	factura
where 	to_char(codcli) like '%0%' and 
	to_char(fecha, 'yyyy') = '2002';

--7
select 	codfac, fecha, codcli
from 	factura
where 	fecha - to_date('01-01-2002') < 50 and 
	codcli between 100 and 200 and 
	to_char(fecha, 'yyyy') = '2002';
	
--8
select 	codfac, fecha, codcli, dto, iva
from 	factura
where 	mod(to_number(substr(to_char(codcli), 1, 1)), 2) = 0 and
	(nvl(dto, 0) = 0 or nvl(iva, 0) = 0);
	
--9
select 	codfac, fecha
from 	factura
where 	to_char(fecha, 'mm') = '05' and 
	(to_number(to_char(fecha, 'yyyy')) between 2000 and 2002);
	
select 	codfac, fecha
from 	factura
where 	to_char(fecha, 'mm') = 5 and 
	(to_number(to_char(fecha, 'yyyy')) between
	to_number(to_char(sysdate, 'yyyy')) - 2 and 
	to_number(to_char(sysdate, 'yyyy')));
	
--10
select 	codprov, nombre
from 	provincia
where 	lower(nombre) like '%ma%' or
	substr(codprov, 1, 1) = substr(codprov, length(codprov), 1);
	
--11
select 	codart, precio, decode(sign(precio - 30), 1, '10%', '15%') "Descuento",
	decode(sign(precio - 30), 1, precio - (precio * 0.1),
	precio - (precio * 0.15)) "Precio tras descuento"
from 	articulo
where 	nvl(stock, 0) * nvl(precio, 0) > 150;

--12
select 	to_char(fecha, 'Month'), codven, dto
from 	factura
where 	nvl(dto, 0) > 40 and 
	decode(to_char(fecha, 'mm'), '06', 'X', '07', 'X', '08', 'X', '09', 'X', 'N') = 'X'
order by codven;

select 	to_char(fecha, 'Month'), codven, dto
from 	factura
where 	nvl(dto, 0) > 40 and to_char(fecha, 'mm') in ('06', '07', '08', '09')
order by codven;

--13
select 	codcli, fecha
from 	factura
where 	to_char(fecha, 'q') = '4' and 
	to_char(fecha, 'yyyy') = '2002';

select 	codcli, fecha
from 	factura
where 	to_char(fecha, 'q') != '4' and 
	to_char(fecha, 'yyyy') = '2002';

--14
select 	codart, translate(upper(codart), 'ZAEIOU', 'Z') "Nuevo código"
from 	articulo
where 	upper(codart) like '%A%' and
	substr(codart, -1, 1) between '0' and '9';
	
--15
select 	codfac, fecha, next_day(fecha, 'Viernes') "Fecha contabilización"
from 	factura
where 	to_char(fecha, 'yyyy') = '2002';

--16
select 	codfac, fecha, next_day(fecha, 'Viernes') "Fecha contabilización"
from 	factura
where 	to_char(fecha, 'yyyy') = '2002' and
	to_char(next_day(fecha, 'Viernes'), 'mm') != to_char(fecha, 'mm');
