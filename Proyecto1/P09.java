/*
*	Escribe un programa que reciba un número en el rango de 1 a 3000
*	y lo convierta en número romano. Ejemplo: 1997 sería MCMXCVII
*/
import java.util.*;

public class P10{
	public static int unidad(int u){
		int aux=0;
			 if(u==9){ aux = 9; System.out.printf("IX");}
		else if(u==8){ aux = 8; System.out.printf("VIII");}
		else if(u==7){ aux = 7; System.out.printf("VII");}
		else if(u==6){ aux = 6; System.out.printf("VI");}
		else if(u==5){ aux = 5; System.out.printf("V");}
		else if(u==4){ aux = 4; System.out.printf("IV");}
		else if(u==3){ aux = 3; System.out.printf("III");}
		else if(u==2){ aux = 2; System.out.printf("II");}
		else if(u==1){ aux = 1; System.out.printf("I");}

		return aux;
	}
	public static int decena(int d){
		int aux=0;
			 if(d>=90){ aux = 9; System.out.printf("XC");}
		else if(d>=80){ aux = 8; System.out.printf("LXXX");}
		else if(d>=70){ aux = 7; System.out.printf("LXX");}
		else if(d>=60){ aux = 6; System.out.printf("LX");}
		else if(d>=50){ aux = 5; System.out.printf("L");}
		else if(d>=40){ aux = 4; System.out.printf("XL");}
		else if(d>=30){ aux = 3; System.out.printf("XXX");}
		else if(d>=20){ aux = 2; System.out.printf("XX");}
		else if(d>=10){ aux = 1; System.out.printf("X");}

		return aux;
	}
	public static int centena(int c){
		int aux=0;
			 if(c>=900){ aux = 9; System.out.printf("CM");}
		else if(c>=800){ aux = 8; System.out.printf("DCCC");}
		else if(c>=700){ aux = 7; System.out.printf("DCC");}
		else if(c>=600){ aux = 6; System.out.printf("DC");}
		else if(c>=500){ aux = 5; System.out.printf("D");}
		else if(c>=400){ aux = 4; System.out.printf("CD");}
		else if(c>=300){ aux = 3; System.out.printf("CCC");}
		else if(c>=200){ aux = 2; System.out.printf("CC");}
		else if(c>=100){ aux = 1; System.out.printf("C");}

		return aux;
	}
	public static int millar(int m){
		int aux=0;
			 if(m==3000){ aux = 3; System.out.printf("MMM");}
		else if(m>=2000){ aux = 2; System.out.printf("MM");}
		else if(m>=1000){ aux = 1; System.out.printf("M");}

		return aux;
	}
	public static void main(String[] args) {
		//Variables
		Scanner in = new Scanner(System.in);
		int numero,u=0,d=0,c=0,m=0;
		//Solicitud de datos
		System.out.printf("Ingresa el numero: ");
		numero = in.nextInt();
		//Proceso
		if(numero > 0 && numero <= 3000){
			System.out.printf(" %d -> ",numero);
			m = millar(numero);
			numero -= 1000*m;
			c = centena(numero);
			numero -=100*c;
			d = decena(numero);
			numero -=10*d;
			u = unidad(numero);
			numero -=u;
		}else
			System.out.println("Numero fuera del rango de conversion!!");
	}
}