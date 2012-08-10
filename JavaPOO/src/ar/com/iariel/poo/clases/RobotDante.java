package ar.com.iariel.poo.clases;

public class RobotDante {
	public String estatus;
	public int velocidad;
	public float temperatura;
	
	public void comprobarTemperatura(){
		if(temperatura > 660){
			estatus = "Volviendo a casa";
			velocidad = 5;
		}
	}
	
	public void mostrarAtributos(){
		System.out.println("Estatus :"+estatus);
		System.out.println("Velocidad :"+velocidad);
		System.out.println("Temperatura :"+temperatura);
	}
}
