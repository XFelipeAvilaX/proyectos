import time

 
class Conejo():

  color= "undefined"
  raza="undefined"
  altura="undefined"

 
  def __init__(self,color,raza,altura):
       self.color  = color
       self.raza  = raza 
       self.altura = altura

  
  def masticar(self):
      print("Masticando")

  def saltar(self):
    suma = 0
    for x in range(5):
      suma += 1
    print("Saltando")

a = int(input("Ingrese un numero:"))
conejo = Conejo("Blanco","Hotot","40cm")
    

ini1 = time.time()
for x in range(a):
    conejo.masticar()
fin1=time.time()
tiempo1 = fin1-ini1
print("Termina en", (tiempo1)*10000, "milisegundos")

       
ini2 = time.time()
for x in range(a):
    conejo.saltar()
fin2=time.time()
tiempo2 = fin2-ini2
print("Termina en", (tiempo2)*10000,"milisegundos")

comparacion = False

comparacion = tiempo1>tiempo2

if comparacion:
   print ("El conejo tarda mas tiempo masticando que saltando")
else:
   print ("El conejo tarda mas tiempo saltando que masticando")

#Conclusion: Para el conejo Hotot es más tardado masticar que saltar