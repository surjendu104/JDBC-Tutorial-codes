import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class insertImageToDB {
    public static void main(String[] args) {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_tutorial", "root", "root");

        String query = "create table Image_data(tId int(20) primary key auto_increment, image blob)";

        Statement stmt = con.createStatement();
        stmt.executeUpdate(query);
        
        String q = "insert into Image_data(image) values(?)";
        PreparedStatement pstmt = con.prepareStatement(q);
        FileInputStream fis = new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\fig ans\\sn-10 d-10 g-100 -4.png");
        pstmt.setBinaryStream(1, fis,fis.available());
        pstmt.executeUpdate();
        con.close();
        System.out.println("Connecton closed......");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
