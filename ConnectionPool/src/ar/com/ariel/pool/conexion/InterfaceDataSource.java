package ar.com.ariel.pool.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author Ariel Duarte
 * 
 */
//--Esta Interface va tener un metodo abstracto que sera necesario para la conexion a la Base de Datos --//
//-- Java ya tiene una Interface datasource, yo creo esta porque esta mas simple --//
public interface InterfaceDataSource {
//-- Esta Interface va definir los metodos para las conexiones --//
//-- La clase que implmenente esta interface debera implementar este metodo y es metodo va obtener una conexion --///
	public abstract Connection getConnection() throws SQLException; 
}
