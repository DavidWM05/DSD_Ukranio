import java.util.Random;

public class PruebaPoligono {

    public static void main (String[] args) {
        int vertices=3;
        Random rand = new Random();
        PoligonoIrreg pol = new PoligonoIrreg(); 
        PoligonoIrreg objeto = null;
        Coordenada aux[] = new Coordenada[vertices];

        for(int i =0 ;i<vertices;i++){
        	int x = rand.nextInt(15+1)+1;
        	int y = rand.nextInt(15+1)+1;

        	pol.anadeVertice(new Coordenada(x,y));
        	System.out.println(i);
        }       

        byte[] serializado = SerializationUtils.serialize(pol);
        System.out.println("Serializado: "+serializado);

        objeto = (PoligonoIrreg)SerializationUtils.deserialize(serializado);

        System.out.println("Coordenadas del poligono irregular:");
        System.out.println("Deserializado: \n"+objeto.toString());
    }
}