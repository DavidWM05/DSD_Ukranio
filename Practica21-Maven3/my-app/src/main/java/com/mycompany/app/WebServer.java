/*
 *  MIT License
 *
 *  Copyright (c) 2019 Michael Pogrebinsky - Distributed Systems & Cloud Computing with Java
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package com.mycompany.app;

import networking.Aggregator;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;  
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.List;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;   
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class WebServer {
    //==========|Variables Globales|==========
    //----------|Endpoints|----------
    private static final String STATUS_ENDPOINT = "/status";
    private static final String HOME_PAGE_ENDPOINT = "/";
    private static final String HOME_PAGE_UI_ASSETS_BASE_DIR = "/ui_assets/";
    private static final String ENDPOINT_PROCESS = "/procesar_datos";
    //----------|Servidores|----------
    private static final String WORKER_ADDRESS_1 = "http://localhost:8081/task";
    private static final String WORKER_ADDRESS_2 = "http://localhost:8082/task";
    private static final String WORKER_ADDRESS_3 = "http://localhost:8083/task";
    //----------|Configuracion y auxiliares|----------
    private final int port; 
    private HttpServer server; 
    private final ObjectMapper objectMapper;

    //==========|Constructor|==========
    public WebServer(int port) {
        this.port = port;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    //==========|Inicio del Servidor|==========
    public void startServer() {
        try {
            this.server = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        HttpContext statusContext = server.createContext(STATUS_ENDPOINT); 
        HttpContext taskContext = server.createContext(ENDPOINT_PROCESS);
        HttpContext homePageContext = server.createContext(HOME_PAGE_ENDPOINT);

        statusContext.setHandler(this::handleStatusCheckRequest);
        taskContext.setHandler(this::handleTaskRequest);
        homePageContext.setHandler(this::handleRequestForAsset);

        server.setExecutor(Executors.newFixedThreadPool(8));
        server.start();
    }

    //==========|HomePage|==========
    private void handleRequestForAsset(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("get")) {
            exchange.close();
            return;
        }

        byte[] response;

        String asset = exchange.getRequestURI().getPath();

        if (asset.equals(HOME_PAGE_ENDPOINT)) { 
            response = readUiAsset(HOME_PAGE_UI_ASSETS_BASE_DIR + "index.html");
        } else {
            response = readUiAsset(asset); 
        }
        addContentType(asset, exchange);
        sendResponse(response, exchange);
    }

    private byte[] readUiAsset(String asset) throws IOException {
        System.out.println("\t[asset]"+asset);

        InputStream assetStream = getClass().getResourceAsStream(asset);//Se obtienen bytes del path

        if (assetStream == null) {
            return new byte[]{};
        }
        return assetStream.readAllBytes(); 
    }

    private static void addContentType(String asset, HttpExchange exchange) {

        String contentType = "text/html";  
        if (asset.endsWith("js")) {
            contentType = "text/javascript";
        } else if (asset.endsWith("css")) {
            contentType = "text/css";
        } else if (asset.endsWith("ico")){
            contentType = "image/ico";
        }
        exchange.getResponseHeaders().add("Content-Type", contentType);
    }

    //==========|Procesar Datos|==========
    private void handleTaskRequest(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("post")) { 
            exchange.close();
            return;
        }

        try {
            FrontendSearchRequest frontendSearchRequest = objectMapper.readValue(exchange.getRequestBody().readAllBytes(), FrontendSearchRequest.class);
            String numero,task1,task2,task3,resultado;
            Aggregator aggregator = new Aggregator();

            //----------------------------------------------------- agregar condicional si es menor a 10?
            numero = frontendSearchRequest.getSearchQuery();

            int x = Integer.parseInt(numero);
            int fraccion = x/3;

            task1 = "1,"+String.valueOf(fraccion);
            task2 = String.valueOf(fraccion+1) + "," + String.valueOf(fraccion*2);
            task3 = String.valueOf((fraccion*2)+1) + "," + String.valueOf(x);

            System.out.println("\t============|Factorial de "+numero+"|============");

            System.out.println("\tLos intervalos son:\n"+
                               "\t\t Intervalo 1: 1," + fraccion+
                               "\n\t\t Intervalo 2: "+(fraccion+1)+"," + (fraccion*2)+
                               "\n\t\t Intervalo 3: "+((fraccion*2)+1)+"," + x );

            List<String> results = aggregator.sendTasksToWorkers(Arrays.asList(WORKER_ADDRESS_1, WORKER_ADDRESS_2,WORKER_ADDRESS_3),
                    Arrays.asList(task1, task2, task3));

            BigInteger factorial = BigInteger.ONE;
            for (String result : results) {
                System.out.println("\t[Respuesta] "+result);
                factorial = factorial.multiply(new BigInteger(result)); //Se multiplican los factoriales
            }

            resultado = factorial.toString();
            System.out.println("\n\t[Resultado] " + resultado);

            //-----------------------------------------------------

            StringTokenizer st = new StringTokenizer(resultado);
            FrontendSearchResponse frontendSearchResponse = new FrontendSearchResponse(resultado, st.countTokens());

            byte[] responseBytes = objectMapper.writeValueAsBytes(frontendSearchResponse);

            

            sendResponse(responseBytes, exchange);

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    //==========|Estado del Servidor|==========
    private void handleStatusCheckRequest(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("get")) {
            exchange.close();
            return;
        }

        String responseMessage = "El servidor está vivo\n";
        sendResponse(responseMessage.getBytes(), exchange);
    }

    //==========|Respuesta|==========
    private void sendResponse(byte[] responseBytes, HttpExchange exchange) throws IOException {
        System.out.println("\t[Bytes] Respuesta de "+responseBytes.length+" bytes.\n");
        exchange.sendResponseHeaders(200, responseBytes.length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(responseBytes);
        outputStream.flush();
        outputStream.close();        
    }
}