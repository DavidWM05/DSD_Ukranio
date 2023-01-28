/*
*	Escribe un programa para convertir una calificación de 0 a 100 al sistema A-F
*	utilizando la siguiente tabla: (A - Muy bien) = 90-100, (B = Bien) 
*	80 - 89, (C - Suficiente) = 60 -79, (F - No suficiente) = 0 - 59. El
*	usuario debe escribir la calificación con número e indicar si quiere
*	que la conversión le muestre la letra (A, B, C, F) o la descripción
*	correspondiente (Muy Bien, Bien, Suficiente, No Suficiente).
*/
import java.util.Scanner;

public class P05{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int calificacion=0,opcion;
		String op1[] = {"A","B","C","F"},op2[] = {"Muy Bien","Bien","Suficiente","No suficiente"};

		System.out.printf("Ingresa la calificacion: ");
		calificacion = in.nextInt();
		System.out.printf("Formato a utilizar 1 = letras | 2 = descripcion: ");
		opcion = in.nextInt();
		System.out.println(" ");

		switch(opcion){
			case 1:
					if(calificacion >= 90 && calificacion <=100){
						System.out.println(" "+calificacion+" - "+op1[0]);
					}else if(calificacion >= 80 && calificacion <=89){
						System.out.println(" "+calificacion+" - "+op1[1]);
					}else if(calificacion >= 60 && calificacion <=79){
						System.out.println(" "+calificacion+" - "+op1[2]);
					}else if(calificacion >= 0 && calificacion <=59){
						System.out.println(" "+calificacion+" - "+op1[3]);
					}
			break;
			case 2:
					if(calificacion >= 90 && calificacion <=100){
						System.out.println(" "+calificacion+" - "+op2[0]);
					}else if(calificacion >= 80 && calificacion <=89){
						System.out.println(" "+calificacion+" - "+op2[1]);
					}else if(calificacion >= 60 && calificacion <=79){
						System.out.println(" "+calificacion+" - "+op2[2]);
					}else if(calificacion >= 0 && calificacion <=59){
						System.out.println(" "+calificacion+" - "+op2[3]);
					}
			break;
			default: System.out.println("Opcion no valida");
		}
	}
}