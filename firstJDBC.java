import java.sql.*;

class firstJDBC {
    public static void main(String[] args) {
        try {
            // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection with database
            String url="jdbc:mysql://localhost:3306/jdbc_tutorial";
            String user = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, user, password);

            if(con.isClosed()) System.out.println("Connection is closed");
            else System.out.println("Connection is open");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}