/*
*	Escribe un programa que lea un arreglo bidimensional de 5x5 y muestre la suma
*	de la diagonal principal sin utilizar ciclos anidados. “En álgebra lineal, la
*	diagonal principal de una matriz cuadrada contiene los elementos situados desde
*	A(1,1) hasta A(N,N).
*/
public class P21{
	public static void main(String[] args) {
		//Variables
		int arreglo[][] = new int[5][5],suma=0;
		//Proceso - random
		for(int i=0; i < 5; i++)
			for(int j=0; j < 5 ; j++) 
			arreglo[i][j] = (int)(Math.random()*9+1);
		//Impresion de datos
		for(int i=0; i < 5; i++){
			for(int j=0; j < 5 ; j++){ 
				System.out.printf(" |%d|",arreglo[i][j]);
				if(i==j)
					suma+=arreglo[i][j];
			}
			System.out.printf("\n");
		}
		System.out.println(" la suma de la diagonal es "+suma);		
	}
}