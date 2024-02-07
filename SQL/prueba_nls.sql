select sysdate from dual; --prueba

select round( 10 / 3, 2) --prueba2
from dual;

alter session set nls_date_format = "d month yyyy";
alter session set nls_date_format = "day dd month yyyy";
alter session set nls_date_format = "mm/dd/yyyy";
alter session set nls_date_format = "yy/mm/dd";
alter session set nls_date_format = "dd/mm/yyyy hh24:mi";

alter session set nls_date_language = "french";

alter session set nls_numeric_characters = "*.";
