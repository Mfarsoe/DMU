import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        try {
            Connection con = dbConn.getConn();
             PreparedStatement statement = con.prepareStatement("SELECT * FROM users");
             ResultSet results = statement.executeQuery();
             while  (results.next()) {
                 int id = results.getInt("id");
                 String name = results.getString("username");
                 String password = results.getString("password");
                 System.out.println(id + " " + name + " " + password);
             }
        } catch (SQLException ex) {
            System.out.println("Error while communicating with the database");
        }

    }
}
