package t2.test;

import t2.dao.StudentDao;
import t2.domain.Student;

public class TestSelectOne {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        Student student = new Student();
        student.setSid(1);
        Student findStudent = studentDao.selectOne(student);
        System.out.println(findStudent.toString());
    }
}
