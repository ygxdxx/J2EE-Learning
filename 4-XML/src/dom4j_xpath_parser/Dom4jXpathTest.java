package dom4j_xpath_parser;

import dom4j_util.Dom4jUtil;
import org.dom4j.Document;
import org.dom4j.Node;

import java.util.List;

/**
 * Created by wangsongyan on 2017/5/26.
 * email: wangsongyan921@163.com
 */
public class Dom4jXpathTest {

    private static final String docPath = "/Users/Cortana/IdeaProjects/JavaWeb/4-XML/XMLdemo/student.xml";

    public static void main(String[] args) {
        //getAllNameValue();
        getFirstNameValue();
    }

    /**
     * get value of name of first student
     */
    private static void getFirstNameValue() {
        Document document = Dom4jUtil.getDocument(docPath);
        Node node = document.selectSingleNode("//s[@id='xiaoming']/name");
        System.out.println(node.getText());
    }

    /**
     * get values of name
     */
    private static void getAllNameValue() {
        Document document = Dom4jUtil.getDocument(docPath);
        List<Node> nodeList = document.selectNodes("//name");
        for (Node node : nodeList) {
            String name = node.getText();
            System.out.println(name);
        }
    }
}
