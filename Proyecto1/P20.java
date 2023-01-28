/*
*	Escribe un programa que genere 10 números al azar y los almacene en un arreglo.
*	El programa debe mostrar el arreglo e indicar cuál es el mayor y cuál es el 
*	menor de los números.
*/

public class P20{
	public static void main(String[] args) {
		//Variables
		int arreglo[] = new int[10],max,min,a = 0,b = 0;
		//Proceso - random
		for(int i=0;i<10;i++) 
			arreglo[i] = (int)(Math.random()*30+1);
		//proceso - mayor
		for(int i=0;i<10;i++){
			if(i==0){
				a = arreglo[i];
				continue;
			}
			b = arreglo[i];
			if(a>b)
				continue;
			else if(a<b)
				a = b;
		}
		max = a;
		//proceso - menor
		for(int i=0;i<10;i++){
			if(i==0){
				a = arreglo[i];
				continue;
			}
			b = arreglo[i];
			if(a<b)
				continue;
			else if(a>b)
				a = b;
		}
		min = a;
		//Impresion de datos
		for(int i=0;i<10;i++)
			System.out.printf(" [%d]",arreglo[i]);
		System.out.println(" ");
		System.out.println(" El numero mayor es "+max);
		System.out.println(" El numero menor es "+min);
	}
}