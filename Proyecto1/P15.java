/*
*	En este programa la computadora debe elegir un número al azar
*	entre 1 y 100 y solicitará al usuario que adivine el numero.
*	A cada intento del usuario la computadora debe indicar si el 
*	número que el usuario introdujo es mayor o menor que el número
*	prefijado. El programa debe terminar cuando el usuario adivine
*	el número o introduzca el número 0 para salir.
*/
import java.util.Scanner;

public class P15{
	public static void main(String[] args) {
		//Variables
		Scanner in = new Scanner(System.in);
		int numero,opcion=0;
		//Proceso
		numero = (int)(Math.random()*100+1);
		System.out.println(numero);
		while(opcion!=numero){
			System.out.printf(" -> Ingresa el numero: ");
			opcion = in.nextInt();
			if(opcion==0) opcion = numero;
			else if(opcion < numero)
				System.out.println(" El numero introducido es menor");
			else if(opcion > numero)
				System.out.println(" El numero introducido es mayor");
		}
		System.out.println(" -> Juego terminado, el numero era "+numero);		
	}
}