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
		// Load Driver
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
					"dgomez_team6", "1qa2ws3ed");
		} catch (SQLException e) {
			System.err.println("Failed to establish connection to database");
		}
	}

	/**
	 * Must establish connection before attempting to query the database.
	 * 
	 * @param query
	 *            , The desired query in the form of a String.
	 * @return ResultSet resulting from the given query
	 */
	public static ResultSet query(String query) {
		if (connection == null)
			System.err.println("Connection not initialized.");
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

	public static void closeStatement() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	 
  public static void addPassenger(){}
  
  public static void cancelBooking(){}
  
  public static void createUser(Sting firstName, String lastName, sSring email,String phone,){}
  
  public static void deleteUser(){}
  
  public static void cancelFlight(){}
  
  public static void delayFlight(){}
  
  public static void addLuggage(){}
  
  public static void removeLuggage(){}
  
  public static void addAirport(){}
  
  public static void addEmployee(){}
  
  public static void removeEmployee(){}
  /**
   * Prints a list of contact information for all passengers of a flight.
   * @param type
   *            ,delay, cancelation, unique message
   * @param flightID
   *            ,unique identifier for the flight
   */
  public static void notification(String type, int flightID){
    resultSet = statement.executeQuery(""
        + " SELECT method_of_notification FROM Passengers "
        + " JOIN Itineraries"
        + " ON  Passengers.itinerary_id=Itineraries.id"
        + " where flight_list like '%,"+flightID+",%'");
    
   while (resultSet.next()) {
    System.out.println(resultSet.getString(1));
    /*todo: add parsing for phone numbers vs email, 
     *      send messages
     *      notifications off option
     * */
    }
  }
	
	/**
	 * Create a new flight to be added to the schedule.
	 * This function must be called when a connection is already open.
	 * @param flight_id
	 *            ,unique identifier for each flight.
	 * @param plane_id
	 *            , plane assigned to this flight
	 * @param flight_number
	 *            , number associated with the schedule of this flight
	 * @param departureAirport
	 *            , airport code of departure airport
	 * @param arrivalAirport
	 *            , airport code of the arrival airport
	 * @param departureTime
	 *            , format: yyyy-mm-dd hh:mm:ss
	 * @param arrivalTime
	 *            , format: yyyy-mm-dd hh:mm:ss
	 * @param freeSeats
	 *            , number of seats available
	 * @param departureGate
	 * @param arrivalGate
	 * @param status
	 *            , on_time, delayed, or canceled
	 * @param currentPrice
	 *            , base price
	 * @throws SQLException
	 */
	private static void enterNewFlight(int flight_id, int plane_id,
			String flight_number, String departureAirport,
			String arrivalAirport, String departureTime, String arrivalTime,
			int freeSeats, String departureGate, String arrivalGate,
			String status, double currentPrice) throws SQLException {

		String instructions = "INSERT INTO Flights " + "VALUES (" + flight_id
				+ "," + plane_id + ",'" + flight_number + "','"
				+ departureAirport + "','" + arrivalAirport + "','"
				+ departureTime + "','" + arrivalTime + "'," + freeSeats + ",'"
				+ departureGate + "','" + arrivalGate + "','" + status + "',"
				+ currentPrice + ")";

		System.out.println("submitting new flight");
		Database.statement.executeUpdate(instructions);
		System.out.println("new flight created");
	}
	
	private static void book(int flight_id, int passenger_id,
			String seat) throws SQLException {

		//concatinate the flight number on to the flight_list of the itinerary associated with 
		//a given passenger
		
		
		//checks to make sure that there are enough flights available.
		String query = "SELECT seats_available FROM Flights "
				+ "WHERE flight_id="+flight_id;
		resultSet=Database.query(query);
		
		if(resultSet.next()){
			System.out.println(resultSet.getInt(1));
			if (resultSet.getInt(1)<=0){return;}
			
		
		
		
		String flightInstructions = "UPDATE Flights "
				+ "SET Flights.seats_available=Flights.seats_available-1 "
				+ " WHERE Flights.flight_id=" + flight_id;
		
		Database.statement.executeUpdate(flightInstructions);
		
		
		String passengerInstructions = "UPDATE Passengers "
				+ "JOIN Itineraries ON Passengers.itinerary_id=Itineraries.id "
				+ "SET Itineraries.flight_list=Concat(Itineraries.flight_list,'"
				+ flight_id + ",')" + " WHERE Passengers.id=" + passenger_id;

		System.out.println(passengerInstructions);
		Database.statement.executeUpdate(passengerInstructions);
		}

	}

	public static void addPassenger(){}
	
	public static void main(String args[]) {
		Database.connect();

		String query = "SELECT depart.flight_number as d_flight_number,"
				+ "       depart.depart_time as d_depart_time,"
				+ "       depart.arrive_time as d_arrive_time, "
				+ "       arrive.flight_number as a_flight_number,"
				+ "       arrive.depart_time as a_depart_time,"
				+ "       arrive.arrive_time as a_arrive_time"
				+ "  FROM Flights_OLD depart, Flights_OLD arrive"
				+ " WHERE lower(depart.depart_location) = '"
				+ "abq"
				+ "'"
				+ "   AND lower(depart.arrive_location) = '"
				+ "hou"
				+ "'"
				+ "   AND       depart.depart_time      = '"
				+ "00:01"
				+ "'"
				+ "  AND depart.arrive_location = arrive.depart_location"
				+ "  AND depart.depart_location = arrive.arrive_location"
				+ "  AND depart.id <> arrive.id"
				+ "  AND STR_TO_DATE(depart.arrive_time, \"%H:%i\") < STR_TO_DATE(arrive.depart_time, \"%H:%i\")"
				+ "  AND depart.total_seats > depart.seats_taken"
				+ "  AND arrive.total_seats > arrive.seats_taken;  ";

		// String query = "select * from Flights_OLD";

		ResultSet rs = Database.query(query);

		System.out.println("reading query");
		try {
			while (rs.next()) {
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
