import java.util.Random;

public class P05cadena {
   public static void main(String[] args) {
        long inicioT=System.currentTimeMillis(); //Inicio tiempo de ejecucion
        int ipn=0, cont=0, n = Integer.parseInt(args[0]);
        byte[] cadenota = new byte[n*4];
        Random nrandom = new Random();
        String palabra ="",aux="";      
        
        //Letras aleatorias A-Z
        for(int i=0;i<(n*4);i++){ 	            
            byte x = (byte) (nrandom.nextInt(26)+'A');    
            cadenota[i]=x;  //Se guarda en la cadena
        }
        //Espacios
		for(int i=3;i<(n*4);i+=4){
			cadenota[i]=' ';	
		}
    	//Busqueda		
        for(int i =0,j=0;i<(n*4);i++){
            palabra = palabra + (char)cadenota[i];            
            j++;
	    	if(j==4){
				if(palabra.equals("IPN ")){
				ipn++;
				aux=aux+String.valueOf(i-3)+"|";	
				}
	     		palabra = "";
				j=0;
	     	}		    
        }
	
		//System.out.println("Posiciones -> |"+aux);
		//System.out.println("Total = "+ipn);

		long finT = System.currentTimeMillis(); //Fin tiempo de ejcucion

		double tiempo = (double)((finT-inicioT)/1000.0);
		System.out.println("Tiempo = "+ tiempo + "s");
     }
}