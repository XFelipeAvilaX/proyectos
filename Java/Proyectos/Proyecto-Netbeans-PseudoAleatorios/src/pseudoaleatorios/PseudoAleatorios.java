/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pseudoaleatorios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PseudoAleatorios {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null; 
    FileWriter resultado = null;
    PrintWriter pw = null;
    
    
    boolean par = false;
    long cuadrado=0,semilla=0, semilla2=0;
    int total = 0, semillatamano = 0, cuadradosize;
      
    
    // utilizamos un Try, Catch, Finally, para intentar abrir el archivo de texto 
     try { 
         //instanciamos la variable con el archivo 
         archivo = new File ("instrucciones.txt");
         // instanciamos el filereader con el archivo de txt
         fr = new FileReader (archivo);
         //instanciamos el bufferedreader
         br = new BufferedReader(fr);
 
         //la variable linea guarda temporalmente la linea del fichero
         String linea, temp, tmp="", semillastr="";
           
           
         //obtenemos la semilla y el total de pseudo-nums a generar
          
         if((linea=br.readLine())!=null){ 
             semilla = Long.parseLong(linea.trim()); 
             semillatamano = linea.trim().length();
             par = (semillatamano%2 == 0) ? true : false;
         }
         if((linea=br.readLine())!=null){ 
             total = Integer.parseInt(linea.trim());
         }
           
         if(semillatamano>3){       
         // obtenemos los valores y se guardan             
            try
        {
            resultado = new FileWriter("resultado.txt");
            pw = new PrintWriter(resultado);
            System.out.println("Generando "+ total +" numeros pseudo aleatorios de: "+ semilla);
            pw.println("Generando "+ total +" numeros pseudo aleatorios de: "+ semilla);
            
            for(int i = 0; i < total; i++){
           cuadrado = semilla*semilla;
           temp = String.valueOf(semilla);
           cuadradosize = String.valueOf(cuadrado).length();
           
          if(cuadradosize > semillatamano){
				//tiene mas digitos que semilla

				if((cuadradosize - semillatamano)%2 == 0 ){
					//resultado par
					if(par){
                                            semillastr = substr(cuadrado, ((cuadradosize - semillatamano)/2), semillatamano);
						semilla2 = Long.valueOf(semillastr);
					                                     
                                        }else{
                                            semillastr = substr(cuadrado, Math.round(((cuadradosize - semillatamano)/2)), semillatamano);
						semilla2 = Long.valueOf(semillastr);
					}
				}else{
					//resultado impar
		             if(!par){ 
                                 semillastr = substr(cuadrado, ((cuadradosize - semillatamano)/2), semillatamano);
						semilla2 = Long.valueOf(semillastr);
					}else{
                                            semillastr = substr(cuadrado, Math.round(((cuadradosize - semillatamano)/2)), semillatamano);
						semilla2 = Long.valueOf(semillastr);
					}
				}

			 
	}else if(cuadradosize == semillatamano){
				semilla2 = cuadrado;
	}else{
			 tmp = "";
				for(int ii =0; ii < (semillatamano-cuadradosize); ii++){
					tmp += "0";
				}
				semilla2 = cuadrado;

	}
          
                System.out.println("Y"+i +" = "+ cuadrado +";\tX"+ (i+1) +" = "+semillastr+";\tr"+(i+1)+" = 0."+semillastr);
          
          pw.println("Y"+i +" = "+ cuadrado +";\tX"+ (i+1) +" = "+semillastr+";\tr"+(i+1)+" = 0."+semillastr);
          semilla = semilla2;
         
         
         }
            
            System.out.println("Finalizado en resultado.txt.");
          
          
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != resultado)
              resultado.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }         
         
     }
       
         
         
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }    
    
    }
    
    public static String substr(long cuadrado, int inicio, int fin){
    String string = String.valueOf(cuadrado).substring(inicio, (inicio+fin));
    return string;
    }
    
}
