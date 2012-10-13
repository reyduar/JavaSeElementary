package ar.com.ariel.pool.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author Ariel Duarte
 * 
 */

//-- En esta Clase definimos la conexion a la Base de Datos de la Aplicacion Web --//
//-- Implementamos la InterfaceDaraSorce --//
//-- Todos los datos de la conexion son parametrizables debido a que podemos usar esta clase para cualquier banco de datos --//
public class DataSource implements InterfaceDataSource {

	private String url;
	private String driver;
	private String usuario;
	private String pass;

//-- Atravez del constructor recibimos los parametros para una conexion a una Base de Datos cualquiera que se --// 
	public DataSource(String url, String driver, String usuario, String pass) {
		super();
		this.url = url;
		this.driver = driver;
		this.usuario = usuario;
		this.pass = pass;
		try {
			//-- Cargamos la clase que implementa el Driver --//
			Class.forName(driver);
		} catch (ClassNotFoundException er) {
			System.out.println("Clase no encontrada : "+er);
			er.printStackTrace();
		}
	}




	//-- Creamos la conexion --//
	@Override
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, usuario, pass);
	}

}
