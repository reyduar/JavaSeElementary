package cliente;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class LecturaXML {

 public static void main(String argv[]) {

  try {
	  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	  Document doc = dBuilder.parse(new File("libro.xml"));
	  doc.getDocumentElement().normalize();

	  System.out.println("El elemento raíz es: " + doc.getDocumentElement().getNodeName());
	  NodeList listaPersonas = doc.getElementsByTagName("persona");

	  for (int i = 0; i < listaPersonas.getLength(); i ++) {

	    Node persona = listaPersonas.item(i);

	    if (persona.getNodeType() == Node.ELEMENT_NODE) {

            Element elemento = (Element) persona;

            System.out.println("Nombre : " + getTagValue("nombre", elemento));
            System.out.println("Apellido : " + getTagValue("apellido", elemento));
            System.out.println("Edad : " + getTagValue("edad", elemento));

	    }
    }
  } catch (Exception e) {
    e.printStackTrace();
  }

 }

 private static String getTagValue(String sTag, Element eElement)
 {
	  NodeList nlList= eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	  Node nValue = (Node) nlList.item(0);

	  return nValue.getNodeValue();

 }

}
