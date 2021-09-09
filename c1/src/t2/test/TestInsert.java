package t2.test;

import t2.dao.StudentDao;
import t2.domain.Student;

public class TestInsert {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        Student student = new Student();
        student.setSid(1);
        student.setSname("sunqi1");
        student.setAge("24");
        student.setCourse("Python");
        studentDao.insert(student);
    }
}
