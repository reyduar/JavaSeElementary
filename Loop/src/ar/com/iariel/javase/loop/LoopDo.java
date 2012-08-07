package ar.com.iariel.javase.loop;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.out;
public class LoopDo {

	/**
	 * @author Ariel Duarte
	 * 06/08/2012
	 * 
	 */
	
	//--- Este es un ejemplo de Do...While con creacion y eliminacion de fichero java ---//
	public static void main(String[] args) {
		File archivo = new File("c:\\miArchivo.txt");
		
		try {
		      // A partir del objeto File creamos el fichero físicamente
		      if (archivo.createNewFile())
		        System.out.println("El fichero se ha creado correctamente");
		      else
		        System.out.println("No ha podido ser creado el fichero");
		    } catch (IOException ioe) {
		    	System.out.println("Error al crear el fichero :"+ioe.getMessage());
		    }
		
		Scanner miScanner = new Scanner(System.in);
		
		char replica;
		
		//-- Podemos ver la estructura del do..while que siempre se podra ejecutar una vez --//
		do {
			out.print("¿Ahora borrar el archivo (S/N)?");
			replica = miScanner.findWithinHorizon(".", 0).charAt(0);
		} while (replica != 's' && replica != 'n' && replica == 'S');
		
		if (replica == 's' || replica == 'S') {
			out.println("De acuerdo, borrando archivo. . .");
			archivo.delete();
		}else{
			out.println("De acuerdo, No borrar archivo. . .");
		}
	}

}
