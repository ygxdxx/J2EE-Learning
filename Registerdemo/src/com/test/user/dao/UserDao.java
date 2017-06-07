package com.test.user.dao;

import com.test.user.entity.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by wangsongyan on 2017/6/7.
 * email: wangsongyan921@163.com
 */
public class UserDao {

    private String path = "/Users/Cortana/IdeaProjects/JavaWeb/users.xml";

    /**
     * 通过姓名查找学生对象并返回
     */
    public User findUserByName(String username) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(path);
            Element rootElement = document.getRootElement();
            Element stuElement = (Element) rootElement.selectSingleNode("//user[@username='" + username + "']");
            if (stuElement == null) {
                return null;
            }
            User user = new User();
            user.setUsername(stuElement.attributeValue("username"));
            user.setPassword(stuElement.attributeValue("password"));
            return user;

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将学生对象添加到 xml 中
     */
    public void addUser(User user) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(path);
            Element rootElement = document.getRootElement();
            Element stuElement = rootElement.addElement("user");
            stuElement.addAttribute("username", user.getUsername());
            stuElement.addAttribute("password", user.getPassword());

            //回写
            XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path)), OutputFormat.createPrettyPrint());
            xmlWriter.write(document);
            //关闭流
            xmlWriter.close();
        } catch (DocumentException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
