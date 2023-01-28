import java.util.Random;

public class PruebaPoligono {

    public static void main (String[] args) {
        long inicioT=System.currentTimeMillis(); //Inicio tiempo de ejecucion
        int vertices=3; //Diez millones
        Random rand = new Random();
        PoligonoIrreg pol = new PoligonoIrreg(vertices); 
        Coordenada aux[] = new Coordenada[vertices];

        

        for(int i =0 ;i<vertices;i++){
        	int x = rand.nextInt(15+1)+1;
        	int y = rand.nextInt(15+1)+1;
        	pol.anadeVertice(new Coordenada(x,y));
        	//System.out.println(i);
        }

/*        
		for(int i =0 ;i<vertices;i++){
			Coordenada cor = new Coordenada();
			int x = rand.nextInt(15+1)+1;
        	int y = rand.nextInt(15+1)+1;
			cor.setx(x);
			cor.sety(y);

        	pol.anadeVertice(cor);
        	//System.out.println(i);
        }        
*/
        //System.out.println("Coordenadas del poligono irregular:");
        //System.out.println(pol.toString());
        long finT = System.currentTimeMillis(); //Fin tiempo de ejcucion
        double tiempo = (double)((finT-inicioT)/1000.0);
        System.out.println("Tiempo = "+ tiempo + "s");        
    }
}
