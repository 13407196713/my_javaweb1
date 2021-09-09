package t1;

import java.sql.*;

public class t2 {
    public static void main(String[] args) {
        try {
            //链接数据库

            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","123456");
            Statement s = conn.createStatement();

            // 获取结果集
            ResultSet rs = s.executeQuery("select * from websites");
            ResultSetMetaData r =rs.getMetaData();

            String string="";
            for(int i = 1; i < r.getColumnCount(); i++){
                string += r.getColumnName(i)+" ";
            }
            System.out.println(string);

            while(rs.next()){
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("url")  + "\n");
            }

            rs.close();
            s.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
