package dom4j_parser;

import dom4j_util.Dom4jUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * Created by wangsongyan on 2017/5/24.
 * email: wangsongyan921@163.com
 */
public class Dom4jParserTest {

    private static final String docPath = "/Users/Cortana/IdeaProjects/JavaWeb/4-XML/XMLdemo/student.xml";

    public static void main(String[] args) throws Exception {
        /*
         * 1.create dom4j parser
         * 2.get document
         * 3.get root of elements
         * ....
         */

        //selectNodeText();
        //addNode();
        //addSpecificIndexNode();
        //modifyNodeText();
        //delElement();
        getAttributeValue();
    }

    private static void getAttributeValue() {
        Document document = Dom4jUtil.getDocument(docPath);
        Element rootElement = document.getRootElement();
        Element headStuElement = rootElement.element("s");
        if (headStuElement.attributeCount() != 0) {
            //get value of attribute
            String attrValue = headStuElement.attributeValue("id");
            System.out.println(attrValue);
        }
    }

    private static void delElement() {
        Document document = Dom4jUtil.getDocument(docPath);
        Element rootElement = document.getRootElement();
        Element headStudentElement = rootElement.element("s");
        Element gradeElement = headStudentElement.element("sex");
        //remove element
        headStudentElement.remove(gradeElement);
        Dom4jUtil.writeBackToXmL(docPath, document);
    }

    private static void modifyNodeText() throws SAXException {
        Document document = Dom4jUtil.getDocument(docPath);
        if (document != null) {
            Element rootElement = document.getRootElement();
            Element studentElement = rootElement.element("s");
            Element schoolElement = studentElement.element("school");
            System.out.println(schoolElement.getText());
            schoolElement.setText("SUT");
            //write back to XML
            Dom4jUtil.writeBackToXmL(docPath, document);
        }
    }

    private static void addSpecificIndexNode() throws DocumentException, IOException {
        Document document = Dom4jUtil.getDocument(docPath);
        Element firstStudentElement = document.getRootElement().element("s");
        List<Element> allElements = firstStudentElement.elements();
        //create new element from DocumentHelper
        Element schoolElement = DocumentHelper.createElement("school");
        schoolElement.setText("STU");
        allElements.add(1, schoolElement);
        //write back to XML
        Dom4jUtil.writeBackToXmL(docPath, document);
    }

    private static void addNode() throws DocumentException, IOException {
        Document document = Dom4jUtil.getDocument(docPath);

        Element rootElement = document.getRootElement();
        Element studentElement = rootElement.element("s");
        Element gradeElement = studentElement.addElement("grade");
        gradeElement.setText("A001");

        //write back to XML document
        Dom4jUtil.writeBackToXmL(docPath, document);
    }

    private static void selectNodeText() throws Exception {
        Document document = Dom4jUtil.getDocument(docPath);
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements("s");

        //print names of all students
        /*for (Element e : elements) {
            Element name = e.element("name");
            System.out.println(name.getText());
        }*/

        //print name of last student
        Element elementLast = elements.get(elements.size() - 1);
        Element name = elementLast.element("name");
        System.out.println(name.getText());
    }
}

