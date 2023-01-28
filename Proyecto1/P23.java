/*
*	Escribe un programa que solicite edades y estaturas de personas y guarde los datos
*	en un archivo de texto de la siguiente manera: edad, estatura. El programa debe crear
*	el archivo en caso de que este no exista. En caso de que el archivo ya exista entonces
*	deberá añadir los datos al archivo. El programa debe terminar cuando el usuario 
*	introduzca el número 0 como edad.
*/
import java.util.*;
import java.io.*;

public class P23{
	public static void main(String[] args) {
		//Variables
		Scanner in = new Scanner(System.in);
		int edad=1,estatura=1;
		//Proceso - escribir
		try {
            File archivo = new File("personas.txt");
            FileWriter escribir = new FileWriter(archivo, true);
            while(edad!=0){
            	System.out.printf(" Ingresa edad: ");
            	edad = in.nextInt();
            	if(edad!=0){
            		System.out.printf(" Ingresa estatura: ");
            		estatura= in.nextInt();            	
            		escribir.write(" |Edad = "+String.valueOf(edad)+"| Estatura = "+String.valueOf(estatura)+"|");
                	escribir.write("\r\n"); 	
            	}         
            }
            escribir.close(); //Se cierra la conexion
        }catch (Exception e) {
            System.out.println("Error el archivo");
        }
	}
}