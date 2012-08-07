package ar.com.iariel.javase.loop;

public class ContinueLoop {

	/**
	 * @author Ariel Duarte
	 */
	
	//-- Podemos ver que al usar Continue hace un puente de acuerdo a la condicion que le indiquemos
	//-- En este caso no se imprimira el valor 5
	public static void main(String[] args) {
		int index = 0;

		while (index <= 10) {
			index++;
			if (index == 5) 
				continue;
				
			System.out.println("El index es : "+index);
			
		}

	}

}
