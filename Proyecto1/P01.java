/*
*	Dados los valores del radio de un círculo y su altura, calcular: el volumen
*	del cono, el volumen del cilindro e indicar la diferencia de volumen entre 
*	ambos. Los resultados deben mostrarse en pantalla con 4 decimales.
*/
public class P01{
	public static void main(String[] args) {
		double r= Double.parseDouble(args[0]),h=Double.parseDouble(args[1]); //radio, altura
		double pi = 3.1416,cono,cilindro;

		cono = (pi*(r*r)*h)/3.0;
		cilindro = pi*(r*r)*h;

		System.out.printf("Cono = %.4f cm^3 \n",cono);
		System.out.printf("Cilindro = %.4f cm^3\n",cilindro);
		System.out.printf("Diferencia = %.4f cm^3\n",(cilindro-cono));
	}
}