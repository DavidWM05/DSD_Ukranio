/*
*	Inversiones. Calcular cuánto dinero tendría en una cuenta de
*	ahorro al final de 20 años si al inicio de cada año añado 500
*	dólares (solo de los años 1 al 10), el rendimiento anual es 
*	de 5% y reinvierto las ganancias.
*/
public class P12{
	public static void main(String[] args) {
		//Variables
		double dinero=0;
		//Proceso
		for(int i=1;i<=20;i++){
			if(i>=1 && i<=10){
				dinero += 500;
				System.out.printf(" [%d]  -> %.3f + %.3f",i,dinero,(dinero*0.05));
				dinero += dinero*(0.05);
				System.out.printf(" -> %.3f\n",dinero);
			}else{
				System.out.printf(" [%d] -> %.3f + %.3f",i,dinero,(dinero*0.05));
				dinero += dinero*(0.05);
				System.out.printf(" -> %.3f\n",dinero);
			}
		}
		System.out.println("\tTotal = $"+String.format("%.3f",dinero));
	}
}