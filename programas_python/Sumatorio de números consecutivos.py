# Sumatorio de números enteros consecutivos

print("Introduzca el número sumatorio:")
inicio = 0
sumador = 0
maximo = int(input())

while inicio < maximo:
    inicio += 1
    sumador += inicio
print(f'El resultado es {sumador}.')
