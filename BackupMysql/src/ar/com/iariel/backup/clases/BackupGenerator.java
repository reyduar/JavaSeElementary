package ar.com.iariel.backup.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class BackupGenerator {
	JFileChooser chooser = new JFileChooser();
	
	//TODO : Metodo que permitira llenar el dropdown con las base de datos del servidor
	private void fillDropDown(){
		Connection cn;
		PreparedStatement ps;
		ResultSet rs;
		List<Object> dataBases = new ArrayList<Object>();
		try {
			//-- Cargamos la clase que implementa el Driver --//
			Class.forName("com.mysql.jdbc.Driver");
			
			//-- Creamos variable de conexion --//
			String url = "jdbc:mysql://localhost:3306/bdtest";
			
			//-- Creamos la conexion --//
			Connection conexion = DriverManager.getConnection(url,"root","123");
			ps=conexion.prepareStatement("show databases");
			rs=ps.executeQuery();			
			while(rs.next()){
				dataBases.add(rs.getObject(1));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error :"+e.getMessage());
		}
	}
}
