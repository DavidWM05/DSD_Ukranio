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

import networking.WebClient;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class Aggregator {
    private WebClient webClient;

    public Aggregator() {
        this.webClient = new WebClient();
    }

    public List<String> sendTasksToWorkers(List<String> workersAddresses, List<String> tasks) {
        //Variables locales
        int tamWorkers = workersAddresses.size();   //tamanio de lista trabajadores
        int tamTasks = tasks.size();                //tamanio de lista tasks
        CompletableFuture<String>[] futures = new CompletableFuture[tamTasks]; //agregamos tercera tarea
        StringBuilder impresion = new StringBuilder("");
        /*
        * Se envian la primera tarea al servidor
        */
        int i;
        for (i = 0; i < tamWorkers; i++) {
            String workerAddress = workersAddresses.get(i); //Direccion de trabajador-servidor
            String task = tasks.get(i);                     //Solicitud i

            byte[] requestPayload = task.getBytes();
            futures[i] = webClient.sendTask(workerAddress, requestPayload);
            impresion.append("\tServidor: "+workerAddress+" -> Tarea: "+task+"\n");
        }

        /* 
        * Evalúa continuamente si el servidor ha terminado para enviar la siguiente
        * tarea.
        */
        boolean bandera = true;
        while(bandera){
            for(int j = 0; j < tamWorkers; j++){
                if (true == futures[j].isDone()){   //Solicitudes que se estan atendiendo
                    String workerAddress = workersAddresses.get(j);
                    String task = tasks.get(i);//tarea siguiente

                    byte[] requestPayload = task.getBytes();//Se asigna nueva tarea a servidor libre
                    futures[i] = webClient.sendTask(workerAddress, requestPayload);
                    impresion.append("\tPrimer Servidor en Terminar: "+workerAddress+". Se le asigna -> Tarea: "+task+"\n");
                    i++;
                    if(i==tamTasks){
                        bandera = false;
                        break;
                    }
                }
            }
        }

        System.out.println(impresion);

        List<String> results = new ArrayList();
        for (i = 0; i < tamTasks; i++) {
            results.add(futures[i].join());
        }

        return results;
    }
}
