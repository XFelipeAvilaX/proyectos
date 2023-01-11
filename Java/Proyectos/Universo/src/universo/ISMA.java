/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ISMA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        char [] vocabulario = {'A', 'B','C'};
        for (char simbolo : vocabulario) {
            System.out.println("Simbolo: " + simbolo);
        }
        int sizeUniversoDiscurso = random.nextInt(1000);
        String[] universoDiscurso = new String[sizeUniversoDiscurso];
        System.out.print("W(V) = {");
        for (int i = 0; i < sizeUniversoDiscurso; i++) {
            String cadena;
            do {
                int sizeCadena = random.nextInt(100);
                cadena = "";
                for (int j = 0; j < sizeCadena; j++) {
                    cadena += vocabulario[random.nextInt(3)];
                }
            } while (evaluarSiExiste(cadena, universoDiscurso));
            universoDiscurso[i] = cadena;
            System.out.print(" " + universoDiscurso[i] + ",");
        }
        System.out.print(" }");
        System.out.println();
        List<String> lenguaje = new ArrayList<String>();
        System.out.print("L(V) = {");
        for (String cadena : universoDiscurso) {
            if (cadena.length() >= 2) {
                if (cadena.charAt(0) == 'A' && cadena.charAt(cadena.length() - 1) == 'C') {
                    System.out.print(" " + cadena + ",");
                    lenguaje.add(cadena);
                }
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
