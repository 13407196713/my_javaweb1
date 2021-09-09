package t1;

import java.sql.*;

public class test {
    public static void main(String[] args) {
        try {
            //链接数据库

            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","123456");
            PreparedStatement p = conn.prepareStatement("select * from websites where name=?");
            p.setString(1,"asd"); // 设置参数


            // 获取结果集
            ResultSet rs = p.executeQuery();
            ResultSetMetaData r =p.getMetaData();

            String string="";
            for(int i = 1; i < r.getColumnCount(); i++){
                string += r.getColumnName(i)+" ";
            }
            System.out.println(string);

            while(rs.next()){
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("url")  + "\n");
            }

            rs.close();
            p.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
