import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.connectionProvider.createConnection;

public class selectDataFromTable {
    public static void main(String[] args) {
        try {
            Connection con = createConnection.getConnection();

            String query = "select * from userdata";
            // carete statement
            Statement smt = con.createStatement();
            // execute the query and save it in the result
            ResultSet set = smt.executeQuery(query);

            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);

                System.out.println(id + " | " + name + " | " + city);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
