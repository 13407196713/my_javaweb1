package t2;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class c3p0Utils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("asd");

    public static ComboPooledDataSource getDataSource(){
        return dataSource;
    }

    //创建一个ThreadLocal对象，以当前线程作为key
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    //提供当前线程中的Connection
    public static Connection getConnection() throws Exception {
        Connection conn = threadLocal.get();
        if (null==conn) {
            conn  = dataSource.getConnection();
            threadLocal.set(conn); // conn 设置为当前线程的数据库链接
        }
        return conn;
    }

    //开启事务
    public static void startTransaction() throws Exception {
        //首先获取当前线程的连接
        try {
            Connection 	conn = getConnection();
            //关闭事务自动提交
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务
    public static void commit(){
        //首先获取当前线程的连接
        Connection conn = threadLocal.get();;
        if(null!= conn){
            //提交事务
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //回滚事务
    public static void rollback(){
        //首先获取当前线程的连接
        Connection conn = threadLocal.get();;
        if(null!= conn){
            //回滚事务
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //关闭连接
    public static void close(){
        Connection conn = threadLocal.get();
        if(null!= conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                threadLocal.remove();//从当前线程移除连接,造成内存泄漏
                conn =null;
            }
        }
    }
}
