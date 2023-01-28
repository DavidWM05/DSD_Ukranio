/*
*	Escribe un programa que solicite al usuario los elementos de dos matrices 
*	(una matriz de 3 renglones x3 columnas por una de 2 renglones x3 columnas).
*	 El programa debe realizar la multiplicación de ambas matrices y mostrar el
*	 resultado.
*/
public class P22{
	public static void main(String[] args) {
		//Variables
		int a[][] = new int[3][3],
			b[][] = new int[2][3],
			c[][] = new int[2][3];
		//Proceso - random
		for(int i=0; i < 3; i++)
			for(int j=0; j < 3 ; j++) 
				a[i][j] = (int)(Math.random()*9+1);

		for(int i=0; i < 2; i++)
			for(int j=0; j < 3 ; j++) 
				b[i][j] = (int)(Math.random()*9+1);
		//Impresion de matrices
		System.out.printf("A = \n");
		for(int i=0; i < 3; i++){
			for(int j=0; j < 3 ; j++) 
				System.out.printf(" |%d|",a[i][j]);
			System.out.printf("\n");
		}
		System.out.printf("B = \n");
		for(int i=0; i < 2; i++){
			for(int j=0; j < 3 ; j++) 
				System.out.printf(" |%d|",b[i][j]);
			System.out.printf("\n");
		}
		//multiplicacion
		for(int i = 0; i < 3; i++){//Columnas de la segunda matriz
			for(int j = 0; j < 2 ; j++){//Filas de la primera matriz
				int multiplicacion=0;
				for(int k=0; k < 3 ;k++){//Columna de la primera
					multiplicacion += b[j][k]*a[k][i];
				}
				c[j][i] = multiplicacion;
			}
		}
		System.out.printf("B * A = \n");
		for(int i=0; i < 2; i++){
			for(int j=0; j < 3 ; j++) 
				System.out.printf(" |%d|",c[i][j]);
			System.out.printf("\n");
		}
	}
}