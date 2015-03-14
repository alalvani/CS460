package Marketing;

/**
 * Created by kourpa on 3/14/15.
 */
public enum Discount {
  FIST_CLASS(20), SECOND_CLASS(10), COUCH(0), ELDERLY(-10), CHILD(-10), OTHER(-50);

  public float percent;
  private Discount(float price){this.percent = percent;}
}
