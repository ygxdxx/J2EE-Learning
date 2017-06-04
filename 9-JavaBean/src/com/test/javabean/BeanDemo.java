package com.test.javabean;

import com.test.util.CommonUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangsongyan on 2017/6/4.
 * email: wangsongyan921@163.com
 */
public class BeanDemo {

    @Test
    public void testBean() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        String path = "com.test.javabean.Student";
        Class s = Class.forName(path);
        Object obj = s.newInstance();

        BeanUtils.setProperty(obj, "name", "小明");
        BeanUtils.setProperty(obj, "age", "24");
        BeanUtils.setProperty(obj, "grade", "99");

        String age = BeanUtils.getProperty(obj, "age");

        System.out.println(obj);
        System.out.println(age);
    }

    @Test
    public void testBean2() throws InvocationTargetException, IllegalAccessException {

        Student student = new Student();

        Map<String, String> map = new HashMap<>();
        map.put("name", "小红");
        map.put("age", "24");
        map.put("grade", "99");

        BeanUtils.populate(student, map);

        System.out.println(student);
    }

    @Test
    public void testBean3() {

        Map<String, String> map = new HashMap<>();
        map.put("name", "小红");
        map.put("age", "24");
        map.put("grade", "99");

        Student student = CommonUtils.getBean(map, Student.class);
        System.out.println(student);
    }
}
