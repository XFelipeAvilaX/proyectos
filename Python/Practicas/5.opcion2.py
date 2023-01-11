#Leer un txt con N números separados por comas y determinar la moda.
#(Imprimir en pantalla la lista de numeros, la moda y cuantas veces se repitio).

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
file = open("C:/Users/favil/Desktop/prueba.txt", "w")