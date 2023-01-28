/*
*	La cadena de Comida “Hamburguesas Teresita” quiere dar una promoción a
*	las mujeres entre 16 y 22 años o aquellas con nombre “Teresa”, “Tere”
*	o “Teresita”, en estos casos, el sistema debe dar un descuento de 7%
*	en el valor de la compra. Escribir un programa que solicite el valor
*	de la compra, el primer nombre, edad y sexo del cliente e indique 
*	el monto final a pagar. El nombre del cliente puede ser escrito en
*	mayúsculas o minúsculas sin que esto afecte el cálculo final.
*/
import java.util.Scanner;

public class P06{
	public static void main(String[] args) {
		//Variables
		Scanner in = new Scanner(System.in);
		int edad;
		boolean condicion1,condicion2,condicion3;
		double compra,descuento=0.17;
		String nombre, sexo,aux;
		//Solicitud de datos
		System.out.printf(" Ingresa tu nombre: ");
		nombre = in.nextLine();
		System.out.printf(" Ingresa tu sexo M = mujer | H = hombre: ");
		sexo = in.nextLine();
		System.out.printf(" Ingresa tu edad: ");
		edad = in.nextInt();
		System.out.printf(" Compra $ ");
		compra = in.nextDouble();
		//Conversion a mayusculas
		aux = nombre.toUpperCase();
		sexo = sexo.toUpperCase();
		//Condiciones
		condicion1 = aux.equals("TERESA") || aux.equals("TERE") || aux.equals("TERESITA");
		condicion2 = sexo.equals("M");
		condicion3 = (edad>=16 && edad<=22);
		//Condicional if de descuento
		if(condicion1 && condicion2 && condicion3){
			compra -= compra*descuento;
			System.out.printf(" %s, Tu Hamburguesa tiene descuento. Total = $%.2f ",nombre,compra);
		}else{
			System.out.printf(" %s, no optienes el descuento. Total = $%.2f ",nombre,compra);
		}
	}
}