import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class insertIntoTable {
    // Insert data into table using PreparedStatement
    public static void main(String[] args) {
        try {
            // Object of scanner class
            Scanner sc = new Scanner(System.in);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_tutorial", "root",
                    "RbSp@302241");

            // crate query
            String query = "insert into table1(tName,tCity) values(?,?)";
            // get the PreparedStatementObject
            PreparedStatement pstmt = con.prepareStatement(query);

            // set the value to query
            // pstmt.setString(1, "Surjendu Pal");
            // pstmt.setString(2, "Kolkata");

            System.out.println("Enter the number of user to enter : ");
            int n = sc.nextInt();
            ArrayList<String> userName = new ArrayList<>();
            ArrayList<String> userCity = new ArrayList<>();

            System.out.println(String.format("Enter the %d names...", n));
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                userName.add(i, name);
            }

            System.out.println(String.format("Enter the %d cities...", n));
            for (int i = 0; i < n; i++) {
                String city = sc.next();
                userCity.add(i, city);
            }

            for (int i = 0; i < n; i++) {
                pstmt.setString(1, userName.get(i));
                pstmt.setString(2, userCity.get(i));
                // execute query
                pstmt.executeUpdate();
            }

            //close connection
            con.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
