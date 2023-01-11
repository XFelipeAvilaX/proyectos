#https://www.youtube.com/watch?v=cNIV-ltkpBM Sistemas de ecuaciones lineales 2x2 | Método de Sustitución

#Generar un programa que resuelva una ecuacion lineal de 2x2
#El programa debe tener 2 rutas, sacar primero x o y a elección del usuario}
#El algoritmo debe mostrarse paso a paso
#se puede usar cualquier libreria
#pedir los datos enteros validados desde teclado

from fractions import Fraction

def validar(texto):
    while True:
        try:
            dato= int(input(texto))
            return dato
        except ValueError:
            print("Oops!  Inserta un número entero por favor...")

def validar2(texto):
    while True:
        try:
            dato2= int(input(texto))
            return dato2
        except ValueError:
            print("Oops!  Inserta un número entero por favor...")


print("Bienvenido usuario, este programa permite la resolucion de un sistema de ecuaciones lineales 2x2")
print("Por favor ingresa los valores de la primera ecuacion lineal")
x1= validar("Ingresa el valor de x: ")
y1= validar("Ingresa el valor de y: ")
n1= validar("Ingresa el valor de la constante: ")
print("Por favor ingresa los valores de la segunda ecuacion lineal")
x2= validar("Ingresa el valor de x: ")
y2= validar("Ingresa el valor de y: ")
n2= validar("Ingresa el valor de la constante: ")

print("Por favor seleccione 1,2,3 o 4 dependiendo de la forma en como quiere que se resuelva la ecuación")
print("1.despejar x en la primera ecuación")
print("2.despejar x en la segunda ecuación")
print("3.despejar y en la primera ecuación")
print("4.despejar y en la segunda ecuación")

v2= validar2("Introduzca su opción deseada: ")

if v2 == 1:
    
    print("despejar x en la primera ecuación")

    print(f'({x1}x) + ({y1}y) = {n1}')
    print("se despeja x en la ecuación")
    print(f'{x1}x = ({n1}) + ({-y1}y)')
    print(f'x = (({n1}) + ({-y1}y))/{x1})')
    print("Reemplazar 'x' en la segunda ecuacion")
    print(f'({x2}x) + ({y2}y) = {n2}')
    print(f'({x2}((({n1}) + ({-y1}y))/{x1})) + ({y2}y) = {n2}')
    print("Multiplicar la ecuacion por el valor del divisor para igualar")
    print(f'({x2}(((({n1}) + ({-y1}y))/{x1}){x1})) + (({y2}y){x1}) = (({n2}){x1})')
    print(f'({x2}(({n1}) + ({-y1}y))) + ({(y2*x1)}y) = {(n2*x1)}')
    print(f'(({(x2*n1)}) + ({(x2*-y1)}y)) + ({(y2*x1)}y) = {(n2*x1)}')
    print("Mandamos los valores constantes a la derecha y las variables a la izquierda y despues los sumamos")
    print(f'({(x2*-y1)}y) + ({(y2*x1)}y) = ({(n2*x1)}) + ({(x2*-n1)})')
    print(f'({(x2*-y1)+(y2*x1)}y) = ({(n2*x1)+(x2*-n1)})')
    print("despejar el valor de la variable y")
    print(f'y = ({(n2*x1)+(x2*-n1)}) / ({(x2*-y1)+(y2*x1)})')

    e1 = (f'{((n2*x1)+(x2*-n1))/((x2*-y1)+(y2*x1))}')
    p1=Fraction(str(e1)).limit_denominator()
    print(f'y = {p1}')    #<- valor de la y

    print("Reemplazar Y en la primera ecuacion y obtener x")
    print(f'({x1}x) + ({y1}y) = {n1}')
    print(f'({x1}x) + (({y1})({p1})) = ({n1})')

    e2 = (f'{((n2*x1)+(x2*-n1))/((x2*-y1)+(y2*x1))*(y1)}')
    p2=Fraction(str(e2)).limit_denominator()

    print(f'({x1}x) + ({p2}) = ({n1})')
    print(f'({x1}x) = ({n1}) + ({-p2})')
    print(f'({x1}x) = ({(n1)+(-p2)})')

    e3 = (f'{((n1)+(-p2))/(x1)}')
    p3=Fraction(str(e3)).limit_denominator()
    print(f'(x) = ({p3})')  #<-valor de la x

    print(f'Los valores obtenidos son: y = {p1}, x={p3}')

elif v2 == 2:
    
    print("despejar x en la segunda ecuación")

    print(f'({x2}x) + ({y2}y) = {n2}')
    print("se despeja x en la ecuación")
    print(f'{x2}x = ({n2}) + ({-y2}y)')
    print(f'x = (({n2}) + ({-y2}y))/{x2})')
    print("Reemplazar 'x' en la primera ecuacion")
    print(f'({x1}x) + ({y1}y) = {n1}')
    print(f'({x1}((({n2}) + ({-y2}y))/{x2})) + ({y1}y) = {n1}')
    print("Multiplicar la ecuacion por el valor del divisor para igualar")
    print(f'({x1}(((({n2}) + ({-y2}y))/{x2}){x2})) + (({y1}y){x2}) = (({n1}){x2})')
    print(f'({x1}(({n2}) + ({-y2}y))) + ({(y1*x2)}y) = {(n1*x2)}')
    print(f'(({(x1*n2)}) + ({(x1*-y2)}y)) + ({(y1*x2)}y) = {(n1*x2)}')
    print("Mandamos los valores constantes a la derecha y las variables a la izquierda y despues los sumamos")
    print(f'({(x1*-y2)}y) + ({(y1*x2)}y) = ({(n1*x2)}) + ({(x1*-n2)})')
    print(f'({(x1*-y2)+(y1*x2)}y) = ({(n1*x2)+(x1*-n2)})')
    print("despejar el valor de la variable y")
    print(f'y = ({(n1*x2)+(x1*-n2)}) / ({(x1*-y2)+(y1*x2)})')

    e1 = (f'{((n1*x2)+(x1*-n2))/((x1*-y2)+(y1*x2))}')
    p1=Fraction(str(e1)).limit_denominator()
    print(f'y = {p1}')    #<- valor de la y

    print("Reemplazar Y en la segunda ecuación y obtener x")
    print(f'({x2}x) + ({y2}y) = {n2}')
    print(f'({x2}x) + (({y2})({p1})) = ({n2})')

    e2 = (f'{((n1*x2)+(x1*-n2))/((x1*-y2)+(y1*x2))*(y2)}')
    p2=Fraction(str(e2)).limit_denominator()

    print(f'({x2}x) + ({p2}) = ({n2})')
    print(f'({x2}x) = ({n2}) + ({-p2})')
    print(f'({x2}x) = ({(n2)+(-p2)})')

    e3 = (f'{((n2)+(-p2))/(x2)}')
    p3=Fraction(str(e3)).limit_denominator()
    print(f'(x) = ({p3})')  #<-valor de la x

    print(f'Los valores obtenidos son: y = {p1}, x={p3}')

elif v2 == 3:
    
    print("despejar y en la primera ecuación")

    print(f'({x1}x) + ({y1}y) = {n1}')
    print("se despeja y en la ecuación")
    print(f'{y1}y = ({n1}) + ({-x1}x)')
    print(f'y = (({n1}) + ({-x1}x))/{y1})')
    print("Reemplazar 'y' en la segunda ecuacion")
    print(f'({x2}x) + ({y2}y) = {n2}')
    print(f'({x2}x) + ({y2}((({n1}) + ({-x1}x))/{y1})) = {n2}')

    print("Multiplicar la ecuacion por el valor del divisor para igualar")
    print(f'(({y1})({x2}x)) + ({y2}((({n1}) + ({-x1}x))/{y1}){y1}) = (({n2}){y1})')
    print(f'({y1*x2}x) + ({y2*n1}) + ({y2*-x1}x) = {n2*y1}')
    print("Mandamos los valores constantes a la derecha y las variables a la izquierda y despues los sumamos")
    print(f'({y1*x2}x) + ({y2*-x1}x) = ({n2*y1}) + ({-y2*n1})')
    print(f'({(y1*x2)+(y2*-x1)}x) = ({(n2*y1)+(-y2*n1)})')
    print("despejar el valor de la variable x")
    print(f'y = ({(n2*y1)+(-y2*n1)}) / ({(y1*x2)+(y2*-x1)})')
    e1 = (f'{((n2*y1)+(-y2*n1))/((y1*x2)+(y2*-x1))}')
    p1=Fraction(str(e1)).limit_denominator()
    print(f'x = {p1}')    #<- valor de la x
    print("Reemplazar x en la primera ecuacion y obtener y")
    print(f'({x1}x) + ({y1}y) = {n1}')
    print(f'({x1})({p1})) + ({y1}y) = ({n1})')
    e2 = (f'{((n2*y1)+(-y2*n1))/((y1*x2)+(y2*-x1))*(x1)}')
    p2=Fraction(str(e2)).limit_denominator()
    print(f'({p2}) + ({y1}y) = ({n1})')
    print(f'({y1}y) = ({n1}) + ({-p2})')
    e3 = (f'{((n1)+(-p2))/(y1)}')
    p3=Fraction(str(e3)).limit_denominator()
    print(f'(y) = ({p3})')  #<-valor de la y
    print(f'Los valores obtenidos son: x = {p1}, y={p3}')

elif v2 == 4:
    
    print("despejar y en la segunda ecuación")

    print(f'({x2}x) + ({y2}y) = {n2}')
    print("se despeja y en la ecuación")
    print(f'{y2}y = ({n2}) + ({-x2}x)')
    print(f'y = (({n2}) + ({-x2}x))/{y2})')
    print("Reemplazar 'y' en la primera ecuacion")
    print(f'({x1}x) + ({y1}y) = {n1}')
    print(f'({x1}x) + ({y1}((({n2}) + ({-x2}x))/{y2})) = {n1}')

    print("Multiplicar la ecuacion por el valor del divisor para igualar")
    print(f'(({y2})({x1}x)) + ({y1}((({n2}) + ({-x1}x))/{y2}){y2}) = (({n1}){y2})')
    print(f'({y2*x1}x) + ({y1*n2}) + ({y1*-x2}x) = {n1*y2}')
    print("Mandamos los valores constantes a la derecha y las variables a la izquierda y despues los sumamos")
    print(f'({y2*x1}x) + ({y1*-x2}x) = ({n1*y2}) + ({-y1*n2})')
    print(f'({(y2*x1)+(y1*-x2)}x) = ({(n1*y2)+(-y1*n2)})')
    print("despejar el valor de la variable x")
    print(f'y = ({(n1*y2)+(-y1*n2)}) / ({(y2*x1)+(y1*-x2)})')
    e1 = (f'{((n1*y2)+(-y1*n2))/((y2*x1)+(y1*-x2))}')
    p1=Fraction(str(e1)).limit_denominator()
    print(f'x = {p1}')    #<- valor de la x
    print("Reemplazar x en la segunda ecuacion y obtener y")
    print(f'({x2}x) + ({y2}y) = {n2}')
    print(f'({x2})({p1})) + ({y2}y) = ({n2})')
    e2 = (f'{((n1*y2)+(-y1*n2))/((y2*x1)+(y1*-x2))*(x2)}')
    p2=Fraction(str(e2)).limit_denominator()
    print(f'({p2}) + ({y2}y) = ({n2})')
    print(f'({y2}y) = ({n2}) + ({-p2})')
    e3 = (f'{((n2)+(-p2))/(y2)}')
    p3=Fraction(str(e3)).limit_denominator()
    print(f'(y) = ({p3})')  #<-valor de la y
    print(f'Los valores obtenidos son: x = {p1}, y={p3}')

else:
    print("Ha seleccionado una opción que no esta disponible")    
