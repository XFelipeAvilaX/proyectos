#Ejercicio 1
#Este codigo sirve para saber la cantidad de conejos pondra a la venta un granjero al cabo de un año usando el metodo de fibonacci

def fibonacci(n):
	if n == 0:
		return 0
	elif n == 1:
		return 1
	else:
		return fibonacci(n-1) + fibonacci(n-2)


n = 12
for t in range(n):
	print(fibonacci(t),end=" ",)
print(", El numero total de conejos que pondra a la venta al cabo de un año es:", fibonacci(t))    