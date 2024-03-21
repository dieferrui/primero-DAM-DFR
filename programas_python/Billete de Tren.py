# Billete de Tren

distancia = 0
tipo_billete = 0
tarjeta = 0

while distancia <= 0:
    print("Introduzca la distancia (en km) entre el origen y su destino: ")
    distancia = int(input())

while tipo_billete != 1 and tipo_billete != 2:
    print("Introduzca su tipo de billete: \n1. Sencillo\n2. Ida y vuelta")
    tipo_billete = int(input())

    match tipo_billete:
        case 1: precio_viaje = 0.33 * distancia
        case 2: precio_viaje = 0.33 * distancia
        case default: print("Introduzca un billete válido.")

while tarjeta != 1 and tarjeta != 2:
    print("¿Posee tarjeta interraíl? \n1. Sí\n2. No")
    tarjeta = int(input())

if tarjeta == 1:
    precio_final = precio_viaje * 0.75
elif precio_viaje >= 110:
    precio_final = precio_viaje * 0.90
elif precio_viaje >= 50:
    precio_final = precio_viaje * 0.95
else:
    precio_final = precio_viaje

print(f'El precio de su billete es de {precio_final} euros.')
