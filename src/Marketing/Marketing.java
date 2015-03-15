package Marketing;

import java.util.EnumSet;

/**
 * Created by kourpa on 3/14/15.
 *
 */
public class Marketing {
  public static float getPrice(Itinerary itinerary, EnumSet<Discount> options){
    float price = 0f;

    for(String s: itinerary.flight_list){
      for(Discount d: options){
        price += 1000 + 1000 * d.percent;
      }
    }

    return price;
  }
}
