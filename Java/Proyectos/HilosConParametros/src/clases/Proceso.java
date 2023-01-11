package clases;

public class Proceso extends Thread{
    
    int num_int;
    int num_int2;

    @Override
    public void run(){

     int suma;
     suma = num_int+num_int2;
        System.out.println("El valor de la suma de los valores es:"+suma);
    }
    
    public void ValorPedido(int valor1,int valor2){
        this.num_int = valor1;
        this.num_int2 = valor2;
    }
    
}
