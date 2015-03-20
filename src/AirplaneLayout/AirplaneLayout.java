package AirplaneLayout;

import Database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kourpa on 3/14/15.
 *
 */
public class AirplaneLayout {

  public static Layout getLayout(int planeID){
    Layout layout = new Layout();
    Character[][] seating = null;
    int totalSeats = 0;
    
    
    Database database=new Database();


    String query = "select * from Planes where id = " + planeID;

    try {
      ResultSet rs = database.query(query);

      rs.next();
      String aircraft_type = rs.getString("aircraft_type");

      query = "select * from Aircrafts where type = '" + aircraft_type + "'";
      rs = database.query(query);

      rs.next();
      String s = rs.getString("seating");
      totalSeats = Integer.parseInt(rs.getString("max_seating_capacy"));

      int width = Character.getNumericValue(s.charAt(0));
      int height = s.length() / width;

      seating = new Character[height][width];

      for(int i = 1, j = 0; i < s.length(); i++){
        seating[j][(i - 1) % 7] = s.charAt(i);

        if(i % 7 == 0) {
          j++;
        }
      }

      for(int j = 0; j < height; j++){
        for(int i = 0; i < width; i++){
          System.out.print(seating[j][i]);
        }
        System.out.println();
      }
    } catch (SQLException ignored) {
    }

    database.closeStatement();

    layout.planeID = planeID;
    layout.seating = seating;
    layout.totalSeats = totalSeats;

    return layout;
  }

//  public static void main(String args[]){
//    database.connect();
//    AirplaneLayout.getLayout(1);
//    database.closeConnection();
//  }
}
