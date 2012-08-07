package ar.com.iariel.javaio;

import java.util.Scanner;

public class LecturaDatosSencilla {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
				
				Scanner teclado = new Scanner(System.in);
				//--- Lectura de cadenas
				System.out.println("Leer cadena: ");
				String s = teclado.nextLine();
				//--- Lectura de caracteres
				System.out.println("Leer caracter: ");
				char c = teclado.findWithinHorizon(".",0).charAt(0);
				//--- Lectura de enteros
				System.out.println("Leer entero: ");
				int i = teclado.nextInt();
				//--- Double
				System.out.println("Leer Float: ");
				float f = teclado.nextFloat();
				//--- Lectura de Token
				System.out.println("Leer token: ");
				String t = teclado.next();
				
		 
				System.out.println("s="+s+", c="+c+", i="+i+", f="+f+", t="+t );
		    
		

	}

}
