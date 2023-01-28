/*
*	Proyecto #2 parte 2
*	Nombre: Peralta Gonzalez Luis David
*	Grupo: 4CM13
*/

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Palindromo{
	private List<String> diccionario;
	private String nombre;//= "listaPalindromos.txt";
	private int total;

	public Palindromo(){
		diccionario = new ArrayList<>();
		nombre = "";
		total=0;
	}
	public void buscarPalindromos(){
		//Variables
		Scanner entrada = new Scanner(System.in);
		String palabra = "";
		List <String>cadena = new ArrayList<>();
		//Menu
		System.out.println("\t-> "+nombre+" -> "+total+" palabras analizadas");
		//Impresion de datos
		System.out.println("\t-> No. Palindromos: "+diccionario.size());
		for (int i=0; i<diccionario.size();i++ ) {
			System.out.println("\t["+(i+1)+"] "+diccionario.get(i));
		}
		total = 0;
	}
	public void ingresarNombreArchivo(){
		try{
			//Variables
			Scanner entrada = new Scanner(System.in);
			//Solicitud de datos
			System.out.printf("\t-> Nombre del archivo: ");
			nombre = entrada.nextLine();
			guardarPalabras(nombre+".txt");								
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
			archivo = new File (nombre);
			br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"utf-8"));
			//Lectura del fichero
			while((linea = br.readLine()) != null){
				//System.out.println(linea);				//imprime la linea completa
				linea = linea.toLowerCase();				//Convertimos la cadena a minusculas
				linea = linea.replaceAll("\u00e1","a");		//remplacamos a-tilde por a
				linea = linea.replaceAll("\u00e9","e");		//remplacamos i-tilde por e
				linea = linea.replaceAll("\u00ed","i");		//remplacamos i-tilde por i
				linea = linea.replaceAll("\u00f3","o");		//remplacamos p-tilde por o
				linea = linea.replaceAll("\u00fa","u");		//remplacamos u-tilde por u				
				//System.out.println("\t"+linea);
				String[] palabras = linea.split(" ");		//separa las palabras cuando encuentre un 'espacio' y las guarda en un arreglo
				String auxiliar = "";
				int largo =palabras.length;	// # palabras en la linea
				total +=largo;
				for(int i=0;i<largo;i++){
					auxiliar = palabras[i];					//guardamos la palabra i en auxiliar
					auxiliar = auxiliar.replaceAll("[^a-z]", "");
					//Filtrado de caracteres
					if(auxiliar.length() > 2){				//Se descartan string de tamaño 2
						//Ingreso a lista 'diccionario'
						if(!diccionario.contains(auxiliar) && esPalindromo(auxiliar))
							diccionario.add(auxiliar);
					}
					auxiliar = "";
				}
			}
     	}catch(Exception e2){
     		e2.printStackTrace();
     	}
	}
	private boolean esPalindromo(String cadena) {		
		String invertida = new StringBuilder(cadena).reverse().toString();		
		return invertida.equals(cadena);
	}
}