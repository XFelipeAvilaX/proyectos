#Te piden que realices muchas sumas desde un valor A hasta un valor B. Por ejemplo, si
#A es igual a 250 y B es igual a 252, tu tarea es sumar 250 + 251 + 252, es decir, tienes
#que sumar todos los números desde A hasta B incluyendo A y B.
#Debes tener cuidado porque no sabes si A es mayor o menor que B, por ejemplo, A
#puede ser 90 y B puede ser 85 en cuyo caso debes sumar 85+86+87+88+89+90.

#valores de entrada en bajada 3, 5 8, 90 92, -10 -8
#valores de salida 26, 273, -27

x = int(input())
if x >= 1 and x <= 30:
    limiteinf=pow(-10, 9)
    limitesup=pow(10, 9)
    indice=0
    a=0
    b=0
    aux=0
    formula=0
    n=0
    listasuma=[]
    while indice<x:
        suma=0
        cadena = input()
        y = cadena.split(" ")
        a = int(y[0])
        b = int(y[1])
        if a>=limiteinf and a<=limitesup and b>=limiteinf and b<limitesup:
            if a>b:
                aux=a
                a=b
                b=aux
            n=(b-a)+1
            formula=((a+b)*n)/2
            listasuma.append(formula)
            indice+=1
    for i in listasuma:
        if i:
            print(int(i))