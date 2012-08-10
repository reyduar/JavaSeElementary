package ar.com.iariel.arrays;

import java.util.Arrays;

public class OdenarArrays {

	/**
	 * @author reynaldo.duarte
	 */
	public static void main(String[] args) {
		String [] nombres = {"Miguel", "Maria", "Alberto", "Fernando", "Alejadro", "Rosa",
				"Evaristo", "Bernardo", "Fransisco", "Homero", "Cristina", "Carla", "Cesar"};
		
		System.out.println("El orden original:");
		for (int i = 0; i < nombres.length; i++) {
			System.out.print(i+" : "+nombres[i]+ " - ");
		}
		System.out.println();
		Arrays.sort(nombres); ///Permite ordenar el array
		System.out.println("El nuevo orden :");
		for (int i = 0; i < nombres.length; i++) {
			System.out.print(i+" : "+nombres[i]+ " - ");
		}
		System.out.println();
	}

}
