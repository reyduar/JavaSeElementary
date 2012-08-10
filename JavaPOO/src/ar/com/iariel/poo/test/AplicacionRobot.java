package ar.com.iariel.poo.test;

import ar.com.iariel.poo.clases.RobotDante;

public class AplicacionRobot {

	/**
	 * @author reynaldo.duarte
	 */
	public static void main(String[] args) {
		RobotDante rd = new RobotDante();
		rd.estatus = "Explorando";
		rd.velocidad = 2;
		rd.temperatura = 700;
		rd.mostrarAtributos();
		rd.comprobarTemperatura();
		
		rd.mostrarAtributos();
		
	}

}
