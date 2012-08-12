package ar.com.iariel.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexionMysql {
	public static void main(String[] args) {
		try {
			//-- Cargamos la clase que implementa el Driver --//
			Class.forName("com.mysql.jdbc.Driver");
			
			//-- Creamos variable de conexion --//
			String url = "jdbc:mysql://localhost:3306/bdtest";
			
			//-- Creamos la conexion --//
			Connection conexion = DriverManager.getConnection(url,"root","123");
			
			//-- Creamos declaracion para manipulacion --//
			Statement st = conexion.createStatement();
			
			//-- Insertamos registros --//
			st.executeUpdate("Insert into clientes (codigo, nombre) values (4, 'Google inc.')");
					
			//-- Creamos nuestra consulta y alamacenamos el resultado en un ResultSet --//
			ResultSet rs = st.executeQuery("Select * From clientes");
			//-- Recorremos el resultado --//
			if (rs.first()) {
				do {
					System.out.println(rs.getInt("codigo")+" : "+rs.getString("nombre"));
				} while (rs.next());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
