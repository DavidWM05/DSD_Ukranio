/*
*   6.- Elabore un programa similar al anterior, pero utilizando la clase StringBuilder
*   y el método append para almacenar la cadena grande, así como el método indexOf para
*   buscar la subcadena “IPN”. Posteriormente y haciendo uso del método System.nanoTime()
*   compare los tiempos de ejecución del ejercicio anterior con el actual haciendo las
*   búsquedas en una cadena suficientemente grande donde al menos en uno de los dos casos
*   el tiempo sea aproximadamente de un segundo.
*/
import java.util.Random;

public class P06cadena {
    public static void main(String[] args) {
        //Variables
        long inicioT=System.currentTimeMillis(); //Inicio tiempo de ejecucion
        StringBuilder str = new StringBuilder();
        int n,cont=0;
        n = Integer.parseInt(args[0]);
        
        for (int i=0; i<n; i++) {
            str.append(crear() + " ");   
        }
        
        //Busqueda
        //System.out.println(str);
        System.out.println();
        int index = str.indexOf("IPN");
        while(index >= 0){
            index = str.indexOf("IPN", index+1);
            cont++;
        }
        //System.out.println("Total IPN = " + cont);

        long finT = System.currentTimeMillis(); //Fin tiempo de ejcucion
        double tiempo = (double)((finT-inicioT)/1000.0);
        System.out.println("Tiempo = "+ tiempo + "s");
    }

    private static String crear() {
        String aux = "";
        Random nrandom = new Random();

        for (int i=0; i<3; i++) {
            aux = aux + (char)(nrandom.nextInt(26)+'A');
        }
        return aux.toString();
    }
}