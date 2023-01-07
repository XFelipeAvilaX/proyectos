#Generar una lista de N números aleatorios en un txt.
#(El usuario ingresa N desde teclado)(Separados por comas).
import random

def validar(texto):
    while True:
        try:
            dato= int(input(texto))
            return dato
        except ValueError:
            print("Oops!  Inserta un número entero por favor...")

print("Bienvenido usuario, este programa permite la creación de un archivo txt con una lista de numeros aleatorios")
i= validar("¿Cuantas ordenes de numeros aleatorios desea?: ")
a=1
file = open("C:/Users/-thepow/Desktop/prueba.txt", "w")

while (a!=i):
            a=a+1
            convertidor = str(random.randint(0,1000))
            file.write(convertidor+",")                                    
convertidor = str(random.randint(0,1000))
file.write(convertidor)

file.close()