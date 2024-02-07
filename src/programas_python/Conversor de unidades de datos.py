# Conversor de unidades de datos

# Diccionario de equivalencias
conversiones = {
    'bits': {'bits': 1, 'bytes': 1/8, 'kilobytes': (1/8)/1024, 'megabytes': (1/8)/(1024**2), 'gigabytes': (1/8)/(1024**3), 'terabytes': (1/8)/(1024**4)},
    'bytes' : {'bits': 8, 'bytes': 1, 'kilobytes': 1/1024, 'megabytes': 1/(1024**2), 'gigabytes': 1/(1024**3), 'terabytes': 1/(1024**4)},
    'kilobytes' : {'bits': 8*1024, 'bytes': 1024, 'kilobytes': 1, 'megabytes': 1/1024, 'gigabytes': 1/(1024**2), 'terabytes': 1/(1024**3)},
    'megabytes' : {'bits': 8*(1024**2), 'bytes': 1024**2, 'kilobytes': 1024, 'megabytes': 1, 'gigabytes': 1/1024, 'terabytes': 1/(1024**2)},
    'gigabytes' : {'bits': 8*(1024**3), 'bytes': 1024**3, 'kilobytes': 1024**2, 'megabytes': 1024, 'gigabytes': 1, 'terabytes': 1/1024},
    'terabytes' : {'bits': 8*(1024**4), 'bytes': 1024**4, 'kilobytes': 1024**3, 'megabytes': 1024**2, 'gigabytes': 1024, 'terabytes': 1},
}

# Pedir input al usuario
cantidad = float(input('Introduce la cantidad de datos: '))
unidad_entrada = input('Introduce el nombre completo de la unidad a convertir: ').lower()
unidad_salida = input('Introduce el nombre completo de la unidad converida: ').lower()

# Verificar unidades
if unidad_entrada not in conversiones or unidad_salida not in conversiones[unidad_entrada]:
    print("Unidad de entrada o salida inválidas")
else:
    # Realizar cálculo
    factor_conversion = conversiones[unidad_entrada][unidad_salida]
    resultado_conversion = cantidad * factor_conversion
    print("El resultado es " + str(resultado_conversion) + " " + unidad_salida)
    