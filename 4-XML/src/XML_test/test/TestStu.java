package XML_test.test;

import XML_test.service.StudentService;
import XML_test.vo.Student;

/**
 * Created by wangsongyan on 2017/5/26.
 * email: wangsongyan921@163.com
 */
public class TestStu {

    public static void main(String[] args) {
        //testAdd();
        //testDel();
        testQuery();
    }

    private static void testAdd() {
        Student student = new Student();
        student.setName("小丸子");
        student.setAge("6");
        student.setGrade("A003");
        StudentService.addStu(student);
    }

    private static void testDel(){
        StudentService.deleteStu("小明");
    }

    private static void testQuery(){
        StudentService.queryStu("小丸子");
    }
}
