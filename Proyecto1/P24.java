/*
*   Leer un archivo de texto que contiene un número entero por cada línea e
*   indicar cuál es el número mayor dentro del archivo y el número de renglón
*   en que se encuentra.
*/
import java.io.*;
import java.util.*; 

public class P24{     
    public static void main(String[] args) throws IOException {
        //Variables
        String cadena,archivo="numero.txt";
        ArrayList<String> lista = new ArrayList<String>();
        FileReader f = new FileReader(archivo); 
        BufferedReader b = new BufferedReader(f);
        int a=0,bb=0,max=0,linea=0;
        //Proceso
        try{
            //Lectura de archivo
            int i = 0;
            while((cadena = b.readLine())!=null) { 
                System.out.println(cadena);
                lista.add(cadena);
            }
            b.close();
            //Creacion de vector
            int n = lista.size();
            int vec[] = new int[n];

            for(i=0;i<n;i++)
                vec[i]=Integer.parseInt(lista.get(i));
            //proceso mayor
            for(i=0;i<n;i++){
                if(i==0){
                    a = vec[i];
                    linea=i;
                    continue;
                }
                bb = vec[i];
                if(a>bb)
                    continue;
                else if(a<bb){
                    a = bb;
                    linea=i+1;
                }
            }
            max = a;
            System.out.println("\n El numero "+max+" linea "+linea+" es el mayor");
        }catch(Exception e) {
            System.out.println("Error el archivo");
        }
    }
}