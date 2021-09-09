package t4.c3_2;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class test {
    public static void main(String[] args) throws Exception {

        InputStream is = test.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
        Properties props = new Properties();
        props.load(is);

        DataSource dataSource = BasicDataSourceFactory.createDataSource(props);
        System.out.println(dataSource.getConnection());
    }
}
