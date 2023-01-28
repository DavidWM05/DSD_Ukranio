/*
*	Leer 10 números enteros, guardarlos y mostrarlos
*	en el mismo orden en que fueron
*/
import java.util.*;

public class P17{
	public static void main(String[] args) {
		//Variables
		Scanner in = new Scanner(System.in);
		int arreglo[] = new int[10];
		//Proceso
		for(int i=0;i<10;i++){
			System.out.printf(" -> Ingresa un numero: ");
			arreglo[i] = in.nextInt();	
		}
		for(int i=0;i<10;i++)
			System.out.printf(" [%d]",arreglo[i]);
	}
}