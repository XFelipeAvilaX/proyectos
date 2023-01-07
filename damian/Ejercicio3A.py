
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


