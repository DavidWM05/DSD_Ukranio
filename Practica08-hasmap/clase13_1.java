/*
*	Después de leer el subtema HashMap sobre la interfaz Map en Java disponible en:
*	https://www.geeksforgeeks.org/map-interface-java-examples/?ref=gcse
*
*	Lea con su programa el archivo de texto "El_viejo_y_el_mar.txt" 
*	(véase https://www.geeksforgeeks.org/different-ways-reading-text-file-java/?ref=gcse)
*	disponible en la pestaña “Archivos”, y utilice un Map para almacenar cada uno de los
*	caracteres distintos junto con su número total de apariciones en el texto. Imprima al
*	final el numero de caracteres distintos encontrados y el Map para visualizar los 
*	caracteres distintos encontrados en el texto y sus respectivas ocurrencias.
*/
import java.io.*;
import java.util.*;

public class clase13_1{
	public static void main(String[] args) throws Exception {
		//Variables
		File file = new File("ejemplo.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		Map<String, Integer> hm = new HashMap <String, Integer>();
		String st;

		try{
			while((st = br.readLine()) !=  null){
				//System.out.println(st);
				hm.put(st,hm.getOrDefault(st,0)+1);
			}

			for(Map.Entry<String,Integer> e : hm.entrySet()){
				System.out.println(" - "+e.getKey()+" "+e.getValue());
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}