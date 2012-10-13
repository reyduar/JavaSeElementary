package ar.com.ariel.pool.conexion;

import java.sql.Connection;
//-- Ya existe una implementacion de pool en java pero yo hago uno nuevo porque quiero hacer algo mas facil --//
//-- El pool permite tener centralizado y controlado el manejo de las conexiones a la base de datos --//
public interface InterfacePool {
	public abstract Connection getConnection(); //devolvera una conexion funcional
	public void liberateConnection(Connection con);//Permitira liberar una conexion
}
