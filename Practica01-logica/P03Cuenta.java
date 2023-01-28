/*
*   3.- Escriba un programa que cuente del 1 al 15,
*       imprima cada número y luego cuente hacia 
*       atrás de dos en dos hasta el 1, imprimiendo
*       nuevamente cada número.
*/
public class P03Cuenta {
  
  public static void main(String[] args) {
    
    System.out.println("    Ascendente");
    
    for(int i=1; i<=15; i++){
      System.out.println("numero: " + i);
    }
    
    System.out.println("    Descendente 2 en 2");
    
    for(int i=15; i>0; i-=2){
      System.out.println("numero: " + i);
    }
  }
}