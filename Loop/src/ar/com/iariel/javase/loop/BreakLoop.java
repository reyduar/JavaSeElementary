package ar.com.iariel.javase.loop;

public class BreakLoop {

	/**
	 * @author Ariel Duarte
	 */
	
	//--- Podemos ver el uso de Break para salir de un Loop cuando se ejecuta una condicion ----/////
	public static void main(String[] args) {
		
		int index = 0;
		
		while (index <= 1000) {
			index += 5;
			System.out.println(index);
			if(index==400){
				System.out.println("Llegamos a los 400.... Saliendo...");
				break;
			}
		}

	}

}
