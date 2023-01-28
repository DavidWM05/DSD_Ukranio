/*
*   4.- Cada término de la serie de Fibonacci se forma sumando los dos términos 
    anteriores. Elabore un programa similar que cree una serie sumando los tres 
    términos anteriores. El programa deberá imprimir los primeros 20 términos de esta serie.
*/
public class P04Fibonacci {
    public static void main(String[] args) {
        int w=0,x=1,y=1,z=0;

        System.out.printf(" 0 1 1 ");
	for(int i=1;i<=17;i++){
            z=w+x+y;
            w=x;
            x=y;
            y=z;
            System.out.printf("%d ",z);
        }
        System.out.println();
    }
}