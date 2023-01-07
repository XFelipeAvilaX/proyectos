'''
descripción del codigo: 
Codigo para calcular el promedio de N calificaciones de M estudiantes de ISC
'''
condicion="quedarte"
while condicion != "salir":
    print("Codigo para calcular el promedio de N calificaciones de M estudiantes de ISC")
    estudiante=input("Ingrese el nombre del estudiante: ")
    while True:
        try:
            calificaciones=int(input("Ingrese la cantidad de calificaciones para promediar: "))
            break
        except ValueError:
            print("Oops!  Inserta un número por favor...")
    suma=0
    # en el siguiente for la variable que lo controla es 'f', inicia desde cero
    # for (int f=0; f<2; f++) ejemplo de for en java
    for f in range(calificaciones):
        valor=int(input("Ingrese la calificación " + str(f+1)+": "))
        #print("la variable f que controla el For vale: ",f)
        suma=suma+valor
    promedio=suma/calificaciones
    print("El promedio de ",estudiante," es: ", round(promedio, 2))
    condicion=input("Si desea salir del programa escriba 'salir':")
print("Codigo finalizado, gracias por utilizarlo")
#fin del Codigo.