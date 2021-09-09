package t4.c2_2;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class test {
    public static void main(String[] args) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource("asd");
        System.out.println(dataSource.getConnection());
    }
}
