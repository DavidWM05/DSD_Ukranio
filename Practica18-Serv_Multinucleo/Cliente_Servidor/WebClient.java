/*
 *  Materia:    Desarrollo de Sistemas Distribuidos
 *  Profesor:   Ukranio Coronilla Contreras
 *  Alumno:     Peralta Gonzalez Luis David
 *  Grupo:      4CM13
 *  Proyecto:    #4
 */

//package networking;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class WebClient {
    private HttpClient client;

    public WebClient() {
        this.client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
    }

    public CompletableFuture<String> sendTask(String url, byte[] requestPayload) {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofByteArray(requestPayload))
                .uri(URI.create(url))
                .header("X-debug","false")
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(respuesta->{return respuesta.headers().toString()+respuesta.body().toString();});
    }
}
