package net.byteabyte.location.gps;

import java.io.Serializable;
import java.text.DecimalFormat;

public abstract class LatitudeLongitude implements Serializable {
  private int degrees = 0;
  private double minutes = 0;
  private String indicator;

  public int getDegrees() {
    return degrees;
  }

  public void setDegrees(int degrees) {
    this.degrees = degrees;
  }

  public double getMinutes() {
    return minutes;
  }

  public void setMinutes(double minutes) {
    this.minutes = minutes;
  }

  public int toE6() {
    int e6value = (int) ((degrees + (minutes / 60.0)) * 1.0E6);

    if (indicator.equals("W") || indicator.equals("S")) e6value = -e6value;
    return e6value;
  }

  public double toDouble() {
    double doubleValue = degrees + (minutes / 60.0);

    if (indicator.equals("W") || indicator.equals("S")) doubleValue = -doubleValue;
    return doubleValue;
  }

  public String getIndicator() {
    return indicator;
  }

  public void setIndicator(String indicator) {
    this.indicator = indicator;
  }

  @Override public String toString() {
    StringBuilder latitudeString = new StringBuilder();

    latitudeString.append(getDegrees());
    latitudeString.append('º');
    latitudeString.append(new DecimalFormat("0.0##").format(getMinutes()));
    latitudeString.append("' ");
    latitudeString.append(getIndicator());

    return latitudeString.toString();
  }

  protected boolean isLatitudeIndicator(String indicator) {
    return indicator.equalsIgnoreCase(Latitude.North) || indicator.equalsIgnoreCase(
        Latitude.South);
  }

  protected boolean isLongitudeIndicator(String indicator) {
    return indicator.equalsIgnoreCase(Longitude.East) || indicator.equalsIgnoreCase(
        Longitude.West);
  }
}
