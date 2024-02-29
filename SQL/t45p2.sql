REM   Script: sesionSQLlive
REM   Asda asasda dadas

--1
select 	distinct job_title 
from 	hr.jobs 
where 	min_salary > 10000;

--2
select 	last_name || ', ' || first_name "Nombre completo", hire_date 
from 	hr.employees 
where 	to_number(to_char(hire_date, 'yyyy')) between 2002 and 2005
order by hire_date;

--3
select 	first_name, last_name, job_id 
from 	hr.employees 
where 	upper(job_id) like '%CLERK%';

--4
select 	* 
from 	hr.employees 
where 	(department_id = 50 or department_id = 80) and  
    	to_char(hire_date, 'mm') = '01';

--5
select 	job_title, min_salary, max_salary, max_salary - min_salary "Variabilidad" 
from 	hr.jobs;

--6
select 	* 
from 	hr.jobs 
where 	(max_salary - min_salary) > 10000;

--7
select 	first_name, last_name 
from 	hr.employees 
where 	salary > 10000 and 
	nvl(commission_pct, 0) <> 0;
	
--8
alter session set nls_territory = "Spain";
alter session set nls_date_format = 'DD/MM/YYYY';


