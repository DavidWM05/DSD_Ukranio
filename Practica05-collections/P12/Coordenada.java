public class Coordenada {
    private double x, y;
    public int magnitud;
    public Coordenada(){};
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
        magnitud = (int)Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }
    //Metodo getter de x
    public double abcisa( ){ return x; }
    //Metodo getter de y
    public double ordenada( ){ return y; }
    //Metodo setter de x
    public void setx(double x){ this.x=x; }
    //Metodo setter de y
    public void sety(double y){ this.y=y; }
    public int getMag( ){ return magnitud; }
    //Sobreescritura toString
    @Override
    public String toString( ) {
        return "[" + x + "," + y + "]"+" M = "+magnitud;
    }
}