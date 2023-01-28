import java.util.Arrays;
import java.util.List;

public class Application {
    //----------|Variables Globales|----------
    private static final String WORKER_ADDRESS_1 = "http://localhost:8081/task";

    //====================|Metodo Principal|====================
    public static void main(String[] args) {
        //----------|Variables Locales|----------
        Aggregator aggregator = new Aggregator();
        Demo object = new Demo(args[0],args[1]);

        //----------|Serializacion|----------
        System.out.println("\t Antes de serialize: " + object);
        byte[] serializado = SerializationUtils.serialize(object);

        //----------|Impresion del Objeto|----------
        System.out.println("\t Objeto antes de enviar: " + serializado);

        //----------|Envio de servidores y solicitudes|----------        
        List<String> results = aggregator.sendTasksToWorkers(Arrays.asList(WORKER_ADDRESS_1),Arrays.asList(serializado));

        //----------|Impresion de resultados|----------
        for (String result : results) {
            System.out.println(result);
        }
    }
}