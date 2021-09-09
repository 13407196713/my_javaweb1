package t4.c1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

public class t {
    private static LinkedList<Connection> pool = new LinkedList<Connection>();

    static {
        // 3个链接
        try {
            String url = "jdbc:mysql://localhost:3306/student";
            String user = "root";
            String pass = "123456";
            for(int i = 0; i < 3; i++){
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, user, pass);
                pool.add(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取链接
    public static Connection getConnection(){
        return pool.removeFirst();
    }

    // 链接放回池中
    public static void release(Connection connection){
        if (connection!=null){
            pool.add(connection);
        }
    }

}
