#Integrantes
#Felipe Alberto Ávila cruz - 200204009
#Jair del Ángel López López - 200204014
#Luis Antonio Inurreta Martínez - 200204016
#Yonadav Donnet Valdez González - 200204005

#Ejercicio 1
#Este codigo sirve para saber la cantidad de conejos que pondra a la venta un granjero al cabo de un año usando el metodo de fibonacci

def fibonacci(n):
	if n == 0:
		return 0
	elif n == 1:
		return 1
	else:
		return fibonacci(n-1) + fibonacci(n-2)


n = 12
for t in range(n):
	print(fibonacci(t),end=" ")
print(", El numero total de conejos que pondra a la venta al cabo de un año es:", fibonacci(t))   	
	
	
	
#Ejercicio 2
#Convertir un numero decimal a hexadecimal

N = int(input("Ingrese un numero decimal:"))


print ("El numero convertido a decimal es:",hex(N))


    
    
    
    
    
#Ejercicio 3 iteracion

#Saca el maximo comun divisor de dos numeros que ingrese el usuario

M = int(input("Ingrese el numero mas grande:"))

N = int(input("Ingrese el numero mas pequeño:"))

MCD = False	

if M > 0 and N > 0 and M != N:

	

	if N < M:

		aux = M
		M = N
		N = aux

	i = M

	while not MCD and i >= 1:

		if M % i == 0 and N % i == 0:

			print("El M.C.D. es", i)
			MCD = True

		else:

			i -= 1





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


    
    
    
    
