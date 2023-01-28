/*
*	La Comisión Federal de Electricidad cobra el consumo de electricidad de
*	acuerdo con un tabulador basado en los kilowatts consumidos en el periodo.
*	La tabla es la siguiente:
*		Costo del kW para Hogares:
*			De 0 a 250 kW el costo por kW es de $0.65
*			De 251 a 500 kW el costo por kW es de $0.85
*			De 501 a 1200 kW el costo por kW es de $1.50
*			De 1201 a 2100 kW el costo por kW es de $2.50
*			De 2101 kW hacia arriba el costo por kW es de $3.00
*		Costo del kW para Negocios:
*			$5.00, el costo es fijo por kilowatt sin importar la cantidad consumida.
*/
import java.util.*;

public class P07{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int contrato, kwatts;
		double total=0;

		System.out.printf(" Contrato: ");
		contrato = in.nextInt();
		System.out.printf(" kwatts consumidos: ");
		kwatts = in.nextInt();

		if(contrato==1){//Contrato Hogar - tipo 1
			if(kwatts>=2101){
				total = 250*0.65+250*0.85+700*1.5+900*2.5+(kwatts-2100)*3.0;
			}else if(kwatts>=1201){
				total = 250*0.65+250*0.85+700*1.5+(kwatts-1200)*2.5;
			}else if(kwatts>=501){
				total = 250*0.65+250*0.85+(kwatts-500)*1.5;
			}else if(kwatts>=251){
				total = 250*0.65+(kwatts-250)*0.85;
			}else {
				total = kwatts*0.65;
			}
		}else{//Contrato Negocios - tipo 2
			total = kwatts*5;
		}

		System.out.println(" El total por "+kwatts+" kw consumidos es $"+total);
	}
}