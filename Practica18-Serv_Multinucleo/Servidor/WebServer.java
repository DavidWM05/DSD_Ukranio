//Bibliotecas
import java.math.BigInteger;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;
import java.util.concurrent.*;
import java.util.*;
import java.io.*;

public class WebServer {
    //--------------------|Variables de Instancia|--------------
    private static final String CALCULAR_ENDPOINT = "/calcular";//End point status
    private final int port;     //Puerto
    private HttpServer server;  //Servidor basico HTTP
    
    //====================|Metodo Principal|====================
    public static void main(String[] args) {
        //----------|Variables Locales|----------
        int serverPort = 8080;  //Puerto Default del servidor
        if (args.length == 1) { //Se pasa por linea de comandos
            serverPort = Integer.parseInt(args[0]);
        }

        WebServer webServer = new WebServer(serverPort);  //Objeto webServer
        //Inicializa la configuracion del servidor
        webServer.startServer();
        //Imprime puerto en el cual esta escuchando el servidor
        System.out.println("Servidor escuchando en el puerto " + serverPort);
    }

    //====================|Contructor|====================
    public WebServer(int port) {
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
        HttpContext calcularContext = server.createContext(CALCULAR_ENDPOINT);
        calcularContext.setHandler(this::handleCalcularCheckRequest);
        
        //Creacion de hilos
        server.setExecutor(Executors.newFixedThreadPool(8));
        server.start();
    }

    //====================|Calcular|====================
    private void handleCalcularCheckRequest(HttpExchange exchange) throws IOException {
        //----------|Metodo|----------
        if (!exchange.getRequestMethod().equalsIgnoreCase("post")) {
            exchange.close();
            return;
        }

        //----------|Variables Locales|----------
        byte[] requestBytes = exchange.getRequestBody().readAllBytes();
        String responseMessage;
        String numero = new String(requestBytes);

        if(esPrimo(Integer.parseInt(numero)))
            responseMessage = "primo=\t\tResultado\n\n\tEl numero ["+numero+"] es primo";
        else
            responseMessage = "primo=\t\tResultado\n\n\tEl numero ["+numero+"] no es primo";

        sendResponse(responseMessage.getBytes(),exchange);
    }

    //====================|Primo|====================
    private boolean esPrimo(int numero){
        boolean primo = true;
        
        for (int i = 2; i < (numero - 1); i++) {
            if((numero % i) == 0){
                primo = false;
                break;
            }
        }

        return primo;
    }

    //====================|Respuesta|====================
    private void sendResponse(byte[] responseBytes, HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, responseBytes.length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(responseBytes);
        outputStream.flush();
        outputStream.close();
        exchange.close();
    }
}