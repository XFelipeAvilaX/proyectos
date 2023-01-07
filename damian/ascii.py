numeros = [83,65,76,85,68,79,83,32,68,69,32,73,83,77,65,45,53] #SALUDOS DE ISMA-5
size = len(numeros) #longitud de la frase)
s = 0 #contador inicial del bucle
cadenaf = '' #la cadena resultante de la frase

while s < size:

    binario = format(numeros[s], '08b')

    input_string=int(binario, 2);
 
    #Obtain the total number of bytes
    Total_bytes= (input_string.bit_length() +7) // 8
 
    #Convert these bits to bytes
    input_array = input_string.to_bytes(Total_bytes, "big")
 
    #Convert the bytes to an ASCII value and display it on the output screen
    ASCII_value=input_array.decode()   
    cadenaf = cadenaf+ASCII_value

    print ('Caracter: '+ASCII_value)
    n = 0
    while n < 8:
        if binario[n]=='0':
            print('0')
            n=n+1
        else:
            print('1')
            n=n+1
        

    s = s+1
print(cadenaf)    
