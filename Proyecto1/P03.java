/*
*	Utilizando operaciones de división entera y módulo, convertir un número
*	dado en segundos a su equivalente en horas, minutos y segundos. Ejemplo,
*	el valor en segundos de 3725 segundos es igual a 62 minutos, lo cual
*	es igual a 1 hora, 2 minutos y 5 segundos.
*/
public class P03{
	public static void main(String[] args) {
		int  seg = Integer.parseInt(args[0]),h,m,s;
		h = seg/3600;	//Horas
		seg = seg%3600;
		m = seg/60;		//Minutos
		seg = seg%60;
		s = seg;		//Segundos
		System.out.println("Hora: "+h+"h "+m+"m "+s+"s");
	}
}