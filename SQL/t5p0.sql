--0
select	user
from	dual;

--1
select	fecha, concepto, round(nvl(cant * precioud, 0), 1) "TOTAL"
from	gastos
where	fecha between '01/02/2023' and '28/02/2023';
	
--2    
select	fecha, concepto, trunc(nvl(cant, 1) * nvl(precioud, 0), 1) "TOTAL"
from	gastos
where	fecha between '01/01/2023' and '31/01/2023';

--3
select	fecha, concepto, cant
from	gastos
where	mod(cant, 2) = 0;

--4
select	*
from	gastos
where	sign(nvl(cant, 1) * nvl(precioud, 0)) = -1;

--5
select	concepto, round(nvl(precioud, 0)) "Redondeo", 
	ceil(precioud) "Entero superior", floor(precioud) "Entero inferior"
from	gastos
where	upper(concepto) like '%T%';

--6	
select	upper(autor) "May", lower(autor) "Min", initcap(autor) "Titulo"
from	mistextos;

--7
select	'-^-^-^-^-^' || editorial || '^-^-^-^-^-'
from	mistextos;

select	lpad(rpad(editorial, 20, '-^'), 30, '-^') "Resultado"
from	mistextos;

--8
select 	replace(replace(titulo, 'SISTEMAS', 'STMAS'), 'PROGRAMACIÓN', 'PRG')
from 	mistextos;

--9
select 	rtrim(ltrim(lower(titulo), '."'), '."')
from 	mistextos;

select 	lower(translate(titulo, 'Z."', 'Z'))
from 	mistextos;

select 	lower(replace((replace(titulo, '.')), '"'))
from 	mistextos;

--10
select 	substr(autor, 1, (instr(autor, ',')) -1) "Apellido",
	substr(autor, (instr(autor, ',')) + 2) "Nombre de pila",
	autor
from 	libros;

--11
select	substr(autor, (instr(autor, ',')) + 2) 
	|| ' ' || substr(autor, 1, (instr(autor, ',')) -1) "Nombre completo"
from	libros;

--12
select	titulo
from	libros
order by length(titulo) desc;

--13
select 	tema, substr(rtrim(tema), -1) "Último carácter",
	length(rtrim(tema)) "Núm. carácteres"
from 	libreria
order by "Núm. carácteres" desc;

--14
select	'El empleado ' || apellido || ' trabaja de ' || oficio
from 	emple
where	comision = 0 or comision is null;

select	'El empleado ' || apellido || ' trabaja de ' || oficio
from 	emple
where	nvl(comision, 0) = 0;

--15
select	apellido, trunc((sysdate - fecha_alt) / 365) "Años completos trabajados"
from	emple
where	((sysdate - fecha_alt) / 365) > 15;

select	apellido, 
	trunc(months_between(sysdate, fecha_alt) / 12) "Años completos trabajados"
from 	emple
where	months_between(sysdate, fecha_alt) > 180;

--16
select 	emp_no, apellido, 
	'Se incorporó el día ' || to_char(fecha_alt, 'dd') || ' de '
	|| to_char(fecha_alt, 'month') || ' de ' || to_char(fecha_alt, 'yyyy')
	"Fecha incorporación"
from	emple
where	dept_no = 10;

--17
select	initcap(apellido) || ' (' || to_char(emp_no) || 
	') se incorporó el trimestre ' || to_char(fecha_alt, 'q') || ' de ' ||
	to_char(fecha_alt, 'yyyy') "Trimestre incorporación"
from 	emple
where	dept_no = 10;

--18
select	to_char(sysdate, 'Day')
from 	dual;

--19
select	to_char(sysdate, 'Month')
from	dual;

--20
select	'08/07/2004' "Fecha de nacimiento", 
	trunc((sysdate-(to_date('08/07/2004'))) / 365) "Edad"
from 	dual;

select	'08/07/2004' "Fecha de nacimiento",
	trunc((months_between(sysdate, '08/07/2004')) / 12) "Edad"
from	dual;

--21
select	to_char(last_day(sysdate), 'Day')
from	dual;

--22
select	(sysdate + 1) "Fecha inicio", add_months(sysdate + 1, 6) "Fecha fin"
from	dual;

--23
select	(sysdate + 15) "Fecha examen"
from	dual;

--24
select	to_char(to_date('03012018', 'ddmmyyyy'), 'Day')
from 	dual;

--25
select	tema, estante, ejemplares,
	decode(estante, 'BA', 'BA', 'CA', 'CA', 'DA', 'DA', 'EA', 'EA', 'ANEXO')
	"Reubica"
from	libreria;

select	tema, estante, ejemplares,
	decode(estante, 'AA', 'ANEXO', estante) "Reubica"
from	libreria;
	