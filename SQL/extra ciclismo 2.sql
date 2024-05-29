--1
select 	count(distinct C.nombre) "Ciclistas +50km"
from 	ciclista C, etapa E
where 	C.dorsal = E.dorsal and
	E.km > 50;
	
--2
select 	netapa, km
from 	etapa
where 	netapa not in (select  netapa
		       from    puerto)
order by netapa asc;

--3
select 	E.netapa, count(*) "Núm. puertos"
from 	etapa E, puerto P
where 	E.netapa = P.netapa
group by E.netapa
order by E.netapa;

select 	E.netapa, count(P.nompuerto) "Núm. puertos"
from 	etapa E left join puerto P on E.netapa = P.netapa
group by E.netapa
order by E.netapa;

--4
select 	E.nomeq, count(*) "Ciclistas"
from 	equipo E, ciclista C
where 	E.nomeq = C.nomeq
group by E.nomeq;

select 	E.nomeq, count(C.nombre) "Ciclistas"
from 	equipo E left join ciclista C on E.nomeq = C.nomeq
group by E.nomeq;

--5
select 	E.nomeq
from 	equipo E, ciclista C
where 	E.nomeq = C.nomeq
group by E.nomeq
having count(*) > 3;

--6
select 	E.nomeq
from 	equipo E, ciclista C
where 	E.nomeq = C.nomeq
group by E.nomeq
having count(*) > 3 and
       avg(C.edad) <= 30;
       
--7
select 	E.nomeq, E.director
from 	equipo E, ciclista C
where 	E.nomeq = C.nomeq
group by E.nomeq, E.director
having count(*) > 3 and
       avg(C.edad) <= 30;
       
--8
select 	C.nombre, count(E.netapa) "Etapas ganadas"
from 	ciclista C left join etapa E on C.dorsal = E.dorsal
group by C.nombre
order by count(E.netapa) desc;

--9
select 	C.dorsal, C.nombre, count(E.netapa) "Etapas ganadas"
from 	ciclista C left join etapa E on C.dorsal = E.dorsal
where  	5 < (select   count(*)
	     from     equipo EQ
	     where    EQ.nomeq = C.nomeq)
group by C.dorsal, C.nombre
order by count(E.netapa) desc;