package t2.dao;

import t2.domain.Student;
import t2.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {

    //添加Student
    public boolean insert(Student student){
        boolean flag =false ;
        PreparedStatement pstat = null;
        Connection conn = JDBCUtils.getConnecton();
        String sql ="insert into student(sid,sname,age,course) values(?,?,?,?)";
        try {
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, student.getSid());
            pstat.setString(2, student.getSname());
            pstat.setString(3, student.getAge());
            pstat.setString(4, student.getCourse());
            int num = pstat.executeUpdate();
            if (num>0) {
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn, pstat);
        }
        return flag;
    }

    //更新Student
    public boolean update(Student student){
        boolean flag =false ;
        PreparedStatement pstat = null;
        Connection conn = JDBCUtils.getConnecton();
        String sql ="update student set sname=?,age=?,course=? where sid=? ";
        try {
            pstat = conn.prepareStatement(sql);
            pstat.setInt(4, student.getSid());
            pstat.setString(1, student.getSname());
            pstat.setString(2,  student.getAge());
            pstat.setString(3, student.getCourse());
            int num = pstat.executeUpdate();
            if (num>0) {
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn, pstat);
        }
        return flag;
    }

    //删除Student
    public boolean delete(Student student){
        boolean flag =false ;
        PreparedStatement pstat = null;
        Connection conn = JDBCUtils.getConnecton();
        String sql ="delete from student where sid=?";
        try {
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1,  student.getSid());
            int num = pstat.executeUpdate();
            if (num>0) {
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn, pstat);
        }
        return flag;
    }

    //查询所有Student
    public ArrayList<Student> selectAll(){
        PreparedStatement pstat = null;
        Connection conn = JDBCUtils.getConnecton();
        String sql ="select * from student";
        ArrayList<Student> list = new ArrayList<>();
        try {
            pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery(sql);
            while (rs.next()) {
                Student newStudent = new Student();
                newStudent.setSid(rs.getInt("sid"));
                newStudent.setSname( rs.getString("sname"));
                newStudent.setAge(rs.getString("age"));
                newStudent.setCourse(rs.getString("course"));
                list.add(newStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn, pstat);
        }
        return list;
    }

    //查询单个Student
    public Student selectOne(Student student){
        PreparedStatement pstat = null;
        Connection conn = JDBCUtils.getConnecton();
        String sql ="select * from student where sid = ?  ";
        Student newStudent = new Student();
        try {
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, student.getSid());
            ResultSet rs = pstat.executeQuery();
            while (rs.next()) {
                newStudent.setSid(rs.getInt("sid"));
                newStudent.setSname( rs.getString("sname"));
                newStudent.setAge(rs.getString("age"));
                newStudent.setCourse(rs.getString("course"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn, pstat);
        }
        return newStudent;
    }
}
