import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.*;
import java.time.Duration;
//Hilos
import java.text.*;
import java.util.*;
import java.io.*;
import java.util.concurrent.*;

// Task class to be executed (Step 1) for Poool Threads
class Task implements Runnable{
    //Variables task
    private String name;
    private final HttpClient httpClient;
    
    public Task(String name){
        this.name = name;
        httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    }
    
    // Prints task name and sleeps for 1s
    // This Whole process is repeated 5 times
    public synchronized void run(){
        try{
            servidor();
        } catch(IOException | InterruptedException ie){
            ie.printStackTrace();
        }
        System.out.println("\t"+name+" complete");

    }

    public void servidor() throws IOException, InterruptedException{
        //Requerimiento

                //.uri(URI.create("http://172.20.10.2:8080/search"))


        HttpRequest request = HttpRequest.newBuilder()                
                .uri(URI.create("http://localhost:8080/search"))
                .setHeader("X-Debug", "true") // add request header                                
                .POST(BodyPublishers.ofString("17576000,IPN"))//Equivalente --data '17515,IPN'
                .build();
              
        //Respuesta
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print response headers
        HttpHeaders headers = response.headers();
        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());
    }
}

public class ClienteHttp {
    //Variables Pool
    static final int MAX_T = 3; //Maximo numero de hilos en thread pool    

    public static void main(String[] args) throws IOException, InterruptedException {
        
        int m = Integer.parseInt(args[0]);      //Tareas
        int max_t = Integer.parseInt(args[1]);  //Tharead

        //ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        ExecutorService pool = Executors.newFixedThreadPool(max_t);
        for(int i = 0; i < m; i++){
            Runnable r = new Task("task "+String.valueOf(i));
            pool.execute(r);
        }
        pool.shutdown();
    }
}