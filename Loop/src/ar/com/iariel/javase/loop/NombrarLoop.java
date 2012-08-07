package ar.com.iariel.javase.loop;

public class NombrarLoop {

	/**
	 * @author Ariel Duarte
	 */
	
	//-- Este ejemplo pretende mostrar dos cosas importantes basicas:
	//-- 1º Como anidar dos loop de diferenres estructructuras
	//-- 2º Como nombrar un loop para poder salir de el para no se genere un break infinito
	public static void main(String[] args) {
		int points = 0;
		int target = 100;
		
		targetLoop://Este es el nombre que le damos al loop
		while (target <= 100) {
			for (int i = 0; i < target; i++) {
				if(points > 50){
					System.out.println("points="+points);
					System.out.println("Saliendo de los dos loops");
					break targetLoop;
				}
				points = points + i;
			}
		}
	}

}
