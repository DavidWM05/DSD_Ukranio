/*
*	Proyecto #1
*	Nombre: Peralta Gonzalez Luis David
*	Grupo: 4CM13
*
*	instrucciones: La carpeta LIBROS contiene varios libros de literatura en español. Elabore un programa que lea todos los libros y genere una
*	lista de palabras correctamente escritas para implementar un corrector ortográfico simple. Después de generar la lista el 
*	usuario podrá ingresar una cadena de texto cuya ortografía se desea revisar. El programa debe imprimir todas las palabras que
*	no están en la lista de palabras como palabras potencialmente mal escritas. Favor de no subir los libros en su proyecto. 
*
*	Importante: Suba cada clase en un archivo separado, y cada archivo de código que suba debe contener al inicio como comentario
*	el número de proyecto, su nombre completo y el grupo al que pertenece, de no hacerlo así se le descontará un punto de la 
*	calificación. No suba archivos comprimidos ni ligas a sitios web externos pues no le será tomado en cuenta el proyecto. Asimismo,
*	deberá subir un video breve mostrando como se ejecuta su proyecto y que efectivamente realiza lo que se pide. Se recomienda utilizar
*	OBS Studio y no es necesario que hable en el video. 
*/

public class Main{
	public static void main(String[] args) {
		String path = "LIBROS_TXT";
		Corrector diccionario = new Corrector(path);
		//Proceso
		diccionario.buscarArchivosEnFolder();
		diccionario.buscarPalabra();
	}
}