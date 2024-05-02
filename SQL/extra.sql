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
