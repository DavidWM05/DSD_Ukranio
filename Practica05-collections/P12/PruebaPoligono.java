/*
*   12. Incluya en la clase PoligonoIrreg el método ordenaVertices para ordenar
*   los vértices de menor a mayor en función de su magnitud (distancia de la 
*   coordenada al origen) con ayuda de la interfaz Comparator 
*   (véase https://www.geeksforgeeks.org/comparator-interface-java/?ref=gcse ).
*   Se recomienda agregar al objeto coordenada un nuevo miembro magnitud para 
*   facilitar el ordenamiento.
*
*   En el método principal instancie un objeto PoligonoIrreg al cual posea 10 
*   vértices, todos ellos con valores reales aleatorios tanto positivos como 
*   negativos comprendidos entre -100.000 y 100.000 Imprima los vértices del 
*   polígono, mande a llamar el método de ordenamiento y posteriormente vuelva a
*   imprimir los vértices del polígono. Es importante que los valores en las coordenadas
*   tengan al menos tres dígitos decimales aleatorios.
*/
import java.util.Random;
public class PruebaPoligono {
    public static void main (String[] args) {
        //INICIO DE TIEMPO DE EJECUCION
        long inicioT=System.currentTimeMillis();
        //VARIABLES
        int vertices=10;            //VERTICES
        Random rand = new Random(); //RANDOM
        PoligonoIrreg pol = new PoligonoIrreg(); 
        Coordenada aux[] = new Coordenada[vertices];
        //GENERACION DE COORDENADAS ALEATORIAS
        for(int i =0 ;i<vertices;i++){                             
            double x = Math.random()*(100-(-100)+1)-100;
            double y = Math.random()*(100-(-100)+1)-100;
            pol.anadeVertice(new Coordenada(x,y));
        }
        System.out.println("Coordenadas del poligono irregular:");
        System.out.println(" DESORDENADO\n\n"+pol.toString());
        pol.ordenaVertice();
        System.out.println(" ORDENADO\n\n"+pol.toString());
        //FIN DE TIEMPO DE EJECUCION
        long finT = System.currentTimeMillis(); 
        double tiempo = (double)((finT-inicioT)/1000.0);
        System.out.println("Tiempo = "+ tiempo + "s");        
    }
}