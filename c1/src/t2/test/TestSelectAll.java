package t2.test;

import t2.dao.StudentDao;
import t2.domain.Student;

import java.util.ArrayList;

public class TestSelectAll {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        ArrayList<Student> list = studentDao.selectAll();
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }
}
