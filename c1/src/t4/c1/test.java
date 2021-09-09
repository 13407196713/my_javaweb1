package t4.c1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test {
    public static void main(String[] args) {
        for(int j = 0;j < 5;j++){
            try {
                Connection connection = t.getConnection();
                PreparedStatement p = connection.prepareStatement("select * from account");

                ResultSet rs = p.executeQuery();
                while(rs.next()){
                    System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("money")  + "\n");
                }
                System.out.println("\n");

                rs.close();
                p.close();
                t.release(connection);

            } catch (Exception throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
