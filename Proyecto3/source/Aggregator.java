/*
 *  Materia:    Desarrollo de Sistemas Distribuidos
 *  Profesor:   Ukranio Coronilla Contreras
 *  Alumno:     Peralta Gonzalez Luis David
 *  Grupo:      4CM13
 *  Proyecto:    #3
 */

import networking.WebClient;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class Aggregator {
    //----------|Variables de instancia|----------
    private WebClient webClient;

    //==========|Constructor|==========
    public Aggregator() {
        this.webClient = new WebClient();
    }

    //==========|senTasksToWorkers|==========
    public void sendTasksToWorkers(List<String> workersAddresses, List<String> tasks) {
        //Variables locales
        List<String> results = new ArrayList();     //Lista de resultados
        int tamWorkers = workersAddresses.size();   //tamanio de lista trabajadores
        int tamTasks = tasks.size();                //tamanio de lista tasks
        CompletableFuture<String>[] futures = new CompletableFuture[tamWorkers];

        /*
        *   Se envian las primeras tareas a los servidores.
        *   La variable i sera el control-indice de solicitudes task.
        */
        int i = 0;//Indice de primera solicitud
        try{
            //Se cargan las primeras 3 tareas
            for (; i < tamWorkers; i++) {
                String workerAddress = workersAddresses.get(i); //Direccion de trabajador
                String task = tasks.get(i);                     //Solicitud i

                byte[] requestPayload = task.getBytes();
                futures[i] = webClient.sendTask(workerAddress, requestPayload);
                System.out.println("\t[Nueva Busqueda] Servidor: "+(i+1)+" -> : "+task);
            }
            System.out.println("\n\t--------------------\n");
        }catch (Exception e) {
            System.out.printf("Error: Enviar Socilitudes");
            e.printStackTrace();
        }

        /* 
        * Evalúa continuamente si uno de los trabajadores ha terminado para enviar la siguiente
        * tarea hasta que no quede ninguna.
        */
        try{            
            boolean [] banderas = new boolean[tamWorkers];//Bandera por cada trabajador
            boolean condicion = true;//Condicion para terminar while
            for(int j = 0; j < tamWorkers;j++ )
                banderas[j] = true;

            while(condicion){
                for(int j = 0; j < tamWorkers; j++){
                    boolean isdone = futures[j].isDone();//Condicion                  
                    if (true == isdone && i < tamTasks){   //Trabajador disponible | quedan tareas
                        results.add(futures[j].join());
                        String workerAddress = workersAddresses.get(j);
                        String task = tasks.get(i);//tercera tarea                        

                        System.out.println("\t[Busqueda Terminada] Servidor: "+(j+1)+" -> : "+futures[j].join());
                        byte[] requestPayload = task.getBytes();//Se asigna nueva tarea a servidor libre
                        futures[j] = webClient.sendTask(workerAddress, requestPayload);                        
                        System.out.println("\t[Nueva Busqueda] Servidor: "+(j+1)+" -> : "+task+"\n");

                        i++;//incrementamos a la siguiente tarea
                    } else if (false == isdone && i < tamTasks){//Trabajador no disponible | quedan tareas
                        continue;
                    } else if (true == isdone && i >= tamTasks){//Trabajador disponible | no quedan  tareas
                        String auxiliar = futures[j].join();
                        if(results.contains(auxiliar)){
                            banderas[j] = false;
                        }else{
                            System.out.println("\t[Busqueda Terminada] Servidor: "+(j+1)+" -> : "+futures[j].join());
                            results.add(auxiliar);
                            banderas[j] = false;
                        }
                    } else if(false == isdone && i>=tamTasks){//Trabajador no disponible | no quedan tareas
                        banderas[j] = true;
                    }
                    //Verificacion de que todos los trabajadores terminaron y no quedan tareas
                    for(int k = 0; k < tamWorkers; k++){
                        if(banderas[k] == false)
                            condicion = false;
                        else{
                            condicion = true;
                            break;
                        }
                    }
                }//Fin for workers
            }//Fin while condicion
        }catch (Exception e2) {
            System.out.printf("Error: isDone() ");
            e2.printStackTrace();
        }
    }
}
