public class Rectangulo extends Figura {

    public Rectangulo(double xSupIzq, double ySupIzq, double xInfDer, double yInfDer){
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
        double alto = superiorIzq.ordenada() - inferiorDer.ordenada();
        double ancho = inferiorDer.abcisa() - superiorIzq.abcisa();
        return alto * ancho;
    }
    public double imprimePerimetro(){
        double alto = superiorIzq.ordenada() - inferiorDer.ordenada();
        double ancho = inferiorDer.abcisa() - superiorIzq.abcisa();
        return (alto*2)+(ancho*2);        
    }
}