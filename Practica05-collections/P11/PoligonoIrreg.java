import java.util.*;
public class PoligonoIrreg{
    private ArrayList<Coordenada> vertices = new ArrayList<Coordenada>();
    private int contador;
    @Override
    public String toString(){
        String aux="| X | Y |\n";
        
        for(Coordenada coor: vertices){
            aux=aux +"["+ String.valueOf(coor.abcisa())+","+String.valueOf(coor.ordenada())+"]\n";
        }
        return aux;
    }
    public void anadeVertice(Coordenada aux){
        vertices.add(aux);
    }
}