/*
*	Encontrar los números entre el 1 y el 5000 que cumplen la regla
* 	de que la suma del cubo de sus dígitos es igual al número mismo.
*	Ejemplo: 153 = 1^3+5^3+3^3
*/
public class P11{
	public static int unidad(int u){
		int aux=0;
			 if(u==9) aux = 9;
		else if(u==8) aux = 8;
		else if(u==7) aux = 7;
		else if(u==6) aux = 6;
		else if(u==5) aux = 5;
		else if(u==4) aux = 4;
		else if(u==3) aux = 3;
		else if(u==2) aux = 2;
		else if(u==1) aux = 1;

		return aux;
	}
	public static int decena(int d){
		int aux=0;
			 if(d>=90) aux = 9;
		else if(d>=80) aux = 8;
		else if(d>=70) aux = 7;
		else if(d>=60) aux = 6;
		else if(d>=50) aux = 5;
		else if(d>=40) aux = 4;
		else if(d>=30) aux = 3;
		else if(d>=20) aux = 2;
		else if(d>=10) aux = 1;

		return aux;
	}
	public static int centena(int c){
		int aux=0;
			 if(c>=900) aux = 9;
		else if(c>=800) aux = 8;
		else if(c>=700) aux = 7;
		else if(c>=600) aux = 6;
		else if(c>=500) aux = 5;
		else if(c>=400) aux = 4;
		else if(c>=300) aux = 3;
		else if(c>=200) aux = 2;
		else if(c>=100) aux = 1;

		return aux;
	}
	public static int millar(int m){
		int aux=0;
			 if(m==4000) aux = 4;
		else if(m>=3000) aux = 3;
		else if(m>=2000) aux = 2;
		else if(m>=1000) aux = 1;

		return aux;
	}
	public static void main(String[] args) {
		//Variables
		int numero,u=0,d=0,c=0,m=0;
		double aux;
		//Proceso
		for(int i=1;i<=5000;i++){
			numero = i;
			m = millar(numero);  numero -=1000*m;
			c = centena(numero); numero -=100*c;
			d = decena(numero);  numero -=10*d;
			u = unidad(numero);  numero -=u;
			aux = Math.pow(m,3)+Math.pow(c,3)+Math.pow(d,3)+Math.pow(u,3);
			u = d = c = m = 0;
			if(aux==i)
				System.out.println(" -> | "+i+" | ");
		}
	}
}