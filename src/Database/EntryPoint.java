package Database;

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
      Layout lo=AirplaneLayout.getLayout(1);
      System.out.println(lo.getSeating());
      
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    
    
    
    
    
    database.closeStatement();
    database.closeConnection();
  }

}
