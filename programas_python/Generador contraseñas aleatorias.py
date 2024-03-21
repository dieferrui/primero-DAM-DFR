# Generador contraseñas aleatorias
import random

# Función pedir input de usuario
def input_numeros():
    loop_back = True
    while loop_back is True:
        print("Introducir número de dígitos de la contraseña: ")
        long_pass = int(input())
        if long_pass < 10:
            print("Contraseña demasiado corta.")
            continue
        elif long_pass > 24:
            print("Contraseña demasiado larga.")
            continue
        else:
            loop_back = False
            return long_pass
    
# Función generar contraseña
def gen_numeros(long_pass):
    rango_pass = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!¡?¿@#$%&/()=[]+-"
    PASS_GEN = "".join(random.choice(rango_pass) for _ in range(long_pass))
    return PASS_GEN

# Función mostrar contraseña
def mostrar_numeros(PASS_GEN):
    print("Tu contraseña es: " + PASS_GEN + ".")

num_pedido = input_numeros()
PASS_GENERADA = gen_numeros(num_pedido)
mostrar_numeros(PASS_GENERADA)
