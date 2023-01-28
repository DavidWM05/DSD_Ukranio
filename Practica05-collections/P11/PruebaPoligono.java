/*
*   11. Retome la solución del ejercicio 8 en la clase 6 y modifíquelo para
*   que la clase PoligonoIrreg almacene los vértices en un objeto ArrayList
*   (véase https://www.geeksforgeeks.org/list-interface-java-examples/?ref=gcse ).
*   Asimismo, dentro del método toString haga uso de un bucle for-each para 
*   imprimir los elementos de ArrayList.
*/
import java.util.Random;
public class PruebaPoligono {
    public static void main (String[] args) {
        //Tiempo de ejecucion
        long inicioT=System.currentTimeMillis();
        //Variables
        int vertices=10;
        Random rand = new Random();
        PoligonoIrreg pol = new PoligonoIrreg(); 
        Coordenada aux[] = new Coordenada[vertices];
        //Generacion de coordenadas aleatorias
        for(int i =0 ;i<vertices;i++){
            int x = rand.nextInt(15+1)+1;
            int y = rand.nextInt(15+1)+1;
            pol.anadeVertice(new Coordenada(x,y));
            //System.out.println(i);
        }
        //Impresion de datos
        System.out.println("Coordenadas del poligono irregular:");
        System.out.println(pol.toString());
        //Tiempo de ejecucion
        long finT = System.currentTimeMillis(); //Fin tiempo de ejcucion
        double tiempo = (double)((finT-inicioT)/1000.0);
        System.out.println("Tiempo = "+ tiempo + "s");        
    }
}