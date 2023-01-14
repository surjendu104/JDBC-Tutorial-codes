import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.connectionProvider.createConnection;

public class insertLargeImageToDB {
    public static void main(final String[] args) {
        try {
            final Connection con = createConnection.getConnection();
            final String tableCreationQuery = "create table Image_data(ID int(100) primary key auto_increment, image longblob)";
            final Statement smt = con.createStatement();
            smt.executeUpdate(tableCreationQuery);

            //insert long image start from here
            final String query = "insert into Image_data(image) value(?)";

            final PreparedStatement pstmt = con.prepareStatement(query);

            // pstmt.setBinaryStream(1);

            final JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            final File file = jfc.getSelectedFile();
            final FileInputStream fis = new FileInputStream(file);

            pstmt.setBinaryStream(1, fis,fis.available());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sucess");
        } catch (final Exception e) {
            e.printStackTrace();
        }

    }
}
