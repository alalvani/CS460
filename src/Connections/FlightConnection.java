package Connections;

import Database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Danny
 *
 */
public class FlightConnection {

	final boolean DEBUG = false;
	
	String startingAirport = "ABQ"; 
	String destinationAirport = "FLA";
	int seatsNeeded = 2;

	//initialize open and closed lists
	ArrayList<FlightNode> openList = new ArrayList<FlightNode>();
	ArrayList<FlightNode> closedList = new ArrayList<FlightNode>();

	public FlightConnection(){

		//establish connection to database
		Database.connect();

		//initialize source node
		FlightNode sourceNode = new FlightNode();
		sourceNode.setAirport(startingAirport);
		
		//debug print source node
		if(DEBUG){
			System.out.println("\nSOURCE NODE");
			System.out.println(sourceNode.toString());
		}
		
		//insert source node into open list
		openList.add(sourceNode);

		//node with the smallest f in open list
		FlightNode nodeMinF; //q
		int indexMinF; // index of nodeMinF


		//list of successors of nodeMinF
		ArrayList<FlightNode> successors = new ArrayList<FlightNode>();


		//while the open list is not empty
		while(openList.size() > 0){

			//find the node with the smallest f in the open list

			//grab the first node in the open list to seed the nodeMinF
			nodeMinF = openList.get(0);
			indexMinF = 0;

			//go through the rest of the nodes in the open list
			for (int i = 1; i < openList.size(); i++){

				//check if the f of the node is smaller than the current smallest f node
				if(openList.get(i).getF() < nodeMinF.getF()){

					//update smallest f node index
					nodeMinF = openList.get(i);
					indexMinF = i;
				}
			}

			//node with the smallest f in the open list has been found

			//remove it from the open list
			openList.remove(indexMinF);

			//generate successors of node at indexMinF
			successors = GenerateSuccessors(nodeMinF);

			
			//for each successor
			for (FlightNode s:successors){

				
				//if this successor is the goal, stop search
				if(s.getAirport().equals(destinationAirport)){
					System.out.println("\nPath Found");
					printPath(s);
					break;
				}

				//update successor travel time (g) - already did this in generate successors method

				//update successor heuristic (might not need to do this) - no heuristic atm

				//for all nodes in the open list
				for (FlightNode n:openList){
				//if there is a node with the same airport as the successor
					if(n.getAirport().equals(s.getAirport())){
						//and if that node has a lower f than the successor
						if(n.getF() < s.getF()){
							//skip this successor
							continue;
						}
					}
				}

				//for all nodes in the closed list
				for (FlightNode n:closedList){
				//if there is a node with the same airport as the successor
					if(n.getAirport().equals(s.getAirport())){
						//if that node has a lower f than the successor
						if(n.getF() < s.getF()){
							//skip this successor
							continue;
						}
					}
				}

				//otherwise, add the successor to the open list
				openList.add(s);
			}

			//push nodeMinF (q) to the closed list
			closedList.add(nodeMinF);
		}

		
		//print path
		for (FlightNode n:closedList){
			n.toString();
		}
		
		Database.closeStatement();
		Database.closeConnection();

	}




	/**
	 * @param q
	 * @return
	 */
	ArrayList<FlightNode> GenerateSuccessors(FlightNode q){
		
		//System.err.println("\nGENERATING SUCCESSORS FOR\n" + q.toString());

		ArrayList<FlightNode> successors = new ArrayList<FlightNode>();

		//get the airport we're departing from
		String departAirport = q.getAirport();

		//build the query
		String query = "SELECT * FROM Flights WHERE departure_airport = '" + departAirport + "'";
		
		
		try {

			//execute query
			ResultSet rs = Database.query(query);
			
			//go through the results
			while(rs.next()){

				//calculate travel time

				long layover = rs.getTimestamp("departure_time").getTime() - q.getArrivalTime();

				
				
				//we do not consider flights with as negative layover
				if(layover <= 0){
					System.out.println("layover fail");
					continue;
				}

				
				
				long flightLength = rs.getTimestamp("arrival_time").getTime() - rs.getTimestamp("departure_time").getTime();



				//build a flight node 
				FlightNode n = new FlightNode();

				//set the flight number
				n.setFlightTaken(rs.getInt("flight_id"));

				//set the airport
				n.setAirport(rs.getString("arrival_airport"));



				//set the travel time
				n.setTravelTime(q.getTravelTime() + layover + flightLength);
				
				//set arrival time
				n.setArrivalTime(rs.getTimestamp("arrival_time").getTime());
				
				//set parent
				n.setParent(q);
				
				
				
				//System.out.println("\nGENERATED SUCCESSOR\n" + n.toString());
				
				//add the node to the list of successors
				successors.add(n);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		
		
		return successors;
	}


	public void printPath(FlightNode n){
		
		System.out.println("\n" + n.toString());
		
		if(n.getParent() != null){
			printPath(n.getParent());
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlightConnection f = new FlightConnection();
	}

}
