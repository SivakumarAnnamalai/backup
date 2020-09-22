package java8;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.security.Permission;


/**
 * Created by sivakumaran on 6/28/2016.
 */
public class Q42 {
    public static void main(String args[]) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Node node1 = document.createElement("node1");
        Node node2 = document.createElement("node2");
        Node node3 = document.createTextNode("Hello, World");
        document.appendChild(node2);
        node1.appendChild(node3);
        node3 = document.createElement("node4");
        node2.appendChild(node1);
        node1 = document.createTextNode("Good-bye");
        node2.appendChild(node3);
        node3.appendChild(node1);


        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));
        String output = writer.getBuffer().toString().replaceAll("\n|\r", "");
        System.out.println(output);

        NodeList list = document.getElementsByTagName("node1");
        Node node = list.item(0);
        System.out.println(node.getLocalName());




    }
}
