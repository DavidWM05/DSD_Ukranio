/*
*	Escribe un programa que pida 2 números e indique si uno es múltiplo 
*	del otro, ejemplo: 2 y 4, el 4 es múltiplo de 2; otro ejemplo 9 y 3,
*	el 9 es múltiplo de 3.
*/
import java.util.*;

public class P08{
	public static void main(String[] args) {
		//Variables
		Scanner in = new Scanner(System.in);
		int a,b;
		//Solicitud de datos
		System.out.printf("Ingresa el primer numero: ");
		a = in.nextInt();
		System.out.printf("Ingresa el segundo numero: ");
		b = in.nextInt();
		//proceso
		if((a%b)==0){
			System.out.println(" "+a+" es multiplo de "+b);
		} else if((a%b)==0){
			System.out.println(" "+b+" es multiplo de "+a);
		} else
			System.out.println(" ninguno es multiplo");
	}
}