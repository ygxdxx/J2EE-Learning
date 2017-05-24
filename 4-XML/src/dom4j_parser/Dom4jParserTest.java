package dom4j_parser;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * Created by wangsongyan on 2017/5/24.
 * email: wangsongyan921@163.com
 */
public class Dom4jParserTest {
    public static void main(String[] args) throws Exception {
        /**
         * 1.创建解析器
         * 2.得到document
         * 3.得到根节点
         */
        selectName();
    }

    private static void selectName() throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document  = saxReader.read("/Users/Cortana/IdeaProjects/JavaWeb/4-XML/XMLdemo/student.xml");
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element e : elements) {
            System.out.println(e.getText());
        }
    }
}

