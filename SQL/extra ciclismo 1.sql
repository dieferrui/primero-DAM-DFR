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
where   C.dorsal = E.dorsal and
	C.edad =     (select   min(edad)
		      from     ciclista C2, etapa E2
		      where    C2.dorsal = E2.dorsal);
		    
--30
select 	C.nombre, count(*) "Puertos ganados"
from 	ciclista C, puerto P
where 	C.dorsal = P.dorsal
group by C.dorsal, C.nombre
having 	count(*) > 1;

--31
select 	nombre, dorsal
from 	ciclista
where 	dorsal not in (select   dorsal
		       from     etapa);

--32
select 	count(distinct C.dorsal) "Ciclistas con puerto"
from 	ciclista C, puerto P
where 	C.dorsal = P.dorsal;

--33
select 	count(*) "Ciclistas sin maillot"
from 	ciclista
where 	dorsal not in (select   dorsal
		       from     llevar);
		       
--34
select 	nombre, dorsal
from 	ciclista
where 	dorsal not in (select   dorsal
		       from     llevar);
		       
--35
select 	nombre, dorsal
from 	ciclista
where 	dorsal in (select   dorsal
		   from     llevar) and 
	dorsal not in (select   dorsal
		       from     llevar
		       where    codigo = 'MGE');
		       
--36
select 	nomeq, director
from 	equipo
where 	nomeq not in (select   nomeq
		      from     ciclista);
		      
--37
select 	nomeq, director
from 	equipo
where 	nomeq in (select   nomeq
		  from     ciclista);
		  
--38
select 	E.netapa
from 	etapa E, puerto P
where 	E.netapa = P.netapa
group by E.netapa
having 	count(*) >= 2;

--39
select 	netapa, salida, llegada
from 	etapa
where  	km > 190;

--40
select 	E.netapa, E.salida, E.llegada
from 	etapa E, puerto P
where 	E.netapa = P.netapa and
	E.km > 190
group by E.netapa, E.salida, E.llegada
having 	count(*) >= 2;

--41
select 	distinct E.netapa, E.km
from 	etapa E, puerto P
where 	E.netapa = P.netapa;

--42
select 	nombre, edad
from 	ciclista;

--43
select 	nompuerto, altura
from 	puerto
where 	categoria = '1';

--44
select 	nombre
from 	ciclista
where 	edad between 20 and 30;

--45
select 	netapa, llegada, salida
from 	etapa
where 	substr(lower(llegada), 2, 1) in ('o', 'ó') or
	length(translate(lower(salida), 'aábcdeéfghiíjklmnoópqrstuúvwxyz ', 'aa')) > 2;
	
--46
select 	nompuerto
from 	puerto
where 	categoria in ('1', '2', '3');

--47
select 	*
from 	ciclista
where 	edad is null or
	edad = 0;
	
--48
select 	C.nombre, C.edad
from 	ciclista C, equipo E
where 	C.nomeq = E.nomeq and
	E.nomeq like '%100%%';
	
--49
select 	C.nombre
from  	ciclista C, equipo E
where 	C.nomeq = E.nomeq and
	E.director = 'Álvaro Pino';
	
--50
select 	C.nombre, E.netapa
from 	ciclista C, etapa E
where 	C.dorsal = E.dorsal and
	E.km > 150;
	
--51
select 	nompuerto
from 	puerto
where 	altura > (select   avg(altura)
		  from     puerto
		  where    categoria = '2');
		  
--52
select 	E.netapa
from 	etapa E, ciclista C
where 	E.dorsal = C.dorsal and
	C.edad > 30;
	
--53
select 	E.netapa
from 	etapa E, ciclista C, equipo EQ
where 	E.dorsal = C.dorsal and
	C.nomeq = EQ.nomeq and
	lower(EQ.director) like 'm%';
	
--54
select 	distinct C.nombre
from 	ciclista C, llevar L, maillot M
where 	C.dorsal = L.dorsal and
	L.codigo = M.codigo and
	M.premio > 5000000;
	
--55
select 	distinct nombre
from 	ciclista
where 	dorsal not in (select   dorsal
                       from     etapa);