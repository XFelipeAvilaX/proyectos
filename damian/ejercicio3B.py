#Ejercicio 3 Recursividad
#una función que nos devuelva el máximo común divisor de dos números enteros 
#utilizando el algoritmo de Euclides
def mcd(m, n):
    
    if n == 0: 
        return m
    elif n == 1: 
        return n
    else:
        return mcd(n, m % n)   # % tambien llamado modulo = el resto de una division
                #  (n,r)
m = int(input("Ingrese el valor de m: "))
n = int(input("Ingrese el valor de n: "))

comparacion = False

comparacion = m>n

if comparacion:
   print("El MCD es:", mcd(m, n))
else:
   print ("El valor de n es mayor a m, no se cumple el algoritmo de euclides")

