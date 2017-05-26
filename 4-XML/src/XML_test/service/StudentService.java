package XML_test.service;

import XML_test.vo.Student;
import com.sun.org.apache.xerces.internal.dom.ParentNode;
import dom4j_util.Dom4jUtil;
import javafx.scene.Parent;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import java.util.List;

/**
 * Created by wangsongyan on 2017/5/26.
 * email: wangsongyan921@163.com
 */
public class StudentService {

    private static final String docPath = "/Users/Cortana/IdeaProjects/JavaWeb/4-XML/src/XML_test/student.xml";

    public static void addStu(Student student) {
        Document document = Dom4jUtil.getDocument(docPath);
        Element rooElement = document.getRootElement();
        Element stuElement = rooElement.addElement("stu");
        Element stuName = stuElement.addElement("name");
        Element stuAge = stuElement.addElement("age");
        Element stuGrade = stuElement.addElement("grade");
        stuName.addText(student.getName());
        stuAge.addText(student.getAge());
        stuGrade.addText(student.getGrade());
        Dom4jUtil.writeBackToXmL(docPath, document);
    }

    public static void deleteStu(String name) {
        Document document = Dom4jUtil.getDocument(docPath);
        Element rootElement = document.getRootElement();
        List<Node> nameNodes = rootElement.selectNodes("//name");
        for (Node node : nameNodes) {
            if (node.getText().equals(name)) {
                Element stu = node.getParent();
                Element student = stu.getParent();
                student.remove(stu);
            }
        }
        Dom4jUtil.writeBackToXmL(docPath, document);
    }

    public static void queryStu(String name) {
        Document document = Dom4jUtil.getDocument(docPath);
        Element rootElement = document.getRootElement();
        List<Node> nameNodes = rootElement.selectNodes("//name");
        for (Node node : nameNodes) {
            if (node.getText().equals(name)) {
                Element parentNode = node.getParent();
                /*List<Node> nodeList = parentNode.elements();
                for (Node singleNode : nodeList) {
                    System.out.println(singleNode.getText());
                }*/

            }
        }
    }
}
