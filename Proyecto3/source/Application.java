/*
 *  Materia:    Desarrollo de Sistemas Distribuidos
 *  Profesor:   Ukranio Coronilla Contreras
 *  Alumno:     Peralta Gonzalez Luis David
 *  Grupo:      4CM13
 *  Proyecto:    #3
 */
import java.util.*;
import java.io.*;

public class Application {
    //----------|Variables de instancia|----------
    private static final String WORKER_ADDRESS_1 = "http://localhost:8081/search";  //Servidor 1
    private static final String WORKER_ADDRESS_2 = "http://localhost:8082/search";  //Servidor 2
    private static final String WORKER_ADDRESS_3 = "http://localhost:8083/search";  //Servidor 3

    public static void main(String[] args) {
        //----------|Variables Locales|----------
        Aggregator aggregator = new Aggregator();   //Clase aggregator
        List<String> task = new ArrayList<>();      //Solicitudes
        String cadenas[] = {"AAA","BBB","CCC","DDD","EEE",
                            "FFF","GGG","HHH","III","JJJ",
                            "KKK","LLL","MMM","NNN","OOO",
                            "PPP","QQQ","RRR","SSS","TTT",
                            "UUU","VVV","WWW","XXX","YYY",
                            "ZZZ"};                         //Cadenas de busqueda
        /*
        *   Generacion de Tokens Random mediante
        *   Random()
        */
        int auxiliar=(17576000 - 1757600)+1;//((Maximo - Minimo) +1)
        for (int i=0; i < 26; i++) {      
            Random random = new Random();
            int nTokens = random.nextInt(auxiliar)+1757600;
            task.add(String.valueOf(nTokens)+","+cadenas[i]);
        }

        /*
        *   Implesion de cadenas de busqueda y sus respectivos tokens a generar.
        */
        System.out.println("\t\tDesarrollo de Sistemas Distribuidos - Proyecto 3"+
                           "\n\n\t======|Busquedas|======");
        for (String socilitud : task)
            System.out.println("\t "+socilitud);

        /*
        *   Envio de la lista de trabajadores y solicitudes a aggregator.
        */
        System.out.println("\n\t======|Ocurrencias|======\n");
        aggregator.sendTasksToWorkers(Arrays.asList(WORKER_ADDRESS_1,WORKER_ADDRESS_2, WORKER_ADDRESS_3),task);
    }
}
