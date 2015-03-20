package Database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import AirplaneLayout.*;

public class EntryPoint
{

  public static void main(String args[]) {
    Database database= new Database();

    try
    {
      database.notification("delay", 1);
      //Layout lo=AirplaneLayout.getLayout(1);
     // Date date=new Date(1,1,1);
      database.addUser("Paige", "Romero", "GuapoGato69@fake.co.uk", "1234567890", new Date(1,1,1), "123 fake st.", 0, "123456789", "cockpit", "princessTimeForPaige");
     // System.out.println(lo.getSeating());
      
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    
    
    
    
    
    database.closeStatement();
    database.closeConnection();
  }

}
