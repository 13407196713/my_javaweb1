package t1;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0 {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("asd");

    public static ComboPooledDataSource getDataSource(){
        return dataSource;
    }
}
