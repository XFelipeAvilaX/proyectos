package universo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class uni {

    public static void main(String[] args) {
        Random random = new Random();
        //char [] vocabulario = {'_','1', '2','3','4','5','6','7','8','9','a'};
        String[] vocabulario=new String[] {"1","2","3","4","5","6","7","8","9"};
        
        for (String simbolo : vocabulario) {
            System.out.println("Simbolo: " + simbolo);
        }
        System.out.println("cardinalidad de V:"+vocabulario.length);
        int sizeUniversoDiscurso = 1000;
        int conta=1;
        String verificador;
        int verificador2;
        String[] universoDiscurso = new String[sizeUniversoDiscurso];
        List<String> lenguaje = new ArrayList<String>();
        System.out.print("W(V) = {");
        for (int i = 0; i < sizeUniversoDiscurso; i++) {
            String cadena;
            do {
                int sizeCadena = random.nextInt(20);
                cadena = vocabulario[random.nextInt(9)];
                for (int j = 1; j < sizeCadena; j++) {
                    cadena += vocabulario[random.nextInt(9)];
                }
            } while (evaluarSiExiste(cadena, universoDiscurso));
            universoDiscurso[i] = cadena;
            
            if (conta<sizeUniversoDiscurso){
            conta=conta+1;
          System.out.print(" " + universoDiscurso[i] + ",");
          
          verificador = cadena;
          if(verificador.length()<=2){
              verificador2 = Integer.parseInt(verificador);
              if(verificador2<50){
              
              lenguaje.add(universoDiscurso[i]);
          }
          }   
      }
      else{
          System.out.print(" " + universoDiscurso[i]+" }");
          verificador = cadena;
          if(verificador.length()<=2){
             verificador2 = Integer.parseInt(verificador);
          if(verificador2<50){
              lenguaje.add(universoDiscurso[i]);
         } 
          }
          
      }
        }
        System.out.println();
        System.out.println("Propiedad: Numeros menores a 50");
        System.out.print("L(V) = { ");
        int conta2 = 1;
        for (int len = 0; len < lenguaje.size(); len++){
            if(conta2 < lenguaje.size()){
              System.out.print(lenguaje.get(len)+",");
              conta2=conta2+1;
            }
            else{
              System.out.print(lenguaje.get(len));
            } 
        }  
        System.out.print(" }");

        System.out.println();
        System.out.println("Cardinalidad de W(V): " + universoDiscurso.length);
        System.out.println("Cardinalidad de L(V): " + lenguaje.size());
        

    }

    static boolean evaluarSiExiste(String cadena, String[] universoDiscurso) {
        for (String c : universoDiscurso) {
            if (c != null) {
                if (c.equals(cadena)) {
                    return true;
                }
            }
        }
        return false;
    }
}
