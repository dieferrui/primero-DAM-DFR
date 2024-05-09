--1
select 	*
from 	maillot;

--2
select 	dorsal, nombre
from 	ciclista
where 	edad <= 25;

--3
select 	nompuerto, altura
from 	puerto
where 	categoria = 'E';

--4
select 	netapa
from 	etapa
where 	lower(salida) = lower(llegada);

--5
select 	nomeq
from 	equipo
where 	nomeq in (select   nomeq
		  from     ciclista);
		  
--6
select 	nomeq, director
from  	equipo
where 	nomeq in (select   nomeq
		  from     ciclista);

--7
select 	netapa, km
from 	etapa
where 	mod(netapa, 2) = 0;

--8
select 	netapa
from  	etapa
where 	netapa in (select   netapa
		   from     puerto);
		   
--9
select 	netapa, km
from  	etapa
where 	netapa in (select   netapa
		   from     puerto);
		   
--10
select 	distinct codigo
from 	llevar;

--11
select 	distinct L.codigo, M.color
from 	llevar L, maillot M
where 	L.codigo = M.codigo;

--12
select 	count(*)
from  	ciclista;

--13
select 	count(*)
from 	ciclista
where 	edad >= 25;

--14
select 	count(*)
from 	equipo;

--15
select 	round(avg(edad), 2) "Edad media"
from 	ciclista;

--16
select 	max(altura), min(altura)
from 	puerto;

--17
select 	nompuerto, categoria
from 	puerto
where 	dorsal in (select   dorsal
		   from     ciclista
		   where    nomeq = 'Banesto');
		   
--18
select 	P.nompuerto, P.netapa, E.km
from 	puerto P, etapa E
where 	P.netapa = E.netapa;

--19
select 	distinct E.nomeq, E.director
from 	equipo E, ciclista C
where  	C.nomeq = E.nomeq and
	C.edad > 33;
	
--20
select 	distinct C.nombre, M.color
from 	ciclista C, maillot M, llevar L
where 	C.dorsal = L.dorsal and
	L.codigo = M.codigo
order by C.nombre;

--21
select 	distinct C.nombre, E.netapa
from 	ciclista C, llevar L, etapa E, maillot M
where 	C.dorsal = E.dorsal and
	L.netapa = E.netapa and
	C.dorsal = L.dorsal and
	L.codigo = M.codigo and 
	lower(M.color) = 'amarillo';

--22
select 	E.netapa
from 	etapa E, etapa E2
where 	E.salida != E2.llegada and
	E2.netapa = E.netapa - 1;

--23
select 	distinct netapa, salida
from 	etapa
where 	netapa not in   (select 	netapa
			   from 	puerto)
order by netapa;

--24
select 	round(avg(C.edad), 2) "Edad media"
from 	ciclista C, etapa E
where 	C.dorsal = E.dorsal;

--25
select 	nompuerto
from 	puerto
where 	altura >   (select   avg(altura)
		    from     puerto);
		    
--26
select 	E.salida, E.llegada
from    etapa E, puerto P
where 	E.netapa = P.netapa and
	P.pendiente =   (select   max(pendiente)
			 from     puerto);
			 
--27
select 	C.nombre, P.dorsal
from 	ciclista C, puerto P
where 	C.dorsal = P.dorsal and
	P.altura =   (select   max(altura)
		      from     puerto);
		      
--28
select 	nombre
from  	ciclista
where 	edad =   (select   min(edad)
		  from     ciclista);
		  
--29
select 	C.nombre
from  	ciclista C, etapa E
where 	C.dorsal = E.dorsal and
	edad =   (select   min(edad)
		  from     ciclista); --Incompleta