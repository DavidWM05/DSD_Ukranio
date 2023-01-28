/*
*   Podemos resolver la condición de competencia haciendo que el método
*   modifica() se ejecute sólo por un hilo a la vez con synchronized quedando:
*
*   public synchronized void modifica()
*
*   Pruébela para verificar que ya no hay inconsistencias.
*/
import java.util.*;
import java.io.*;

public class P16 implements Runnable{
    public static int numero=0;//Variable compartida
    public static int n=0;

    public P16(int n){
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
        P16 t = new P16(aux);

        Thread t1 = new Thread(t,"primero");
        Thread t2 = new Thread(t,"segundo");

        t1.start();
        t2.start();

        t1.join(0);
        t2.join(0);
        System.out.println(P16.numero);
    }
    public synchronized void modifica(){
        
        if(Thread.currentThread().getName().equals("primero")){
            numero++;
        }else if(Thread.currentThread().getName().equals("segundo")){
            numero--;
        }
    }
}