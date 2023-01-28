/*
*	Escribe un programa que solicite un número al usuario y entonces
*	mostrar los números de 5 en 5 desde el número indicado hasta 150.
*	Ejemplo: si el usuario introduce el número 27, la secuencia sería
*	27, 32, 37, 42, 47..... 142, 147.
*/
import java.util.Scanner;

public class P14{
	public static void main(String[] args) {
		//Variables
		Scanner in = new Scanner(System.in);
		int numero,i;
		//Solicitud de datos
		System.out.printf(" Ingresa el numero: ");
		numero = in.nextInt();
		//Proceso
		while(numero<=150){
			System.out.printf(" [%d]",numero);
			numero+=5;
		}
	}
}