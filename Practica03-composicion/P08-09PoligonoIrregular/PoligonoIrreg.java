public class PoligonoIrreg{
	private Coordenada[] vertices;
	private int contador;
	
	PoligonoIrreg(int vert){
		vertices = new Coordenada[vert];
		contador=0;
	}
	@Override
	public String toString(){
		String aux="| X | Y |\n";
		
		for(int i=0;i<contador;i++){
			aux=aux +"["+ String.valueOf(vertices[i].abcisa())+","+String.valueOf(vertices[i].ordenada())+"]\n";
		}
		return aux;
	}
	public void anadeVertice(Coordenada aux){
		vertices[contador] = aux;
		contador++;
	}
}