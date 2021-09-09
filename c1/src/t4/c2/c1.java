package t4.c2;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c1 {
    public static void main(String[] args) throws Exception{

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // 基本设置
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/student");
        dataSource.setUser("root");
        dataSource.setPassword("123456");

        // 初始连接数10
        dataSource.setInitialPoolSize(10);
        // 最大连接数 20
        dataSource.setMaxPoolSize(20);
        //最小连接数3
        dataSource.setMinPoolSize(3);
        // 每次创建的连接数3
        dataSource.setAcquireIncrement(3);

        System.out.println(dataSource.getConnection());
    }
}
