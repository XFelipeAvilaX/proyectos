TamañoDeLista=int(input("Ingrese el tamaño de la lista de numeros: "))
listaA=[]

for k in range (TamañoDeLista):
   valor=int(input(f'Ingrese el valor "{k+1}" de la lista : '))
   listaA.append(valor)

print(listaA)

def Division (listaA):

    Pivote = listaA [0]
    NumerosMenores = []
    NumerosIguales = []
    NumerosMayores = []

    for i in range(1, len(listaA)):
        if listaA[i] < Pivote:
            NumerosMenores.append(listaA[i])
        elif listaA[i] == Pivote:
            NumerosIguales.append(listaA[i])
        else:
            NumerosMayores.append(listaA[i])

    return NumerosMenores, Pivote, NumerosIguales,NumerosMayores

def QuickSort (listaA):
    if len(listaA) < 2:
        return listaA
    
    NumerosMenores, Pivote, NumerosIguales,NumerosMayores = Division(listaA)

    return QuickSort(NumerosMenores) + [Pivote] + QuickSort(NumerosIguales) + QuickSort(NumerosMayores)

print (QuickSort(listaA))
