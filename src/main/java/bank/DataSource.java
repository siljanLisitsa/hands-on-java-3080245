package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {
  public static Connection connect() {
    String db_file = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;

    try {
      connection = DriverManager.getConnection(db_file);
      System.out.println("We're connected.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }//end of connect()

  public static Customer getCustomer(String username) {
    String sql = "SELECT * FROM CUSTOMERS WHERE USERNAME = ?";
    try(Connection connection = connect()) {
      PreparedStatement statement = connection.prepareStatement(sql){
        statement.setString(1, username);
        try(ResultSet resultSet = statement.executeQuery(){
          statement.executeQuery();
        }
      }
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    connect();
  }
}
