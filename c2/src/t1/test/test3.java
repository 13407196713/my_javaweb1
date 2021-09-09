package t1.test;

import org.apache.commons.dbutils.QueryRunner;
import t1.c3p0;

public class test3 {
    public static void main(String[] args) throws Exception {
        QueryRunner queryRunner = new QueryRunner(c3p0.getDataSource());
        String sql = "insert into student(sname, age, course) values(?,?,?)";
        Object[][] p = new Object[5][];
        for (int i = 0;i < 5; i++){
            p[i] = new Object[]{"name"+i,"14"+i, "语文"};
        }
        queryRunner.batch(sql,p);
    }
}
