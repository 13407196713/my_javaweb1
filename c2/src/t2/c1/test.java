package t2.c1;

import org.apache.commons.dbutils.QueryRunner;
import t2.c3p0Utils;
import java.sql.Connection;

public class test {
    public static void main(String[] args) {
        Connection conn = null;
        try{
            // 开启事务
            c3p0Utils.startTransaction();
            conn = c3p0Utils.getConnection();
            QueryRunner queryRunner = new QueryRunner();

            //小明减去100
            String sql1 = "update account set money = money-? where name=?";
            queryRunner.update(conn, sql1, new Object[]{100,"小明"});

            // shop加100
            String sql2 = "update account set money = money+? where name=?";
            queryRunner.update(conn, sql2, new Object[]{100,"shop"});

            // 提交事务
            conn.commit();
            System.out.println("支付完毕");
        } catch (Exception throwables) {
            try{
                conn.rollback();//回滚
            } catch (Exception e) {
                e.printStackTrace();
            }
        }finally {
            c3p0Utils.close();// 释放资源
        }

    }
}
