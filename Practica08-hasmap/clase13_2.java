/*
*   Utilice un ArrayList y la interfaz Comparator para imprimir los caracteres
*   junto con su número de ocurrencias ordenadas de mayor ocurrencia a menor 
*   ocurrencia.
*/
import java.io.*;
import java.util.*;
 
public class clase13_2{
    public static void main(String[] args) throws Exception{
        //Variables y objetos
        FileReader file = new FileReader("El_viejo_y_el_mar.txt");
        Map<String, Integer> map = new HashMap <String, Integer>();
        LinkedHashMap<String, Integer> stdmap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
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
            list.add(e.getValue());
        }
        //Proceso de ordenamiento descendente de los valores
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer obj1,Integer obj2){
                return obj2.compareTo(obj1);
            }
        });
        //Proceso para guardar los valores ordenados
        for (Integer aux: list) {
            for(Map.Entry<String,Integer> e: map.entrySet()){
                if(e.getValue() == aux){
                    stdmap.put(e.getKey(),aux);
                }
            }
        }
        //Impresion de datos
        Set s = stdmap.entrySet();
        Iterator ite = s.iterator();
        System.out.println("\n\t   HashMap Ordenado\n");

        while(ite.hasNext()){
            Map.Entry mp = (Map.Entry)ite.next();
            String key = (String)mp.getKey();
            Integer value = (Integer)mp.getValue();
            System.out.println("\t| Key : "+key+" | Value : "+value);
        }
    }
}