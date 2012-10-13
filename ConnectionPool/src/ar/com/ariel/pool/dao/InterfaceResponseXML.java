package ar.com.ariel.pool.dao;

import java.sql.SQLException;
import java.util.List;

import ar.com.ariel.pool.bean.Responsexml;
/**
 * 
 * @author Ariel Duarte
 *
 */
public interface InterfaceResponseXML {
	/* Esta interface definira los metodos que seran esperados por una clase que sera 
	   responsable del acceso a los datos referente a los datos del XML*/
		public abstract void save(Responsexml responsexml) throws SQLException;//Guarda nuevos datos del XML
		public abstract void delete(Integer codigo) throws SQLException;//Elimina datos
		public abstract void update(Responsexml responsexml) throws SQLException;//Actualiza datos
		public abstract List<Responsexml> getResponsexml() throws SQLException; ///Devuelve datos
	

}
