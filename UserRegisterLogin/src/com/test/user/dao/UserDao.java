package com.test.user.dao;

import com.test.user.entity.User;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by wangsongyan on 2017/6/5.
 * email: wangsongyan921@163.com
 */
public class UserDao {

    private String path = "/Users/Cortana/IdeaProjects/JavaWeb/users.xml";

    public User findUserByName(String username) {
        System.out.println("进入测试");
        //1.得到 document
        //2.查询
        //  (1) 如果结果为 null,返回 null
        //  (2) 如果结果不为 null,需要把 Element 封装到User 对象中
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(path);
            System.out.println(document);
            Element element = (Element) document.selectSingleNode("//user[@username='" + username + "']");
            if (element == null) {
                return null;
            }
            User user = new User();
            String name = element.attributeValue("username");
            String password = element.attributeValue("password");
            user.setName(name);
            user.setPassword(password);
            return user;

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(User user) {
        //1.得到 document
        //2.把 user 转换为 Element
        //3.把 element 添加到root 元素中
        //4.保存 Document
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(path);
            Element root = document.getRootElement();
            Element userEle = root.addElement("user");
            userEle.addAttribute("username", user.getName());
            userEle.addAttribute("password", user.getPassword());

            XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"),OutputFormat.createPrettyPrint());
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
