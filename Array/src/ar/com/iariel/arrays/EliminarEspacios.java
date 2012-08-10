package ar.com.iariel.arrays;

public class EliminarEspacios {

	/**
	 * @author reynaldo.duarte
	 */
	public static void main(String[] args) {
		String citaDiaria = "La educación consiste en enseñar a los hombres no lo que deben pensar si no a pensar.";
		char[] convertir = citaDiaria.toCharArray();
		for (int dex = 0; dex < convertir.length; dex++) {
			char current = convertir[dex];
			if (current != ' ') {
				System.out.print(current);
			} else {
				System.out.print('.');
			}
		}

	}

}
