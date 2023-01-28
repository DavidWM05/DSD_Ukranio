import java.util.*;
public class PoligonoIrreg{
    private ArrayList<Coordenada> vertices = new ArrayList<Coordenada>();
    private int contador;
  
    @Override
    public String toString(){
        String aux=" |  X  |  Y  |\n";
        for(Coordenada coor: vertices){
            String  mag = String.valueOf(coor.magnitud),
                    abcisa = String.format("%.3f",coor.abcisa()),
                    ordenada = String.format("%.3f",coor.ordenada());
            aux=aux +" ["+ abcisa +","+ordenada+"] = "+mag+"\n";
        }
        return aux;
    }
    public void anadeVertice(Coordenada aux){
        vertices.add(aux);
    }
    public void ordenaVertice(){
        Collections.sort(vertices, new Sortbymag());
    }
}
//Clase 2 - Comparador
class Sortbymag implements Comparator<Coordenada>{
    @Override
    public int compare(Coordenada a, Coordenada b){
        int aux = a.magnitud - b.magnitud; 
        return aux; 
    }
}