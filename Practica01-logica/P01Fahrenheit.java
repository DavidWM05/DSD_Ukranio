/*
*	1.- Se ha elaborado el siguiente programa para convertir
		grados centígrados a Fahrenheit. Determine cual es 
		el error y corríjalo mediante un cast para que dé el
		valor correcto.
*/
public class P01Fahrenheit {
    public static void main(String[] args){
        int a=9, b=5;
        double c= 20;
        double f;
        double div = (double)a/(double)b;
 
        f = (div*c)  + 32.0;
        System.out.println(f);
    }
}