import java.io.*;
import java.util.*;
 
public class TestHashMap{
    public static void main(String[] args) throws Exception{        
        //Variables y objetos
        FileReader file = new FileReader("BIBLIA_COMPLETA.txt");
        Map<String, Integer> map = new HashMap <String, Integer>();        
        ArrayList<String> list = new ArrayList<>();
        //Proceso de lectura caracter x caracter
        int i;      //Auxiliar de lectura
        String m;   //Auxiliar de key
        while ((i = file.read()) != -1){
            m = String.valueOf((char)i);
            if(!m.equals("\n")) //Ignoramos los saltos de linea \n
                map.put(m,map.getOrDefault(m,0)+1);
        }
        //Ingresamos los valores en la lista
        for(Map.Entry<String,Integer> e : map.entrySet()){
            list.add(e.getKey());
        }
        //Impresion de datos ordenados
        System.out.println(list);
    }
}