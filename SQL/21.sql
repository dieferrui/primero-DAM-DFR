--24
select 	F.codfac, F.fecha, C.nombre "Nombre cliente", V.nombre "Nombre vendedor"
from 	factura F, cliente C, vendedor V
where	F.codcli = C.codcli and
	F.codven = V.codven and
	(select   count(*)
	 from 	  factura_linea FL
	 where 	  F.codfac = FL.codfac) between 4 and 6;