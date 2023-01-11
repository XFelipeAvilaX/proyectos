#contador de meses ingresados por su numero de mes del año
#01 = enero, 02 = febrero, etc.

enero=0
febrero=0
marzo=0
abril=0
mayo=0
junio=0
julio=0
agosto=0
septiembre=0
octubre=0
noviembre=0
diciembre=0

for i in range(5):
    cadena = input()
    mes=cadena
    if mes=="01":
        enero+=1
    if mes=="02":
        febrero+=1
    if mes=="03":
        marzo+=1   
    if mes=="04":
        abril+=1
    if mes=="05":
        mayo+=1
    if mes=="06":
        junio+=1
    if mes=="07":
        julio+=1
    if mes=="08":
        agosto+=1
    if mes=="09":
        septiembre+=1
    if mes=="10":
        octubre+=1
    if mes=="11":
        noviembre+=1
    if mes=="12":
        diciembre+=1
       
print(f"ENERO {enero}\nFEBRERO {febrero}\nMARZO {marzo}\nABRIL {abril}\nMAYO {mayo}\nJUNIO {junio}\nJULIO {julio}\nAGOSTO {agosto}\nSEPTIEMBRE {septiembre}\nOCTUBRE {octubre}\nNOVIEMBRE {noviembre}\nDICIEMBRE {diciembre}")