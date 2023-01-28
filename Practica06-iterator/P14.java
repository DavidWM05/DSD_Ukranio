/*
*   14. Usando el cursor Iterator elabore un programa que vaya generando CURPs y las
*   vaya imprimiendo y almacenando en un ArrayList en orden ascendente respecto a los
*   primeros cuatro caracteres alfabéticos. Cada que se genera una nueva CURP se debe
*   insertar en el lugar correspondiente de la lista, sin necesidad de usar algún 
*   método de ordenamiento. Al igual que el ejercicio anterior, el número de CURPs se
*   debe introducir en la línea de comandos.
*/
import java.util.*;

public class P14{
	public static void main(String[] args){                   
        //Variables
		ArrayList<String> lista = new ArrayList<String>();
		int n = Integer.parseInt(args[0]);
        Iterator<String> itr;

		System.out.println("\t   *** Lista Desordenada ***");
		for (int i = 0; i < n ; i++) {
            if(i==0){                
                String elemento= getCURP();
                lista.add(elemento);
                System.out.println("\t["+i+"] "+elemento);
            }else{                          //ELEMENTOS POSTERIORES CON COMPARACION
                //Variables locales
                String curp = getCURP(),
                       subA = curp.substring(0,4),  //Subcadena de curp
                       subB="",elemento="";
                itr = lista.iterator();
                int j = 0;
                //Impresion
                System.out.println("\t["+i+"] "+curp);
                //Recorrido
                while(itr.hasNext()){
                    elemento = itr.next();
                    subB = elemento.substring(0,4); //Subcadena de elemento                    
                    int comparacion = subA.compareTo(subB);
                    if(comparacion < 0 ){ //menor -1
                            lista.add(j,curp);
                            break;
                    } else if(comparacion == 0){//igual 0
                            lista.add(j,curp);
                            break;
                    }  else if(comparacion > 0){//mayor 1
                            if(itr.hasNext()!=false){j++;
                            }else{lista.add(curp); break;}
                    }//Fin if mayor 1  
                }//Fin while
            }//Fin else
		}//Fin for
        //Impresion de lista ordenada
        System.out.println("\t   *** Lista Desordenada ***");
        for (int i = 0; i < lista.size() ; i++) {
			System.out.println("\t["+(i+1)+"] "+lista.get(i));
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