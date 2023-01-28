/*
*	2.- Elabore una línea de código que imprima
*		con printf el valor de Math.PI con 10 
*		dígitos decimales
*/
import java.lang.Math.*;
public class P02Numerpi {
  
  public static void main(String[] args){
    
    double pi = Math.PI;
    
    System.out.printf("%.10f \n", pi);
  }
  
}