/*
*Incorpore el código del ejercicio anterior al código disponible en Pool Threads de manera que la construcción
*y ordenamiento del map se realicen de manera distribuida entre las cinco tareas Runnable. Es decir que al final
*se imprimirán cinco mapas ordenados, donde cada mapa corresponde a una quinta parte del texto. Su programa debe
*leer primero en el hilo principal la totalidad del texto y guardarlo en un objeto String. También debe disponer
*de un método atómico que le permite a cada hilo trabajador leer un bloque correspondiente a una quinta parte
*del String. Tabule los tiempos de ejecución del programa usando un pool de 1, 2, 3, 4 y 5 threads.


Analice los tiempos obtenidos en los incisos a y b y saque una conclusión sobre lo que está sucediendo. Recomendaciones: Mientras se hace el procesamiento abra otra terminal y ejecute el comando htop. También pruebe a substituir el código de cada tarea por uno que haga uso exclusivamente del CPU.
*/
// Java program to illustrate
// ThreadPool
import java.text.*;
import java.util.*;
import java.io.*;
import java.util.concurrent.*;

// Task class to be executed (Step 1)
class Task implements Runnable{
	private String name;
	private String texto;	
	
	public Task(String name,String texto){
		this.name = name;
		this.texto = texto;
	}
	
	// Prints task name and sleeps for 1s
	// This Whole process is repeated 5 times
	public synchronized void run(){
		Map<String, Integer> map = new HashMap <String, Integer>();        
        ArrayList<String> list = new ArrayList<>();
        String m;   //Auxiliar de lectura
        //Proceso de lectura caracter x caracter        
        for (char c: texto.toCharArray()){
        	m = String.valueOf(c);
            if(!m.equals("\n")) //Ignoramos los saltos de linea \n
                map.put(m,map.getOrDefault(m,0)+1);
        }
        //Ingresamos los valores en la lista
        for(Map.Entry<String,Integer> e : map.entrySet()){
            list.add(e.getKey());
        }       
		System.out.println(name+" complete"+"\n"+list);		
	}
}

public class Test{	
	static final int MAX_T = 5;	//Maximo numero de hilos en thread pool
	static StringBuilder cadenota = new StringBuilder();
	static int tamanio,quinta;//Tamaño de cadenota | 5ta parte de cadenota

	public static void main(String[] args){
		//Lectura del archivo
		lectura();		
		// creates five tasks		
		Runnable r1 = new Task("task 1",cadenota.substring(0,quinta));
		Runnable r2 = new Task("task 2", cadenota.substring(quinta,quinta*2));
		Runnable r3 = new Task("task 3", cadenota.substring(quinta*2,quinta*3));
		Runnable r4 = new Task("task 4", cadenota.substring(quinta*3,quinta*4));
		Runnable r5 = new Task("task 5", cadenota.substring(quinta*4));
		// creates a thread pool with MAX_T no. of
		// threads as the fixed pool size(Step 2)
		ExecutorService pool = Executors.newFixedThreadPool(MAX_T);		
		// passes the Task objects to the pool to execute (Step 3)
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);		
		// pool shutdown ( Step 4)
		pool.shutdown();		
	}

	public static void lectura(){
        File archivo;
        BufferedReader br = null;
     	try{
     		//Apertura del fichero y creacion de BufferedReader
			archivo = new File ("BIBLIA_COMPLETA.txt");
			br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"utf-8"));
			//Lectura del fichero
			String linea;
			while((linea = br.readLine()) != null)
				cadenota.append(linea); 			
			tamanio = cadenota.length();
			quinta = tamanio/5;			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}