/*
*   Ejercicio 9:
*
*   Después de leer 
*
*   https://codigofacilito.com/articulos/clases-abstractas-interfaces-java
*
*   Modifique el código del ejercicio 7 en la clase 6 para incorporar la 
*   clase abstracta Figura con el método abstracto area() como se explica
*   en el link anterior. Herede de la clase Figura la clase Rectangulo y 
*   la clase Cuadrado y programe el método area() para que imprima el 
*   área del rectángulo y del cuadrado de dichos objetos instanciados en 
*   la función principal.
*
*   Ejercicio 10:
*
*   Incorpore la interfaz
*   
*   public interface Perimetro{
*       public static final double PI = 3.14159;
*       float imprimePerimetro();
*   }
*
*   Impleméntela en las clases Rectangulo y Cuadrado, finalmente pruébelas
*   en la función principal.
*/
public class Prueba {

    public static void main (String[] args) {
        Rectangulo rect1 = new Rectangulo(2,3,5,1);
        Cuadrado cuad1 = new Cuadrado(5,9,11,3);

        System.out.println("  Calculando el area y perimetro de un rectangulo dadas sus coordenadas en un plano cartesiano:");
        System.out.println(rect1);
        System.out.println(" El area del rectangulo es = " + rect1.area());
        System.out.println(" El perimetro del rectangulo es = " + rect1.imprimePerimetro());
        System.out.println("***********************************************************************************************");
        System.out.println("  Calculando el area y perimetro de un cuadrado dadas sus coordenadas en un plano cartesiano:");
        System.out.println(cuad1);
        System.out.println(" El area del cuadrado es = " + cuad1.area());
        System.out.println(" El perimetro del cuadrado es = " + cuad1.imprimePerimetro());
    }
}