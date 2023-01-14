import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.connectionProvider.createConnection;

public class dataManipulationInatabase {
    public static void main(String[] args) {
        Connection con = createConnection.getConnection();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the table name : ");
        String tableName = sc.next();

        // createNewTable.createTable(con,tableName);
        // createNewTable.insertDataIntoTable(con,tableName,"tName","tCity");
        try {
            String q = "update " + tableName + " set tName=? , tCity=? where tId=?";
            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(1, "C");
            pstmt.setString(2, "KOLKATA");
            pstmt.setInt(3, 3);
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error in data manipulating");
        }

        sc.close();
    }
}
