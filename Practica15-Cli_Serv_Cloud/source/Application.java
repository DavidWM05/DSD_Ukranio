import java.util.Arrays;
import java.util.List;

public class Application {
    private static final String WORKER_ADDRESS_1 = "http://34.125.129.126:80/search";
    private static final String WORKER_ADDRESS_2 = "http://34.125.32.114:80/search";
    private static final String WORKER_ADDRESS_3 = "http://34.125.14.235:80/search";
    private static final String WORKER_ADDRESS_4 = "http://34.125.181.75:80/search";
    //private static final String WORKER_ADDRESS_1 = "http://localhost:8080/search";

    public static void main(String[] args) {
        Aggregator aggregator = new Aggregator();
        String task1 = "1757600,IPN";
        String task2 = "1757600,SAL";
        String task3 = "1757600,MAS";
        String task4 = "1757600,COM";

        List<String> results = aggregator.sendTasksToWorkers(Arrays.asList(
                WORKER_ADDRESS_1,WORKER_ADDRESS_2,WORKER_ADDRESS_3,WORKER_ADDRESS_4),
                Arrays.asList(task1, task2, task3,task4));

        for (String result : results) {
            System.out.println("\t"+result);
        }
    }
}
