package t2.c2;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import t2.c3p0Utils;

import java.util.List;

public class StudentDao {
    //增
    public int insert(Student stu) throws Exception{
        QueryRunner queryRunner = new QueryRunner(c3p0Utils.getDataSource());
        String sql ="insert into student(sname,age,course) values(?,?,?)";
        Object[] params = new Object[]{stu.getSname(),stu.getAge(),stu.getCourse()};
        int count = queryRunner.update(sql,params);
        return count;
    }

    //改
    public int update(Student stu) throws Exception{
        QueryRunner queryRunner = new QueryRunner(c3p0Utils.getDataSource());
        String sql ="update student set age= ? and course = ? where sname=?";
        Object[] params = new Object[]{ stu.getAge(),stu.getCourse(), stu.getSname()};
        int count = queryRunner.update(sql,params);
        return count;
    }

    //删
    public int delete(Student stu) throws Exception{
        QueryRunner queryRunner = new QueryRunner(c3p0Utils.getDataSource());
        String sql ="delete from student where sname= ?";
        Object[] params = new Object[]{stu.getSname()};
        int count = queryRunner.update(sql,params);
        return count;
    }

    // 单查
    public Student selectOne(Integer id) throws Exception{
        QueryRunner queryRunner = new QueryRunner(c3p0Utils.getDataSource());
        String sql ="select * from student where sid= ?";
        Object[] params = new Object[]{id};
        Student newStu = queryRunner.query(sql, new BeanHandler<>(Student.class),params);
        return newStu;
    }

    // 多查
    public List<Student> selectAll() throws Exception{
        QueryRunner queryRunner = new QueryRunner(c3p0Utils.getDataSource());
        String sql ="select * from student";
        List<Student> list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
        return list;
    }
}
