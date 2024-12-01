import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        loadJdbcDriver();
        openConnection("SkoleDB");
    }

    private static boolean loadJdbcDriver() {
        try {
            System.out.println("Loading JDBC driver...");

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            System.out.println("JDBC driver loaded");

            return true;
        }
        catch (ClassNotFoundException e) {
            System.out.println("Could not load JDBC driver!");
            return false;
        }
    }
    private static Connection connection;
    private static boolean openConnection(String databaseName) {
        String connectionString =
                "jdbc:sqlserver://localhost:1433;" +            //Bruger driver til at connecte til local database på port 1433
                        "instanceName=SQLEXPRESS;" +            //Navnet på vores MSSQL server, hvor vores databaser ligger
                        "databaseName=" + databaseName + ";" +  //Navnet på databasen
                        "integratedSecurity=true;" +            //Enabler windows auth i stedet for at man skriver username og password
                        "trustServerCertificate=true;";         //Tillader clienten at den truster serverens SSL certificate uden validering

        connection = null;

        try {
            System.out.println("Connecting to database...");

            connection = DriverManager.getConnection(connectionString);

            System.out.println("Connected to database");

            return true;
        }
        catch (SQLException e) {
            System.out.println("Could not connect to database!");
            System.out.println(e.getMessage());

            return false;
        }
    }



}
