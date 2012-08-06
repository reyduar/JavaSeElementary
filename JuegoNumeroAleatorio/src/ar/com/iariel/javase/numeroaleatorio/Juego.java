package ar.com.iariel.javase.numeroaleatorio;

import static java.lang.System.out;
import java.util.Scanner;
import java.util.Random;

public class Juego {

	/**
	 * @author Ariel Duarte
	 * 06/08/2012
	 */
	public static void main(String[] args) {
		Scanner miScanner = new Scanner( System.in); ///No permite recuperar entradas de teclado por consola
		int numIntentos = 0;
		int numAleatorio = new Random().nextInt(10) + 1;///Permite generar el numero aleatorio
		out.println("**********     INTENTA ENCONTRAR EL NUMERO     **************");
		out.println("Bienvenidos al juego \"Intentando ser Groso en Java\"");
		out.println("*********** ** ***** ********************************");
		out.println();
		out.println("Porfavor ingrese un numero del 1 al 10: ");
		int numeroEscrito = miScanner.nextInt(); ///Persive el valor ingresado en el teclado
		numIntentos++;///Acumuldor del numero de intentos ingrementado
		while (numeroEscrito != numAleatorio) { ///El loop no termina hasta que el numero ingresa sea igual al numero aleatorio
			out.println( );
			out.println("  Intentalo de nuevo  . . . ");
			out.println("  Escribe un numero del 1 al 10: ");
			numeroEscrito = miScanner.nextInt();///Persive un nuevo valor ingresado en el teclado
			numIntentos++;
		}
		out.println("GANASTE!!! LO ENCONTRASTE HIJO DE PUTA ERES UN GENIO");
		out.println("Lo encontraste despues de : "+ numIntentos);
		
	}

}
