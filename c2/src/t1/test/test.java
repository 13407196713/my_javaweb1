package t1.test;

import org.apache.commons.dbutils.QueryRunner;
import t1.c3p0;

public class test {

    public static void main(String[] args) throws Exception {
        QueryRunner queryRunner = new QueryRunner(c3p0.getDataSource());

        // 插入数据
        String sql = "insert into student(sname, age, course) values('小明','15','英语')";
        int f = queryRunner.update(sql);
        if(f>0){
            System.out.println("数据添加成功");
        }else {
            System.out.println("数据添加失败");
        }

        // 改数据
        String sql2 = "update student set age = 20 where sname='小明'";
        int f2 = queryRunner.update(sql2);
        if(f2>0){
            System.out.println("数据修改成功");
        }else {
            System.out.println("数据修改失败");
        }

        // 删除数据
        String sql3 = "delete from student  where sname='小明'";
        int f3 = queryRunner.update(sql3);
        if(f3>0){
            System.out.println("数据删除成功");
        }else {
            System.out.println("数据删除失败");
        }
    }
}
