package Marketing;

import Database.Database;

import java.sql.ResultSet;

/**
 * Created by kourpa on 3/14/15.
 *
 */
public class Marketing {
  public static float getPrice(Itinerary itinerary){
    float price = 0f;

    String query = "select current_price from Flights where ";

    String[] flight_list = itinerary.flight_list;

    for(int i = 0; i < flight_list.length - 1; i++){
      query += "flight_id = " + flight_list[i] + " or ";
    }

    query += "flight_i9d = " + flight_list[flight_list.length - 1];


    ResultSet rs = Database.query(query);

    try{
      while(rs.next()){
        price += rs.getInt("current_price");
      }
    } catch (Exception ignored) {
    }

    Database.closeStatement();

    return price;
  }

  public static void main(String args[]){
    Database.connect();
    Itinerary foo = new Itinerary();
    foo.flight_list = new String[] {"1", "2", "3"};

    System.out.println(Marketing.getPrice(foo));
  }
}
