/*
*	Proyecto #1
*	Nombre: Peralta Gonzalez Luis David
*	Grupo: 4CM13
*/

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Corrector{
	private File folder;
	private List<String> diccionario;

	public Corrector(String path){
		folder = new File(path);
		diccionario = new ArrayList<>();
	}
	public void buscarPalabra(){
		//Variables
		Scanner entrada = new Scanner(System.in);
		String palabra = "";
		List <String>cadena = new ArrayList<>();
		//Menu
		System.out.println("\n\n\t\t\tDICCIONARIO SIMPLE - Palabras guardadas: "+diccionario.size());
		System.out.println("\n\tImportante:\n"+"\t1. no se puede ingresar caracteres especiales como \u00e1, \u00e9, \u00ed, \u00f3, \u00fa, \u00f1 o derivados."+
								"\n\t2. Sustituir el caracter especial por su semejante, ejemplo: \u00e1 = a o \u00f1 = n."+
								"\n\t3. Teclear 2 veces [enter] o [intro], la primera para ingresar los datos y la segunda para limpiar el buffer."+
								"\n\t4. Para salir ingresa [0].\n");
		//Solicitud de datos
		System.out.printf("\tcadena: ");
		palabra = entrada.nextLine();
		//Bucle de menu
		while(!palabra.equals("0")){
			//Proceso para separar palabras de la cadena
			String []palabras = palabra.split(" ");	//Separamos palabras de la cadena
			for(int i=0;i<palabras.length;i++)		//Guardamos las palabras separadas en una lista
				cadena.add(palabras[i]);
			//Proceso de busqueda
			for (int i=0;i<cadena.size();i++ ) {
				palabra = cadena.get(i);
				if(diccionario.contains(palabra)){
					System.out.println("\t-> La palabra ["+palabra+"] esta escrita correctamente.");
				}else{
					System.out.println("\t-> La palabra ["+palabra+"] es incorrecta, no existe en este diccionario.");
				}
			}		
			System.out.printf("\t-------------------------------------------------------------------------\n\tcadena: ");
			palabra = entrada.nextLine();
			cadena.clear();
		}
		System.out.println("\n\t[Programa terminado]");
	}
	public void buscarArchivosEnFolder(){
		try{
			System.out.printf("\n\t[Cargando palabras] ");
			for (File file : folder.listFiles()) {
				if(!file.isDirectory()){
					guardarPalabras(file.getName());
				}
				//else 		//busca en subCarpetas			
				//	buscarArchivosEnFolder();
				System.out.printf("*");
			}						
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	private void guardarPalabras(String nombre){
		//Variables
		File archivo = null;     	
     	BufferedReader br = null;
     	String linea;    	

     	try{
     		//Apertura del fichero y creacion de BufferedReader
			archivo = new File ("LIBROS_TXT/"+nombre);			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"utf-8"));
			//Lectura del fichero
			while((linea = br.readLine()) != null){				
				String[] palabras = linea.split(" ");		//separa las palabras cuando encuentre un 'espacio' y las guarda en un arreglo
				String auxiliar,limpia="";			
				for(int i=0;i<palabras.length;i++){										
					auxiliar = palabras[i];					//guardamos la palabra i en auxiliar
					//Filtrado de caracteres
					if(auxiliar.length() > 1){				//Se descartan string de tamaño 1						
						int tam = auxiliar.length();		//numero de caracteres en la cadena
						auxiliar = auxiliar.toLowerCase();	//Convertimos la cadena a minusculas
						//Recorrido de caracteres
						for(int j=0;j < tam;j++){
							//condicionales
							//condicional1 busca que el caracter se encuentre entre a - z
							//condicional2 busca que el caracter se encuentre entre A - Z
							//condicional3 busca que el caracter sea \u00e1, \u00e9, \u00ed, \u00f3, \u00fa
							//condicional4 busca que el caracter sea \u00c1, \u00c9, \u00cd, \u00d3, \u00da
							//condicional5 busca que el caracter sea ñ O Ñ
							char caracter = auxiliar.charAt(j);
							boolean condicional1 = caracter>='a' && caracter<='z',
					     			condicional2 = caracter>='A' && caracter<='Z',
					     			condicional3 = caracter=='\u00e1' || caracter=='\u00e9' || caracter=='\u00ed' || caracter=='\u00f3' || caracter=='\u00fa',
					     			condicional4 = caracter=='\u00c1' || caracter=='\u00c9' || caracter=='\u00cd' || caracter=='\u00d3' || caracter=='\u00da',
					     			condicional5 = caracter=='\u00f1' || caracter=='\u00d1';							
					     	if(condicional1 || condicional3	|| condicional5){
								//Cambio de caracteres especiales por sus aproximados
								switch(caracter){
									case '\u00e1':	caracter = 'a';	// á
									break;
									case '\u00e9':	caracter = 'e';	// é
									break;
									case '\u00ed':	caracter = 'i';	// í
									break;
									case '\u00f3':	caracter = 'o';	//ó
									break;
									case '\u00fa':	caracter = 'u';	//ú
									break;
									case '\u00f1':	caracter = 'n';	//ñ
									break;
								}
								limpia = limpia + caracter;	
							}
							//Ingreso a lista 'diccionario'
							if((j+1) == tam && limpia.length()>1 && !limpia.equals("\n") && !diccionario.contains(limpia))
								diccionario.add(limpia);
						}
						limpia="";	//Limpiamos la variable de cadena limpia para utilizarla de nuevo
					}					
				}
			}			
     	}catch(Exception e2){
     		e2.printStackTrace();
     	}
	}
}