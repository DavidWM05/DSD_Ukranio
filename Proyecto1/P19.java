/*
*	Leer una serie de 10 números, moverlos una posición hacia adelante
*	en el arreglo y mostrar el arreglo resultante. Ejemplo, tenemos el
*	siguiente arreglo 1,2,3,4,5, si desplazamos los elementos una posición
*	hacia adelante debemos obtener: 5,1,2,3,4. Es decir, el primer elemento
*	se mueve hacia el segundo lugar, el segundo al tercero, etc., y el último
*	al primero.
*/
import java.util.*;

public class P19{
	public static void main(String[] args) {
		//Variables
		Scanner in = new Scanner(System.in);
		int arreglo[] = new int[10],a = 0,b=0;
		//Proceso
		for(int i=0;i<10;i++){
			System.out.printf(" -> Ingresa un numero: ");
			arreglo[i] = in.nextInt();	
		}
		//proceso - posicion
		for(int i=0;i<10;i++){
			if(i==0){
				a = arreglo[i];
			}else if(i>0 && i<9){
				b = arreglo[i];
				arreglo[i] = a;
				a = b;
			}else if(i==9){
				b = arreglo[i];
				arreglo[i] = a;
				arreglo[0] = b;			
			}
		}
		for(int i=0;i<10;i++)
			System.out.printf(" [%d]",arreglo[i]);
	}
}