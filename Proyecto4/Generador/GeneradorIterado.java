/*
*   Después de leer en la siguiente página ( https://www.geeksforgeeks.org/iterators-in-java/ )
*   el subtema correspondiente al cursor Iterator de Java, elabore un programa que almacene n 
*   CURPs en un ArrayList e imprima todos sus elementos. Posteriormente debe usar al cursor
*   Iterator para eliminar de la lista a todas las CURPs cuyo sexo sea masculino o femenino,
*   según se especifique por el usuario, e imprima al final el arreglo filtrado. Tanto el 
*   numero n como el sexo se deben especificar como parámetros del programa.
*/
import java.util.*;

public class P13{
	public static void main(String[] args){                   
		ArrayList<String> lista = new ArrayList<String>();
		int n = Integer.parseInt(args[0]);
		
		System.out.println("\t*** Lista ***");
		for (int i = 0; i < n ; i++) {
			lista.add(getCURP());
			System.out.println("\t"+lista.get(i));
		}
    }
    // Función para generar una CURP aleatoria
    static String getCURP(){
        String Letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Numero = "0123456789";
        String Sexo = "HM";
        String Entidad[] = {"AS", "BC", "BS", "CC", "CS", "CH", "CL", "CM", "DF", "DG", "GT", "GR", "HG", "JC", "MC", "MN", "MS", "NT", "NL", "OC", "PL", "QT", "QR", "SP", "SL", "SR", "TC", "TL", "TS", "VZ", "YN", "ZS"};
        int indice;
        StringBuilder sb = new StringBuilder(18);

        for (int i = 1; i < 5; i++) {
            indice = (int) (Letra.length()* Math.random());
            sb.append(Letra.charAt(indice));        
        }
        for (int i = 5; i < 11; i++) {indice = (int) (Numero.length()* Math.random());
            sb.append(Numero.charAt(indice));        
        }

        indice = (int) (Sexo.length()* Math.random());
        sb.append(Sexo.charAt(indice));        
        sb.append(Entidad[(int)(Math.random()*32)]);

        for (int i = 14; i < 17; i++) {
            indice = (int) (Letra.length()* Math.random());
            sb.append(Letra.charAt(indice));        
        }

        for (int i = 17; i < 19; i++) {
            indice = (int) (Numero.length()* Math.random());
            sb.append(Numero.charAt(indice));        
        }

        return sb.toString();
    }           
}