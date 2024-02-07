select *
from emple
where dept_no = 10;

select emp_no, apellido, dept_no
from emple
where dept_no = 10 or 
    dept_no = 20;

select apellido, salario
from emple
where salario >= 2000 and 
    salario <= 3500
order by salario asc;

select apellido, salario, oficio
from emple
where oficio = 'VENDEDOR'
order by salario desc;

select apellido, salario, oficio
from emple
where salario < 2000 and 
    oficio = 'VENDEDOR'
order by salario asc;

select apellido, dir, fecha_alt
from emple
where dir = 7698 and fecha_alt < '01-02-1981';

select distinct dept_no
from emple;

select emp_no, fecha_alt
from emple
where fecha_alt <= '30-09-1981' and 
    fecha_alt >= '01-09-1981';

select oficio "CATEGORIA"
from emple
where (dept_no = 20 or
    dept_no = 30) and
    salario > 1000;
    
select apellido
from emple
where dept_no = 30
order by apellido asc;