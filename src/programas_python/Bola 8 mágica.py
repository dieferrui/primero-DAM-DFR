# Bola 8 mágica
import random
import time

respuestas = ("Sí, seguro.", "Decididamente sí.", "Sin duda.", "Definitivamente.", "Puedes contar con ello.",
              "Tal y como lo veo, sí.", "Seguramente.", "El pronóstico es bueno.", "Sí.", "Las señales dicen que sí.",
              "No cuentes con ello.", "Mi respuesta es no.", "Ni por casualidad.", "Mis fuentes dicen que no.", "No.",
              "Difícilmente.", "Pronóstico no muy bueno.", "No existe tal posibilidad.", "No te lo pienso decir",
              "La respuesta es borrosa, inténtalo de nuevo.", "Pregunta de nuevo más tarde.", "Mejor que no lo sepas.",
              "No puedo hacer predicciones ahora.", "Concéntrate y pregunta de nuevo.")

dormir = (1, 2, 3, 4, 5)
otra_pregunta = True

while otra_pregunta == True:
    # Introducir pregunta
    print("Escribe una pregunta cuya respuesta sea sí o no:")
    pregunta = str(input())

    # Seleccionar respuesta
    respuesta = random.choice(respuestas)
    tiempo_respuesta = random.choice(dormir)

    # Esperar y responder
    time.sleep(tiempo_respuesta)
    print(respuesta)

    # Otra pregunta?
    print("¿Quieres preguntar otra cosa? Y/N:")
    volver_atras = str(input())
    if volver_atras == "Y":
        continue
    elif volver_atras == "N":
        otra_pregunta = False
    else:
        otra_pregunta = False
        print("No te he entendido, así que me cierro igual.")
