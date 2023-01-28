/*
*	Escriba un programa que calcule las dos respuestas de x en
*	formato decimal (en caso de que no existan soluciones reales
*	debe indicarlo al usuario con un mensaje) que son soluciones
*	de una ecuación de segundo grado.
*/
import java.util.Scanner;

public class P04{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double a=0,b=0,c=0,x1,x2,aux;
		
		System.out.printf("Ingresa a: ");
		a = in.nextDouble();
		System.out.printf("Ingresa b: ");
		b = in.nextDouble();
		System.out.printf("Ingresa c: ");
		c = in.nextDouble();

		aux = (Math.pow(b,2)-4*a*c);
		if(aux>=0){
			x1 = ((-1)*b+Math.sqrt(aux))/(2*a);
			x2 = ((-1)*b-Math.sqrt(aux))/(2*a);
			System.out.printf(" X1 = %.4f \n X2 = %.4f\n",x1,x2);
		}else System.out.println("Las raices son imaginarias");
	}
}