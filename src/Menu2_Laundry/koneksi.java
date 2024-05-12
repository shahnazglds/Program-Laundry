package Menu2_Laundry;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

public class koneksi {
    private String url="jdbc:mysql://localhost/laundry_uas";
    private String username = "root";
    private String password = "123";
    private Connection con;
    
    
    public void connect(){
       try{
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection(url, username, password);
           System.out.println("Koneksi Berhasil");
       }catch(Exception e){
           JOptionPane.showMessageDialog(null," koneksi gagal\n" + e.getMessage());   
       }
    }
    public Connection getCon(){
          return con;
      }    
}
