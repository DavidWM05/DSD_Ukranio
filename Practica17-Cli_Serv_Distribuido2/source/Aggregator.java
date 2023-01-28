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

    public List<byte[]> sendTasksToWorkers(List<String> workersAddresses, List<byte[]> tasks) {
        //----------|Variables Locales|----------
        int tamWorkers = workersAddresses.size();
        CompletableFuture<byte[]>[] futures = new CompletableFuture[tamWorkers];

        //----------|Envio de primera(s) solicitud(es)|----------
        for (int i = 0; i < tamWorkers; i++) {
            String workerAddress = workersAddresses.get(i);
            byte[] requestPayload = tasks.get(i);

            futures[i] = webClient.sendTask(workerAddress, requestPayload);
        }

        //----------|Evaluacion de Termino|----------
        boolean bandera = true;
        while(bandera){
            for(int j = 0; j < tamWorkers; j++){
                if (true == futures[j].isDone())
                    bandera = false;
            }
        }

        //----------|Resultados futures[]|----------
        List<byte[]> results = new ArrayList();
        for (int i = 0; i < tasks.size(); i++) {
            results.add(futures[i].join());
        }

        return results;
    }
}
