package ar.com.ariel.pool.implementation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * 
 * @author Ariel Duarte
 *
 */
public class LecturaXML {

/*
 * Metodo que devuelve un dataSet apartir de un archivo XML
 */
	public List<Element> xmlData() {
		List<Element> resultado = new ArrayList<Element>();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File("libreria.xml"));//Esta en el directorio raiz del proyecto
			doc.getDocumentElement().normalize();

//			System.out.println("El elemento raíz es: "
//					+ doc.getDocumentElement().getNodeName());
			NodeList listaPersonas = doc.getElementsByTagName("api");

			for (int i = 0; i < listaPersonas.getLength(); i++) {

				Node persona = listaPersonas.item(i);

				if (persona.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) persona;
					resultado.add(elemento);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	/*
	 * Permite obtener el valor de un TagName
	 */
	public static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();

	}

}
