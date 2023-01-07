def mcd(m, n):
    
    if n == 0:   # n en realidad es r, solo que ocupa la posicion de la que antes era la variable n
        return m
    elif n == 1: # n en realidad es r, solo que ocupa la posicion de la que antes era la variable n
        return n
    else:
        return mcd(n, m % n)   # % tambien llamado modulo = el resto de una division
                #  (n,r)
m = int(input("Ingrese el valor de m: "))
n = int(input("Ingrese el valor de n: "))

print("El MCD es:", mcd(m, n))


