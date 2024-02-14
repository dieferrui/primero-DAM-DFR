select 	emp_no, apellido, 
	'Se incorporó el día ' || to_char(fecha_alt, 'dd') || ' de '
	|| to_char(fecha_alt, 'month') || ' de ' || to_char(fecha_alt, 'yyyy')
	"Fecha incorporación"
from	emple
where	dept_no = 10;