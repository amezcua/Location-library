package net.byteabyte.location.gps;

public class DoubleLatitudeLongitude extends LatitudeLongitude {

  public DoubleLatitudeLongitude(double latitudeLongitude, String indicator) {
    setDegrees((int) latitudeLongitude);

    if (isLatitudeIndicator(indicator)){
      if((getDegrees() > 90) || (getDegrees() < -90)) throw new IllegalArgumentException("Latitude must be between -90 and 90.");
    }

    if (isLongitudeIndicator(indicator)){
      if((getDegrees() > 180) || (getDegrees() < -180)) throw new IllegalArgumentException("Longitude must be between -180 and 180.");
    }

    setMinutes((latitudeLongitude - getDegrees()) * 60);

    setIndicator(indicator.toUpperCase());
  }
}
