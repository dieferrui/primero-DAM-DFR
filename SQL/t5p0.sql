select	user
from	dual;

select	fecha, concepto, round(nvl(cant * precioud, 0), 1) "TOTAL"
from	gastos
where	fecha 
	between '01/02/2023' 
	and '28/02/2023';
    
select	fecha, concepto, trunc(nvl(cant, 1) * nvl(precioud, 0), 1) "TOTAL"
from	gastos
where	fecha
	between '01/01/2023' 
	and '31/01/2023';

select	fecha, concepto, cant
from	gastos
where	mod(cant, 2) = 0;

select	*
from	gastos
where	sign(nvl(cant, 1) * nvl(precioud, 0)) = -1;

select	concepto, round(nvl(precioud, 0)) "Redondeo", ceil(precioud) "Entero superior", floor(precioud) "Entero inferior"
from	gastos
where	upper(concepto) like '%T%';
	
select	upper(autor) "May", lower(autor) "Min", initcap(autor) "Titulo"
from	mistextos;

select	'-^-^-^-^-^' || editorial || '^-^-^-^-^-'
from	mistextos;

select 	replace(replace(titulo, 'SISTEMAS', 'STMAS'), 'PROGRAMACIÓN', 'PRG')
from 	mistextos;

select 	rtrim(ltrim(lower(titulo), '."'), '."')
from 	mistextos;

select 	translate(titulo, 'Z."', 'Z')
from 	mistextos;

select 	lower(replace((replace(titulo, '.')), '"'))
from 	mistextos;

	