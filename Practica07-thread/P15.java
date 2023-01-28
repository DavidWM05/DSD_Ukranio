/*
*   Haciendo uso de la interfaz Runnable de Java explicada en:
*   https://www.geeksforgeeks.org/runnable-interface-in-java/?ref=gcse
*   Cree dos hilos que accedan a una variable compartida var_compartida
*   de tipo int que inicialmente tiene un valor de cero.  Ambos hilos 
*   deben ejecutar un único método run() el cual se encargará de modificar
*   la variable compartida. El método run() ejecutará en un ciclo de n 
*   veces (donde n se recibe en la línea de comandos) al método modifica()
*   el cual se encarga de incrementar en uno o decrementar en uno a 
*   var_compartida según sea el caso. Si se trata del primer hilo que se
*   creó deberá incrementar en uno la variable compartida, y si es el segundo
*   hilo se deberá decrementar en uno la variable compartida. Para identificar
*   de qué hilo se trata y pasar parámetros a los hilos léase:
*
*   https://www.geeksforgeeks.org/how-to-get-the-id-of-a-current-running-thread-in-java/#:~:text=In%20the%20run()%20method,invoked%20the%20run()%20method
*
*   Cuando ambos hilos hayan terminado de ejecutarse (véase el método join() 
*   para asegurarse que ambos hilos se han ejecutado por completo en 
*   https://www.geeksforgeeks.org/java-concurrency-yield-sleep-and-join-methods/?ref=lbp),
*   la función principal deberá imprimir el valor de la variable compartida.
*
*   Ejecute su programa varias veces incrementando n hasta poder visualizar
*   las condiciones de competencia. Es importante no imprimir nada en el 
*   programa para que el calendarizador de hilos opere de manera concurrente.
*/
import java.util.*;
import java.io.*;

public class P15 implements Runnable{
    public static int numero=0;//Variable compartida
    public static int n=0;

    public P15(int n){
        this.n = n;
    }
    public void run()
    {
        for (int i=0; i < n; i++) {
            modifica();    
        }
    }

    public static void main(String[] args) throws Exception
    {   
        int aux = Integer.parseInt(args[0]);
        P15 t = new P15(aux);

        Thread t1 = new Thread(t,"primero");
        Thread t2 = new Thread(t,"segundo");

        t1.start();
        t2.start();

        t1.join(0);
        t2.join(0);
        System.out.println(P15.numero);
    }
    public static void modifica(){
        
        if(Thread.currentThread().getName().equals("primero")){
            numero++;
        }else if(Thread.currentThread().getName().equals("segundo")){
            numero--;
        }
    }
}