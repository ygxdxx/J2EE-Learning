package dom4j_util;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/5/26.
 * email: wangsongyan921@163.com
 */
public class Dom4jUtil {

    public static Document getDocument(String docPath) {
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(docPath);
            return document;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeBackToXmL(String docPath, Document document) {
        try {
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(docPath), OutputFormat.createPrettyPrint());
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
