/*
*	Proyecto #2 parte 2
*	Nombre: Peralta Gonzalez Luis David
*	Grupo: 4CM13 
*/

public class Main{
	public static void main(String[] args) {
		Palindromo archivo = new Palindromo();
		//Proceso
		System.out.printf("\n\t\tBUSQUEDA DE PALINDROMOS\n\n");
		archivo.ingresarNombreArchivo();
		archivo.buscarPalindromos();
		System.out.println("\n\t[Programa terminado]");
	}
}