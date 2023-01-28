//Bibliotecas
import java.math.BigInteger;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;
import java.util.concurrent.*;
import java.util.*;
import java.io.*;

public class WebServer_Cliente {
    //--------------------|Variables de Instancia|--------------
    private static final String PRIMO_ENDPOINT = "/primo";//End point status
    private static String WORKER_ADDRESS_1 = "http://localhost:8081/calcular";
    private final int port;     //Puerto
    private HttpServer server;  //Servidor basico HTTP
    
    //--------------------|Metodo Principal|--------------------
    public static void main(String[] args) {
        //----------|Variables Locales|----------
        int serverPort = 8080;  //Puerto Default del servidor
        if (args.length == 1) { //Se pasa por linea de comandos
            serverPort = Integer.parseInt(args[0]);
        }

        WebServer_Cliente webServer_Cliente = new WebServer_Cliente(serverPort);  //Objeto webServer_Cliente
        //Inicializa la configuracion del servidor
        webServer_Cliente.startServer();
        //Imprime puerto en el cual esta escuchando el servidor
        System.out.println("Servidor escuchando en el puerto " + serverPort);
    }

    //====================|Contructor|====================
    public WebServer_Cliente(int port) {
        //Se inicializa con el puerto ingresado
        this.port = port;
    }

    //====================|Inicio sel servidor|====================
    public void startServer() {
        try {
            this.server = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (IOException e){
            e.printStackTrace();
            return;
        }
        //Contextos
        HttpContext primoContext = server.createContext(PRIMO_ENDPOINT);
        primoContext.setHandler(this::handlePrimoCheckRequest);
        
        //Creacion de hilos
        server.setExecutor(Executors.newFixedThreadPool(8));
        server.start();
    }

    //====================|Primo|====================
    private void handlePrimoCheckRequest(HttpExchange exchange) throws IOException {
        //----------|Metodo|----------
        if (!exchange.getRequestMethod().equalsIgnoreCase("get")) {
            exchange.close();
            return;
        }
        //----------|Variables Locales|----------
        String nick, responseMessage;
        String[] queries = exchange.getRequestURI().getQuery().split("&");
        String[] temp = queries[0].split("=");
        nick = temp[1];

        CompletableFuture<String> future;
        WebClient server = new WebClient();

        byte[] requestPayload = nick.getBytes();

        future = CompletableFuture.supplyAsync(() -> {
            CompletableFuture<String> auxiliar = server.sendTask(WORKER_ADDRESS_1,requestPayload);
            sleep(1500);
            
            return auxiliar.join();
        });

        responseMessage = future.join();
        int index = responseMessage.indexOf("primo=");
        sendResponse(responseMessage.substring(index+6).getBytes(), exchange);       
    }

    //====================|Sleep|====================
    public void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //--------------------|Respuesta|---------------------------
    private void sendResponse(byte[] responseBytes, HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, responseBytes.length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(responseBytes);
        outputStream.flush();
        outputStream.close();
        exchange.close();
    }
}