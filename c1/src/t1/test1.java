package t1;

import java.sql.*;

public class test1 {
    public static void main(String[] args) {
        try {
            //链接数据库

            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","123456");
            PreparedStatement p = conn.prepareStatement("insert into websites(name, url, alexa, country) values (?,?,?,?)");
            for (int i = 0; i < 3;i++){
                p.setString(1,"name"+i); // 设置参数
                p.setString(2,"www."+("name"+i) + ".com");
                p.setString(3,"30"+i);
                p.setString(4,"中国");
                p.addBatch();//加入批处理
                if((i+1)%10==0){
                    p.executeBatch();
                    p.clearParameters();
                }
            }
            p.executeBatch(); // 执行剩余的语句

            p = conn.prepareStatement("select * from websites");
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
