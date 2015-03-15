package Marketing;

/**
 * Created by kourpa on 3/14/15.
 */
public enum Discount {
  FIST_CLASS(.20f),
  SECOND_CLASS(.10f),
  COUCH(0.0f),
  ELDERLY(-0.10f),
  CHILD(-0.10f),
  ROUND_TRIP(-0.05f),
  OTHER(-0.50f);

  public float percent;
  private Discount(float price){this.percent = percent;}
}
