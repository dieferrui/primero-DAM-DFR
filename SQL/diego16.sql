select 	emp_no, apellido, 
	'Se incorpor� el d�a ' || to_char(fecha_alt, 'dd') || ' de '
	|| to_char(fecha_alt, 'month') || ' de ' || to_char(fecha_alt, 'yyyy')
	"Fecha incorporaci�n"
from	emple
where	dept_no = 10;