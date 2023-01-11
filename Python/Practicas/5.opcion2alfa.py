
import csv

def mode(dataset):
    frequency = {}

    for value in dataset:
        frequency[value] = frequency.get(value, 0) + 1

    most_frequent = max(frequency.values())

    modes = [key for key, value in frequency.items()
                      if value == most_frequent]

    return modes

'''
with open("C:/Users/-thepow/Desktop/prueba.txt", "r") as f:
    line = csv.reader(f, delimiter=',')

    print (list(line)[0])

print(mode(line))
'''

salida = []
with open("C:/Users/-thepow/Desktop/prueba.txt", "r") as f:
    lineas = [linea.split() for linea in f]

for linea in lineas:
    print(linea)
    print(mode(linea))
