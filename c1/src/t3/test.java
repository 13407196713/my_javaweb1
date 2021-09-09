package t3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String pass = "123456";
        Connection conn = null;
        PreparedStatement p1 = null;
        PreparedStatement p2 = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            conn.setAutoCommit(false); // 关闭自动提交

            // 小明账户减去100
            p1 = conn.prepareStatement("update account  set money = money-100 where name = ?");
            p1.setString(1,"小明");
            p1.executeUpdate();

            // shop 加100
            p2 = conn.prepareStatement("update account  set money = money+100 where name = ?");
            p2.setString(1,"shop");
            p2.executeUpdate();

            // 提交事务
            conn.commit();
            System.out.println("支付完毕");
        } catch (Exception throwables) {
            //有异常回滚
            try {
                conn.rollback();
                System.out.println("支付失败");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            // 释放资源
            if(p1!=null){
                try {
                    p1.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                p1=null;
            }

            if(p2!=null){
                try {
                    p2.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                p2=null;
            }

            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                conn=null;
            }
        }
    }
}
