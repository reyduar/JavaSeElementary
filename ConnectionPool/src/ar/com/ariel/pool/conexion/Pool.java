package ar.com.ariel.pool.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
/**
 * 
 * @author Ariel Duarte
 *
 */
/*En java, un pool de conexiones es una clase java que tiene abiertas varias conexiones a base de datos. --//
  Cuando alguien necesita una conexión a base de datos, en vez de abrirla directamente con DriverManager.getConnection(),
  se la pide al pool usando su método pool.getConnection().
  El pool coge una de las conexiones que ya tiene abierta, la marca como que alguien la está usando para no dársela a 
  nadie más y la devuelve. La siguiente llamada a este método pool.getConnection(), buscará una conexión libre para 
  marcarla como ocupada y la devolverá ... y así sucesivamente.*/
public class Pool implements InterfacePool {

	private InterfaceDataSource ds;///Entrega una conexion funcionando
	private ArrayBlockingQueue<Connection> conexionesLibres;
	private HashMap<String, Connection> conexionesUtilizadas;
	private Integer numeroMaximoConexiones;
	private ResourceBundle config; //Va almacenar las configuraciones del archivo mysql.properties

	
	//--Cosntructor--//
	public Pool(){
		config = ResourceBundle.getBundle("ar.com.ariel.pool.conexion.mysql");///Le paso todos los valores del archivo
		ds = new DataSource(config.getString("url"), config.getString("driver"), config.getString("usuario"), config.getString("pass"));///Pasamos los parametros de la conexion del archivo
		numeroMaximoConexiones = Integer.parseInt(config.getString("numeroMaximoConexiones")); //Pasamos numero maximo de conexiones del archivo
		conexionesLibres = new ArrayBlockingQueue<Connection>(numeroMaximoConexiones, true);
		conexionesUtilizadas = new HashMap<String, Connection>();
	}
	@Override
	public Connection getConnection() {
		
		Connection con = null;
		
		try {
			//-- Verificamos si no excede el numero de conexiones con el numero de conexiones utilizadas --//
			if(conexionesUtilizadas.size() <  numeroMaximoConexiones){
				con = conexionesLibres.poll();///Obtenemos una conexion y removemos del Queue
				//-- Verificamos si la conexion que pedimos no este nula --//
				if(con == null) {
					con = ds.getConnection();///Si esta nula obtenemos una nueva conexion
					//-- Veficamos si la conexion esta cerrada --//
				}else if(con.isClosed()){
					this.getConnection();///Si esta cerradas volvemos a llamar a este metodo para que vuelva a mirar en la cola si hay otra conexion
				}
				conexionesUtilizadas.put(con.toString(), con);
			}
		} catch (SQLException e) {
			System.out.println("Problemas con el pool de conexiones "+e.getMessage());
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public void liberateConnection(Connection con) {
		conexionesLibres.add(con);
		conexionesUtilizadas.remove(con.toString());

	}

}
