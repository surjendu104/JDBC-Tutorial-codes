import java.sql.*;

public class createTable {
    public static void main(String[] args) {
        try {
            // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection with database
            String url="jdbc:mysql://localhost:3306/jdbc_tutorial";
            String user = "root";
            String password = "RbSp@302241";
            Connection con = DriverManager.getConnection(url, user, password);

            if(con.isClosed()) System.out.println("Connection is closed");
            else System.out.println("Connection is open");

            //crate query
            String query = "create table table1(tId int(20) primary key auto_increment, tName varchar(200) not null , tCity varchar(400))";
            //create statement
            Statement stmt = con.createStatement();
            //excute query
            stmt.executeUpdate(query);
            System.out.println("table crated in database.....");

            //close the connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
