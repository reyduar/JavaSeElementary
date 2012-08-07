package ar.com.iariel.javase.loop;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MedidorVelocidadPC {

	/**
	 * @author Ariel Duarte
	 */
	
	/// Este programa lo que hace es verificar la cantidad de loop que pueder imprimir en un minuto
	/// Lo podemos utilizar para verificar la velocidad de distintos ordenadores
	public static void main(String[] args) {
		Calendar start = Calendar.getInstance(); //Instanciamos de la clase clalendar para obtener el tiempo actual
		int startMinute = start.get(Calendar.MINUTE); //Minuto actual
		int startSegundo = start.get(Calendar.SECOND);//Segundo actual 
		
		System.out.println(startMinute+" Start minute!");
		System.out.println(startSegundo+" Start segundo!");
		
		start.roll(Calendar.MINUTE, true);//El metodo roll permite mover el tiempo hacia adelante
		
		//-- Volvemos a recuperar los valores pero en tras varibles
		int nextMinute = start.get(Calendar.MINUTE);
		int nextSegundo = start.get(Calendar.SECOND);
		
		System.out.println(nextMinute+" Next minute!");
		System.out.println(nextSegundo+" Next segundo!");
		int index = 0;
		
		while (true) { /// Cuando a un loop le pasamos un true le indicamos que es un loop infinito
			double x = Math.sqrt(index);
			GregorianCalendar now = new GregorianCalendar();
			
			if (now.get(Calendar.MINUTE)>= nextMinute ) {
				if (now.get(Calendar.SECOND)>= nextSegundo) {
					break;
				}
				
			}
			index++;
		}
		System.out.println(index+" loops en un minuto!");

	}

}
