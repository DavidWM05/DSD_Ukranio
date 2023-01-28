public class Cuadrado extends Figura implements Perimetro {

    public Cuadrado(double xSupIzq, double ySupIzq, double xInfDer, double yInfDer){
        superiorIzq = new Coordenada(xSupIzq, ySupIzq);
        inferiorDer = new Coordenada(xInfDer, yInfDer);        
    }

    //Metodo getter de la coordenada superior izquierda
    public Coordenada superiorIzquierda( ) { return superiorIzq; }
    //Metodo getter de la coordenada inferior derecha
    public Coordenada inferiorDerecha( ) { return inferiorDer; }    
    //Sobreescritura del método de la superclase objeto para imprimir con System.out.println( )
    @Override
    public String toString( ) {
        return " Esquina superior izquierda: " + superiorIzq + "\tEsquina superior derecha:" + inferiorDer;
    }
    @Override
    public double area(){
        double lado = superiorIzq.ordenada() - inferiorDer.ordenada();
        return lado * lado;
    }
    public double imprimePerimetro(){
    	double lado = superiorIzq.ordenada() - inferiorDer.ordenada();
    	return lado*4;
    }
}