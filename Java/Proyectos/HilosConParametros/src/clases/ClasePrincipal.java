package clases;

import java.util.Scanner;

public class ClasePrincipal {
    public static void main(String[] args) {
        
        Proceso hilo1 = new Proceso();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Proporciona los 2 valores a sumar:");
        System.out.println("Valor 1");
        int a = scanner.nextInt();
        System.out.println("Valor 2");
        int b = scanner.nextInt();
        int cont1=1;
        
        if(cont1==0){
                hilo1.ValorPedido(a,b);  
                hilo1.start();
        }
        else {
                hilo1.ValorPedido(a,b);  
                hilo1.start();
                
                }
        
    }
    
}
