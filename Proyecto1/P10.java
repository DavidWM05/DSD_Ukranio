/*
*	Escribe un programa que solicite al usuario un número entero
*	y dé como resultado el factorial de ese número.
*/
import java.util.*;

public class P10{
	public static void main(String[] args) {
		//Variables
		Scanner in = new Scanner(System.in);
		int numero;
		long factorial;
		//Solicitud de datos
		System.out.printf("Ingresa el numero: ");
		numero = in.nextInt();
		//Proceso
		if(numero==1)
			System.out.println(" "+numero);
		else{
			factorial = numero;
			System.out.printf(" %d! = (5)",numero);
			for(int i=(numero-1);i>=1;i--){
				factorial *=i;
				System.out.printf("(%d)",i); 
			}
			System.out.printf("= %d",factorial);
		}
	}
}