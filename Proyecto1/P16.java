/*
*	En este programa la computadora debe elegir un número al azar
*	entre 1 y 100 y solicitará al usuario que adivine el numero.
*	A cada intento del usuario la computadora debe indicar si el 
*	número que el usuario introdujo es mayor o menor que el número
*	prefijado. El programa debe terminar cuando el usuario adivine
*	el número o introduzca el número 0 para salir.
*/
import java.util.Scanner;

public class P16{
	public static void main(String[] args) {
		//Variables
		Scanner in = new Scanner(System.in);
		int opcion = 1;
		long numero = 0;
		//Proceso
		while(opcion != 0){
			System.out.printf(" -> Ingresa un numero: ");
			opcion = in.nextInt();
			if(opcion==0) opcion = 0;
			else {
				int cuadrado = (int)Math.pow(opcion,2);
				numero += cuadrado;
				System.out.printf("\t\t -> %d^2 = %d\n",opcion,cuadrado);
			}
		}
		System.out.println("\t\t   Total: "+numero);		
	}
}