import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Para los Pool Threads
import java.lang.Runnable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 // Creamos la clase que ordenará un trozo del map
 class StringOrdenator implements Runnable {

    // Arreglo para ordenar el mapa
    String trozoCadena;

    public StringOrdenator( String str ) {
        trozoCadena = str;
    }

    // Ordena la lista que le pasamos
    public synchronized void run(){
        
        // Cnvierte el string en un NUEVO arreglo que se ordena
        char[] char_ar = trozoCadena.toCharArray();
        Arrays.sort( char_ar );
        System.out.println(char_ar);

        // System.out.println("\n\n\n\033[1;93m Un thread ha terminado \033[0m\n\n\n");
        
    }
}


public class TestPool {

    public static void main(String[] args) {
        
        // Mapa a ser ordenado
        Map<Character, Integer> chars = new HashMap<Character, Integer>();
        String test  = "Anita lava la tina";

        // String para guardar la biblia
        StringBuilder biblia = new StringBuilder();
        
        // El archivo en sí
        File laBiblia = new File("BIBLIA_COMPLETA.txt");
        // File laBiblia = new File("Clase 15\\BIBLIA_COMPLETA.txt");
        
        // Para leer el archivo
        try (BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(laBiblia), "UTF-8") )) {
            String line;
            // Obtenemos el caracter siguiente
            while ( (line = reader.readLine()) != null ) {
                biblia.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        int quintos_de_biblia = biblia.length()/5;
        int ultimo_quinto = 0;

        // Creamos nuestros cachos de biblia
        Runnable cacho_1 = new StringOrdenator( biblia.substring(ultimo_quinto, ultimo_quinto + quintos_de_biblia) );
        ultimo_quinto += quintos_de_biblia;

        Runnable cacho_2 = new StringOrdenator( biblia.substring(ultimo_quinto, ultimo_quinto + quintos_de_biblia) );
        ultimo_quinto += quintos_de_biblia;

        Runnable cacho_3 = new StringOrdenator( biblia.substring(ultimo_quinto, ultimo_quinto + quintos_de_biblia) );
        ultimo_quinto += quintos_de_biblia;

        Runnable cacho_4 = new StringOrdenator( biblia.substring(ultimo_quinto, ultimo_quinto + quintos_de_biblia) );
        ultimo_quinto += quintos_de_biblia;

        Runnable cacho_5 = new StringOrdenator( biblia.substring(ultimo_quinto, ultimo_quinto + quintos_de_biblia) );
        // ultimo_quinto += quintos_de_biblia;

        // Creamos el threadpool de 5 hilos
        ExecutorService pool = Executors.newFixedThreadPool(5);

        // Utilizamos todos los 5 hilos
        pool.execute(cacho_1);
        pool.execute(cacho_2);
        pool.execute(cacho_3);
        pool.execute(cacho_4);
        pool.execute(cacho_5);

        // Terminamos el Deadpool xd
        pool.shutdown();

        // System.out.println(biblia);

        // for ( char c : chars.keySet() ){
        //     String desc = "";
        //     switch (c){
        //         case 0x000a:
        //             desc = " (Salto de linea)";
        //             break;
        //         case 0x2014:
        //             desc = " (Guión largo)";
        //             break;
        //         case 0x201c:
        //             desc = " (Doble comilla izquierda)";
        //             break;
        //         case 0x201d:
        //             desc = " (Doble comilla derecha)";
        //             break;
        //         case 0x0020:
        //             desc = " (Espacio)";
        //             break;
        //         default:
        //             desc = "";
        //     }
        //     System.out.printf("Llave: %c%s, Valor: %d \n", c, desc,chars.get(c));
        // }

    }

}