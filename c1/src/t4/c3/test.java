package t4.c3;

import org.apache.commons.dbcp.BasicDataSource;

public class test {
    public static void main(String[] args) throws Exception {
        BasicDataSource dataSource = new BasicDataSource();

        // 基本设置
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/student");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // 其他设置
        dataSource.setInitialSize(10);
        dataSource.setMaxIdle(20);
        dataSource.setMinIdle(3);
        dataSource.setMaxActive(15);
        System.out.println(dataSource.getConnection());
    }
}
