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
        List<String> results = new ArrayList();
        int tamWorkers = workersAddresses.size();   //tamanio de lista trabajadores
        int tamTasks = tasks.size();                //tamanio de lista tasks

        //-Objeto Futures con tamanio de las solicitudes
        CompletableFuture<String>[] futures = new CompletableFuture[tamWorkers];
        StringBuilder impresion = new StringBuilder("");
        /*
        *   Se envian las primeras tareas a los servidores.
        *   La variable i sera el control-indice de solicitudes task.
        */
        int i = 0;//Primera solicitud
        try{
            //Se cargan las primeras 3 tareas
            for (; i < tamWorkers; i++) {
                String workerAddress = workersAddresses.get(i); //Direccion de trabajador
                String task = tasks.get(i);                     //Solicitud i

                byte[] requestPayload = task.getBytes();
                futures[i] = webClient.sendTask(workerAddress, requestPayload);
                impresion.append("\t[Nueva Busqueda] Servidor: "+workerAddress+" -> : "+task+"\n");
            }
        }catch (Exception e) {
            System.out.printf("Error: Enviar Socilitudes");
            e.printStackTrace();
        }
        /* 
        * Evalúa continuamente si uno de los trabajadores ha terminado para enviar la siguiente
        * tarea.
        */
        try{
            boolean bandera = true; //Bandera que indica si aun hay tareas
            while(bandera){
                for(int j = 0; j < tamWorkers; j++){
                    boolean isdone = futures[j].isDone();//Condicion                   
                    if (true == isdone && i < tamTasks){   //Se pregunta si trabajador[j] termino
                        results.add(futures[j].join());
                        String workerAddress = workersAddresses.get(j);
                        String task = tasks.get(i);//tercera tarea                        

                        byte[] requestPayload = task.getBytes();//Se asigna nueva tarea a servidor libre
                        futures[j] = webClient.sendTask(workerAddress, requestPayload);
                        impresion.append("\t[Nueva Busqueda] Servidor: "+workerAddress+" -> : "+task+"\n");
                        i++;//incrementamos a la siguiente tarea                                                              
                    } else if (false == isdone && i < tamTasks){                        
                        continue;
                    } else {
                        bandera = false;
                        break;
                    }
                }//Fin for workers
            }
            /*
             *  Verificar que todos los trabajadores terminaron.
             *  para este caso son 3 trabajadores.
             */
            //boolean [] banderas = {true,true,true};
            boolean [] banderas = new boolean[tamWorkers];
            boolean condicion = true;
            for(int j = 0; j < tamWorkers;j++ )
                banderas[j] = true;

            while(condicion){
                for(int j = 0; j < tamWorkers; j++){
                    boolean isdone = futures[j].isDone();//Condicion
                    if (true == isdone){   //Se pregunta si trabajador[j] termino
                        String auxiliar = futures[j].join();                        
                        if(results.contains(auxiliar)){
                            banderas[j] = false;
                        }else{                            
                            results.add(auxiliar);
                            banderas[j] = false;
                        }
                    } else{
                        banderas[j] = true;
                    }
                }
                for(int k = 0; k < tamWorkers; k++){
                    if(banderas[k] == false)
                        condicion = false;
                    else{
                        condicion = true;
                        break;
                    }
                }
            }

        }catch (Exception e2) {
            System.out.printf("Error: isDone() ");
            e2.printStackTrace();
        }
        System.out.println("\n\t------|Asignacion de Tareas|------");
        System.out.println(impresion);

        return results;
    }
}
