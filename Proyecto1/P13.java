/*
*	Escribir un programa que reciba una cadena de caracteres y la
*	imprima alrrevez
*/
import java.util.Scanner;

public class P13{
	public static void main(String[] args) {
		//Variables
		Scanner in = new Scanner(System.in);
		String cadena;
		//Solicitud de datos
		System.out.printf(" Ingresa la cadena: ");
		cadena = in.nextLine();
		//Proceso
		System.out.printf(" %s -> ",cadena);
		for(int i=(cadena.length()-1) ;i >= 0 ; i--){
			System.out.printf("[%c]",cadena.charAt(i));
		}
	}
}