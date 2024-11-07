

import java.sql.*;

public class dbConn {
    //Method to establishing connection to database
    public static Connection getConn() {
        //Defining the connection string
        String connectionString = //HUSK KUN AT BRUGE EN AF DE EFTERFØLGENDE (MSSQL eller MYSQL)

//MSSQL SERVER       "jdbc:sqlserver://your_hostname:1433;databaseName=your_db_name;user=your_user;password=your_password;trustServerCertificate=true;";

//MYSQL SERVER
                "jdbc:mysql://Server=mysql87.unoeuro.com;Database=mfarsoe_dk_db_bibsys;Uid=mfarsoe_dk;";

        Connection conn = null;
        try {
            //Trying to establish connection
            conn = DriverManager.getConnection(connectionString);

            //Error handling that prints a stacktrace for debugging
        } catch (SQLException e) {
            System.out.println("Could not connect to database: database_name!\n");
            System.out.println(e.getMessage() + "\n STACK TRACE: \n");
            e.printStackTrace();
        }
        return conn;
    }
}