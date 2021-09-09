package t2.c2;

import java.util.List;

public class test {
    public static void main(String[] args) throws Exception {
        StudentDao studentDao1 = new StudentDao();
        Student student = new Student();
        student.setSid(17);
        student.setSname("小王");
        student.setAge(14);
        student.setCourse("生物");
        int f = studentDao1.insert(student); //增
        if(f>0)
            System.out.println("插入成功");
        else
            System.out.println("插入失败");

        f = studentDao1.delete(student); // 删
        if(f>0)
            System.out.println("删除成功");
        else
            System.out.println("删除失败");

        studentDao1.insert(student); // 增
        student.setAge(10);
        f = studentDao1.update(student); // 改
        if(f>0)
            System.out.println("修改成功");
        else
            System.out.println("修改失败");

        Student student1 = studentDao1.selectOne(17); // 单查
        System.out.println(student1 +"\n");

        List<Student> list = studentDao1.selectAll();
        for (Student student2 : list){
            System.out.println(student2.toString());
        }
    }
}
