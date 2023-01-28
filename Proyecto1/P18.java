/*
*	Escribe un programa que lea 2 arreglos de 10 números 
*	(arreglo X, arreglo Y). El programa debe mezclarlos 
*	en un tercer arreglo (de 20 elementos obviamente) default:
*	la siguiente manera: 1er elemento del arreglo X, 1er elemento
*	del arreglo Y, 2do elemento del arreglo X, 2do elemento del 
*	arreglo Y, 3er elemento del arreglo X..., etc. El programa 
*	deberá mostrar en pantalla el arreglo resultante.
*/
public class P18{
	public static void main(String[] args) {
		//Variables
		int x[] = {1,2,3,4,5,6,7,8,9,10},
			y[] = {11,12,13,14,15,16,17,18,19,20},
			xy[] = new int[20];
		//Proceso
		for(int i=0,j=0;i<20;i+=2,j++){
			xy[i] = x[j];
			xy[i+1] = y[j];			
		}
		for(int i=0;i<20;i++)
			System.out.printf(" [%d]",xy[i]);
	}
}