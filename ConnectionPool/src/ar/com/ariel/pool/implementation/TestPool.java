package ar.com.ariel.pool.implementation;

import java.sql.SQLException;
import java.util.Iterator;

import org.w3c.dom.Element;

import ar.com.ariel.pool.bean.Responsexml;
import ar.com.ariel.pool.conexion.InterfacePool;
import ar.com.ariel.pool.conexion.Pool;
import ar.com.ariel.pool.dao.InterfaceResponseXML;
import ar.com.ariel.pool.dao.ResponsexmlDAO;

/**
 * 
 * @author Ariel Duarte
 *
 */
public class TestPool {

	// public InterfacePool pool; // /Necesitamos una variable pool
	public InterfaceResponseXML xmlDAO;

	// -- Constructor --//
	public TestPool(InterfaceResponseXML xmlDAO) {
		super();
		this.xmlDAO = xmlDAO;
	}

	/*
	 * Metodo que recupera los datos del XML y lo almacena en la Base de Datos
	 */
	public void excute() {
		/*
		 * Aqui se deberia leer el archivo XML
		 */
		LecturaXML dataXML = new LecturaXML();
		for (Element elemento : dataXML.xmlData()) {
			/*
			 * Pasamos los datos del XML al Bean y lo guardamos en la Base de
			 * Datos Mysql
			 */
			Responsexml r = new Responsexml();
			r.setName(dataXML.getTagValue("nombre", elemento));
			r.setValue(dataXML.getTagValue("valor", elemento));
			
			try {
				System.out.println("Datos guardados --> " + r.getName() +" ; " + r.getValue()+"\n");
				xmlDAO.save(r);

			} catch (SQLException e) {
				System.out.println("Error al guardar los datos: "
						+ e.getMessage());
			}
		}

	}

	/*
	 * Metodo principal del programa
	 */
	public static void main(String[] args) {
		InterfacePool pool = new Pool();// Se solicita una conexion Pool
		new TestPool(new ResponsexmlDAO(pool)).excute();

	}

}
