print("Buenos dias, este programa te permitira tabular una funcion cuadratica")

def validar(texto):
    while True:
        try:
            dato= int(input(texto))
            return dato
        except ValueError:
            print("Oops!  Inserta un número entero por favor...")

a= validar("Escribe el valor de a: ")
b= validar("Escribe el valor de b: ")
C= validar("Escribe el valor de c: ")

numeros = [-5,-4,-3,-2,-1,0,1,2,3,4,5]
valores = []


for f in range (len(numeros)):
    valores.append(((a)*(numeros[f]**2))+ ((b)*(numeros[f]))+ C)

for i in range (len(numeros)):
    print(i+1,".- x = ",numeros[i],", y = ", valores[i])
