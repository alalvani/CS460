package Database;

import java.sql.*;

/**
 * Created by kourpa on 3/13/15.
 *
 */
public class Database {
  private static Connection connection;
  private static Statement statement;
  private static ResultSet resultSet;

  public static void connect() {

    try {
      if(connection != null && !connection.isClosed()){
        System.out.println("Connection already established.");
        return;
      }
    } catch (SQLException ignored) {
    }

    //Load Driver
    try {
      System.out.println("Loading Driver.");
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.err.println("failled to load SQL Driver.");
      return;
    }

    // Establish Connection
    try {
      System.out.println("establishing connection");
      connection = DriverManager.getConnection(
          "jdbc:mysql://192.254.189.198/dgomez_airexpress",
          "dgomez_team6",
          "1qa2ws3ed");
    } catch (SQLException e) {
      System.err.println("Failed to establish connection to database");
    }
  }

  /**
   * Must establish connection before attempting to query the database.
   * Make sure to properly close the connection with
   * resultSet.getStatement().close()
   *
   * @param query, The desired query in the form of a String.
   * @return ResultSet resulting from the given query
   */
  public static ResultSet query(String query){
    Statement statement;
    ResultSet resultSet;

    if(connection == null) System.err.println("Connection not initialized.");
    else {

      boolean connectionClosed = true;

      try {
        connectionClosed = connection.isClosed();
      } catch (SQLException ignored) {
      }

      if (connectionClosed) {
        System.err.println("Connection Closed.");
        return null;
      }
    }

    try {
      statement = connection.createStatement();
    } catch (SQLException e) {
      System.err.println("Failed to create statement.");
      return null;
    }

    try {
      resultSet = statement.executeQuery(query);
    } catch (SQLException e) {
      System.err.println("Failed to execute query: " + query);
      return null;
    }

    return resultSet;
  }

  /**
   * DO NOT USE.
   * Instead use to avoid mysql concurrency issues and close the statement cleanly
   * resultSet.getStatement().close()
   */
  @Deprecated
  public static void closeStatement(){
    try {
      if(resultSet != null) resultSet.close();
      if(statement != null) statement.close();
    } catch (SQLException e) {
      System.out.println("Something went wrong, and you shouldn't be using this method anymore anyways.");
    }

  }

  public static void closeConnection(){
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void main(String args[]){
    Database.connect();

    String query ="SELECT depart.flight_number as d_flight_number,"+
        "       depart.depart_time as d_depart_time,"+
        "       depart.arrive_time as d_arrive_time, "+
        "       arrive.flight_number as a_flight_number,"+
        "       arrive.depart_time as a_depart_time,"+
        "       arrive.arrive_time as a_arrive_time"+
        "  FROM Flights_OLD depart, Flights_OLD arrive"+
        " WHERE lower(depart.depart_location) = '" + "abq" + "'"+
        "   AND lower(depart.arrive_location) = '" + "hou" + "'"+
        "   AND       depart.depart_time      = '" + "00:01" + "'"+
        "  AND depart.arrive_location = arrive.depart_location"+
        "  AND depart.depart_location = arrive.arrive_location"+
        "  AND depart.id <> arrive.id"+
        "  AND STR_TO_DATE(depart.arrive_time, \"%H:%i\") < STR_TO_DATE(arrive.depart_time, \"%H:%i\")"+
        "  AND depart.total_seats > depart.seats_taken"+
        "  AND arrive.total_seats > arrive.seats_taken;  ";

//    String query = "select * from Flights_OLD";

    ResultSet rs = Database.query(query);

    System.out.println("reading query");
    try {
      while(rs.next()){
        String a_id = rs.getString("a_flight_number");
        String d_id = rs.getString("d_flight_number");
        System.out.println(a_id + " " + d_id);
      }
    } catch (SQLException ignored) {
      System.out.println("Reading data failed");
    }

    Database.closeStatement();
    Database.closeConnection();
  }
}
