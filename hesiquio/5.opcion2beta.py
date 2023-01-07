#import csv
#with open("C:/Users/-thepow/Desktop/prueba.txt", "r", newline='') as csvfile:
#    spamreader = csv.reader(csvfile, delimiter=',')
#
#    for row in spamreader:
#        print(', '.join(row))

#with open("C:/Users/-thepow/Desktop/prueba.txt", "r") as stop_words: 
#    lineas = [linea.strip() for linea in stop_words]
#
#for linea in lineas:
#    print(linea[0])


#with open("C:/Users/-thepow/Desktop/prueba.txt", "r") as tf:
#    lines = tf.read().split(',')
#    
#for line in lines:
#    print(line)

def mode(dataset):
    frequency = {}

    for value in dataset:
        frequency[value] = frequency.get(value, 0) + 1

    most_frequent = max(frequency.values())

    modes = [key for key, value in frequency.items()
                      if value == most_frequent]

    return modes

stop_words=open("C:/Users/-thepow/Desktop/prueba.txt","r")

lineas = [linea.split() for linea in stop_words]
total=list()
for linea in lineas: 
    total+=linea
print(total)

l = total

print(mode(l))
#print(list(total)[0])