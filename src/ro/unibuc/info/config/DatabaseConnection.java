package ro.unibuc.info.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

  private static Connection dbConnection;

  private DatabaseConnection() {
  }

  public static Connection getConnection() throws SQLException {
    if(dbConnection==null)
    {
      String url = "jdbc:postgresql://localhost:5432/postgres";
      String username = "postgres";
      String password = "password";
      dbConnection = DriverManager.getConnection(url, username, password);
    }

    return dbConnection;
  }

  public static void closeConnection() throws SQLException {
    if(dbConnection != null || !dbConnection.isClosed()){
      dbConnection.close();
    }
  }
}
