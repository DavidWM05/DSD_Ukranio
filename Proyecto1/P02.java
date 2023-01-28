/*
*	Escribe un programa que calcule el área de un trapecio de lados a y b
*	y altura h mediante la formula:
*	A = h*(a + b)/2
*/
public class P02{
	public static void main(String[] args) {
		double  a = Double.parseDouble(args[0]),
				b = Double.parseDouble(args[1]),
				h = Double.parseDouble(args[2]); //lado a, lado b, altura h
		double Area;

		Area = ((a+b)/2)*h;

		System.out.printf("Area del trapecio = %.2f cm^2",Area);
	}
}