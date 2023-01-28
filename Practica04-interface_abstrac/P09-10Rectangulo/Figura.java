public abstract class Figura{
	public Coordenada superiorIzq, inferiorDer; 
	public Figura(){
		superiorIzq = new Coordenada(0,0);
        inferiorDer = new Coordenada(0,0);
	}
	public abstract double area();
}