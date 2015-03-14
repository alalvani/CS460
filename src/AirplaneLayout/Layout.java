package AirplaneLayout;

/**
 * Created by kourpa on 3/14/15.
 * Current state of the seating is a 2D character array.
 * a = aisle
 * s = seat
 * e = exit
 * c = airplane attendent area
 */
public class Layout {
  Character[][] seating;
  int planeID;
  int totalSeats;

  public Character[][] getSeating(){ return seating;}
  public int getPlaneID(){ return planeID;}
  public int getTotalSeats(){ return totalSeats;}
}
