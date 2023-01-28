/*
*	5.- El programa consiste en generar n “palabras” de tres letras mayúsculas
*	aleatorias e irlas concatenando en una cadena gigante, manteniendo un 
*	espacio en blanco de separación entre cada palabra. Posteriormente debe
*	hacerse la búsqueda de la subcadena “IPN” en la cadena gigante y contabilizar
*	el número de apariciones, así como la posición dentro de la cadenota donde
*	apareció.
*
*	El programa debe recibir el número n como parámetro en la línea de comandos
*	de manera que debe incluir al inicio algo como:
*
*	n = Integer.parseInt(args[0]);
*
*	Por cuestiones de desempeño la cadena deberá almacenarse en un arreglo de
*	tipo byte:
*
*			byte[] cadenota = new byte[n*4];  
*
*	¿De acuerdo con la teoría de la probabilidad cuantas palabras deberían
*	generarse para que se dé una ocurrencia? ¿Y para diez ocurrencias?
*/
import java.util.Random;
import java.io.*;
import java.util.concurrent.*;

public class P04cadena {
   public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int cont=0;
        byte[] cadenota = new byte[n*4];
        Random nrandom = new Random();
        String palabra ="";      
           
        for(int i=0;i<(n*4);i++){ 	            
            byte x = (byte) (nrandom.nextInt(26)+'A');    
            cadenota[i]=x;  //Se guarda en la cadena
//            System.out.println(i+" "+cadenota[i]);
        }

	for(int i=3;i<(n*4);i+=4){
		cadenota[i]=' ';	
	}

//        System.out.println();
        for(int i=0;i<(n*4);i++){
//                System.out.println(i+" "+cadenota[i]);
        }
	
	
        int ipn=0;
        String aux="";
	
        for(int i =0,j=0;i<(n*4);i++){
            palabra = palabra + (char)cadenota[i];            
            j++;
	    if(j==4){
//	     System.out.printf("%s",palabra);
	     	if(palabra.equals("IPN ")){
			ipn++;
			aux=aux+String.valueOf(i-3)+"|";	
		}
	     	palabra = "";
		j=0;
	     }		    
        }
	
	System.out.println("Posiciones -> |"+aux);
	System.out.println("Total = "+ipn);


	long timeE = System.nanoTime();
	
	System.out.println("Tiempo = "+seconds.toSeconds(timeE));
     }
}