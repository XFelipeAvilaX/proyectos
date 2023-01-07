
package comprobador;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comprobador {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String comprobador = ("^(x)*(y)+z(y|x)*(z|x)+$");
        String cadena, respuesta;   
        //ciclo de solicitar cadena
        while(true){
            System.out.println("Ingrese una cadena:");
            //yyyyyyyyyzyxzx
            //xxxxxxxxxyyyyyyyyyyyzzzzzzzzzzzzxxxxxxx
            cadena = scan.next();            
            Pattern pat = Pattern.compile(comprobador);
            Matcher mat = pat.matcher(cadena);     
            boolean find = mat.find();
            if(find == false){
                System.out.println("La cadena '" +cadena+"' no es valida"); 
            }
            else{
                System.out.println("La cadena '" +cadena+"' es valida");
            }
            System.out.println("Desea introducir mas cadenas? (si/no)");
            respuesta = scan.next();
            if(respuesta.equals("no"))
                break;
            if(respuesta.equals("si")){ 
            }
            else{
                System.out.println("Error de respuesta");
                break;
            }
        }   
    }
}
