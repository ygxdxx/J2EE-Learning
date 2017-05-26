package JAXP_parser;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/5/23.
 * email: wangsongyan921@163.com
 */
public class JAXPParserTest {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        //selectAll();
        //selectFirst();
        //addElement();
        //modifyNode();
        //deleteNode();
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("/Users/Cortana/IdeaProjects/JavaWeb/4-XML/XMLdemo/user.xml");
        listNode(document);
    }

    private static void selectAll() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("/Users/Cortana/IdeaProjects/JavaWeb/4-XML/XMLdemo/user.xml");
        NodeList nodeList = document.getElementsByTagName("name");

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getTextContent());
        }
    }

    private static void selectFirst() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("/Users/Cortana/IdeaProjects/JavaWeb/4-XML/XMLdemo/user.xml");
        NodeList nodeList = document.getElementsByTagName("name");
        String name = nodeList.item(0).getTextContent();
        System.out.println(name);
    }

    private static void addElement() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("/Users/Cortana/IdeaProjects/JavaWeb/4-XML/XMLdemo/user.xml");
        NodeList nodeList = document.getElementsByTagName("u");
        Node userNode = nodeList.item(0);

        Element sexElement = document.createElement("sex");
        Text text = document.createTextNode("男");
        sexElement.appendChild(text);
        userNode.appendChild(sexElement);

        //write back to XML document
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult("/Users/Cortana/IdeaProjects/JavaWeb/4-XML/XMLdemo/user.xml"));
    }

    private static void modifyNode() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("/Users/Cortana/IdeaProjects/JavaWeb/4-XML/XMLdemo/user.xml");
        NodeList nodeList = document.getElementsByTagName("name");
        Node nameNode = nodeList.item(0);
        nameNode.setTextContent("小刚");

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult("/Users/Cortana/IdeaProjects/JavaWeb/4-XML/XMLdemo/user.xml"));
    }

    private static void deleteNode() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("/Users/Cortana/IdeaProjects/JavaWeb/4-XML/XMLdemo/user.xml");
        NodeList nodeList = document.getElementsByTagName("sex");
        Node sexNode = nodeList.item(0);
        Node sexParentNode = sexNode.getParentNode();
        sexParentNode.removeChild(sexNode);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult("/Users/Cortana/IdeaProjects/JavaWeb/4-XML/XMLdemo/user.xml"));
    }

    private static void listNode(Node node) throws IOException, SAXException, ParserConfigurationException {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(node.getNodeName());
        }
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            listNode(nodeList.item(i));
        }
    }

}
