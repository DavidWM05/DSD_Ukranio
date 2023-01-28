import java.io.*;
import java.util.*;
 
public class programa1{
    public static void main(String[] args) throws Exception
    {
        FileReader fr = new FileReader("El_viejo_y_el_mar.txt");
        Map<String, Integer> hm = new HashMap <String, Integer>();
 
        int i;
        int n=0;
        String m;
        while ((i = fr.read()) != -1){
            m = String.valueOf((char)i);
            hm.put(m,hm.getOrDefault(m,0)+1);
        }
        
        for(Map.Entry<String,Integer> e : hm.entrySet()){
        System.out.println(" - "+e.getKey()+" "+e.getValue());
    }
    }
}