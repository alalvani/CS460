package Connections;
/**
 * 
 */

/**
 * @author Danny
 *
 */
public class FlightNode {

	long travelTime = 0; //g
	long h = 0; //heuristic
	
	int flightTaken = 0; //flight number of flight taken to get to this airport
	
	long arrivalTime = 0; //time at which the flight arrived at this airport
	
	String airport = "";
	
	FlightNode parent;
	
	public void setParent(FlightNode parent){
		this.parent = parent;
	}
	
	public FlightNode getParent(){
		return parent;
	}
	
	public long getTravelTime() {
		return travelTime;
	}


	public void setTravelTime(long travelTime) {
		this.travelTime = travelTime;
	}


	public long getH() {
		return h;
	}


	public void setH(long h) {
		this.h = h;
	}
	
	
	public long getF() {
		return h+travelTime;
	}

	public void setArrivalTime(long arrivalTime){
		this.arrivalTime = arrivalTime;
	}
	
	public long getArrivalTime(){
		return arrivalTime;
	}

	public int getFlightTaken() {
		return flightTaken;
	}


	public void setFlightTaken(int flightTaken) {
		this.flightTaken = flightTaken;
	}


	public String getAirport() {
		return airport;
	}


	public void setAirport(String airport) {
		this.airport = airport;
	}

	public String toString(){
		
		String s = "";
		
		s += "Airport: " + airport + "\n";
		s += "Flight Taken: " + flightTaken + "\n";
		s += "Arrival Time: " + arrivalTime + "\n";
		s += "Travel Time: " + travelTime + "\n";
		s += "h: " + h + "\n";
		s += "f: " + getF() + "\n";
		
		return s;
	}

	public FlightNode(){
		
		
	}
}
