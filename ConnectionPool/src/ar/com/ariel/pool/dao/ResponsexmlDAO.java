package ar.com.ariel.pool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ar.com.ariel.pool.bean.Responsexml;
import ar.com.ariel.pool.conexion.InterfacePool;
/**
 * 
 * @author Ariel Duarte
 *
 */
public class ResponsexmlDAO implements InterfaceResponseXML {
	
	private InterfacePool pool;
	
	public ResponsexmlDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}

	@Override
	public void save(Responsexml responsexml) throws SQLException {
		//-- Necesitamos una conexion para poder salvar los datos, se lo pedimos al pool --//
				Connection con = pool.getConnection();
				//-- Creamos declaracion para manipulacion --//
				PreparedStatement ps;
				
				String sqlInsert = "INSERT INTO responsexml (name, value)  VALUES (?, ?); " ;
				/* Creamos el try para que pueda siempre ejecutarse la liberacion de la conexion 
				 * por mas que exista una excepcion en el transcurso de la transaccion */
				try {
					//-- Creamos Prepared Statement --//
					ps = con.prepareStatement(sqlInsert);
					
					ps.setString(1, responsexml.getName());
					ps.setString(2, responsexml.getValue());

					ps.executeUpdate(); ///Ejecutamos las sentencias
					ps.close();///Cerramos la conexion
				} finally { 
					//-- Siempre se ejecutara la liberacion de la conexion --//
					pool.liberateConnection(con);///Devolvemos la conexion al pool para que la reutice
				}

	}

	@Override
	public void delete(Integer codigo) throws SQLException {
		// TODO Metodo sin implementar

	}

	@Override
	public void update(Responsexml responsexml) throws SQLException {
		// TODO Metodo sin implementar

	}

	@Override
	public List<Responsexml> getResponsexml() throws SQLException {
		// TODO Metodo sin implementar
		return null;
	}

}
