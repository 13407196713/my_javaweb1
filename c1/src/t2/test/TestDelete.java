package t2.test;

import t2.dao.StudentDao;
import t2.domain.Student;

public class TestDelete {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        Student student = new Student();
        student.setSid(10);
        studentDao.delete(student);
    }
}
