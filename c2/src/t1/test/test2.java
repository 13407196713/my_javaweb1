package t1.test;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import t1.c3p0;

import java.util.List;
import java.util.Map;

public class test2 {
    public static void main(String[] args) throws Exception {
        QueryRunner queryRunner = new QueryRunner(c3p0.getDataSource());

        //ArrayHandler 单查 Object
        String sql1 = "select * from student where sid=?";
        Object[] arr = queryRunner.query(sql1, new ArrayHandler(), new Object[]{1});
        // new ArrayHandler()为结果集 Object[]类型
        // new Object[]{1} 为sql参数
        for (int i=0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");

        //ArrayListHandler 多查  List<Object[]>
        String sql2 = "select * from student";
        List<Object[]> list = queryRunner.query(sql2, new ArrayListHandler());
        // new ArrayListHandler()为结果集 List类型
        for (Object[] a:list){
            for (int i=0; i < a.length; i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }
        System.out.println();

        //BeanHandler 单查 Student
        String sql3 = "select * from student where sid=?";
        Student student= queryRunner.query(sql3, new BeanHandler<>(Student.class), new Object[]{1});
        // new BeanHandler()为结果集 Student类型
        // new Object[]{1} 为sql参数
        System.out.println(student.toString());
        System.out.println();

        //BeanListHandler 多查 List<Student>
        String sql4 = "select * from student";
        List<Student> list4 = queryRunner.query(sql2, new BeanListHandler<Student>(Student.class));
        // new BeanListHandler()为结果集 List类型
        for (Student student1:list4){
            System.out.println(student1.toString());
        }
        System.out.println();


        //MapHandler 单查 Map<String, Object>
        String sql5 = "select * from student where sid=?";
        Map<String, Object> map = queryRunner.query(sql3, new MapHandler(), new Object[]{1});
        // new MapHandler()为结果集 Student类型
        // new Object[]{1} 为sql参数
        System.out.println(map);
        System.out.println();

        // MapListHandler 多查 List<Map<String, Object>>
        String sql6 = "select * from student";
        List<Map<String, Object>> list6 = queryRunner.query(sql2, new MapListHandler());
        // new MapListHandler()为结果集 List<Map<String, Object>>类型
        for (Map<String, Object> map1: list6){
            System.out.println(map1);
        }
        System.out.println();

        // KeyedHandler 多查
        String sql7 = "select * from student";
        Map<Object,Map<String, Object>> map1 = queryRunner.query(sql2, new KeyedHandler<Object>("sid"));
        // new KeyedHandler()为结果集 Map<Object,Map<String, Object>>类型
        Map<String, Object> map2 = map1.get(1);
        System.out.print(map2.get("sname") + " ");
        System.out.println(map2.get("age"));
        System.out.println();


        // 查询列 ColumnListHandler
        String sql8 = "select * from student";
        List<Object> list8 = queryRunner.query(sql2, new ColumnListHandler<>("sname"));
        // new KeyedHandler()为结果集 Map<Object,Map<String, Object>>类型
        System.out.println(list8);
        System.out.println();

        // ScalarHandler
        String sql9 = "select * from student where sid=?";
        String name = (String) queryRunner.query(sql9, new ScalarHandler("sname"), new Object[]{1});
        // new KeyedHandler()为结果集 Map<Object,Map<String, Object>>类型
        System.out.println(name);

    }
}
