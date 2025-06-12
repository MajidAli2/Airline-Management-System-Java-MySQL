package airlinemanagementsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDBMS {
    public static Connection c;
    public static Statement s;
    public static void main(String[] args) {

    }
    public ConnectionDBMS() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/airlinemanagementsystem";
            String username = "root";
            String password = "majid123@#$&*";
            c = DriverManager.getConnection(url, username, password);
            s=c.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }
}
