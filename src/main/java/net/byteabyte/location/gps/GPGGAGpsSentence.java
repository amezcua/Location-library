package net.byteabyte.location.gps;

public class GPGGAGpsSentence extends GpsSentenceBase {

  private static final long serialVersionUID = 1L;
  private TimeSpan uTCTime;
  private LatitudeLongitude latitude;
  private LatitudeLongitude longitude;

  public GPGGAGpsSentence(String Sentence) {
    super(Sentence);

    this.setSentenceName("$GPGGA");
    this.setDescription("Global Positioning System Fixed Data");

    if (this.getWords()[1].length() == 6) {
      // Only HHMMSS
      uTCTime = new TimeSpan(Integer.parseInt(this.getWords()[1].substring(0, 2)),
          Integer.parseInt(this.getWords()[1].substring(2, 4)),
          Integer.parseInt(this.getWords()[1].substring(4, 6)), 0);
    } else {
      // HHMMSS.MS
      uTCTime = new TimeSpan(Integer.parseInt(this.getWords()[1].substring(0, 2)),
          Integer.parseInt(this.getWords()[1].substring(2, 4)),
          Integer.parseInt(this.getWords()[1].substring(4, 6)),
          Integer.parseInt(this.getWords()[1].substring(7)));
    }
  }

  public TimeSpan getUTCTime() {
    return uTCTime;
  }

  public LatitudeLongitude getLatitude() {
    if (latitude == null) {
      latitude = new NMEALatitudeLongitude(this.getWords()[2], this.getWords()[3]);
    }
    return latitude;
  }

  public LatitudeLongitude getLongitude() {
    if (longitude == null) {
      longitude = new NMEALatitudeLongitude(this.getWords()[4], this.getWords()[5]);
    }
    return longitude;
  }

  public PositionFix getPositionFix() {
    String positionFixWord = this.getWords()[6];

    if (!this.getWords()[6].equals("")) {
      int positionFixValue = Integer.parseInt(positionFixWord);
      switch (positionFixValue) {
        case 0: {
          return PositionFix.NotAvailableOrInvalid;
        }
        case 1: {
          return PositionFix.SPSMode;
        }
        case 2: {
          return PositionFix.DifferentialGPS;
        }
        case 3: {
          return PositionFix.PPSMode;
        }
        case 4: {
          return PositionFix.RealTimeKinematic;
        }
        case 5: {
          return PositionFix.FloatRTK;
        }
        case 6: {
          return PositionFix.Estimated;
        }
        case 7: {
          return PositionFix.ManualInputMode;
        }
        case 8: {
          return PositionFix.SimulationMode;
        }
        default: {
          return PositionFix.NotAvailableOrInvalid;
        }
      }
    }
    return PositionFix.NotAvailableOrInvalid;
  }

  public int getSatelitesUsed() {
    int satellitesUsed = 0;
    if (!this.getWords()[7].equals("")) satellitesUsed = Integer.parseInt(this.getWords()[7]);
    return satellitesUsed;
  }

  public double getHDOP() {
    double hdop = 0;
    if (!this.getWords()[8].equals("")) hdop = Double.parseDouble(this.getWords()[8]);
    return hdop;
  }

  public double getAltitude() {
    double altitude = 0;
    if (!this.getWords()[9].equals("")) altitude = Double.parseDouble(this.getWords()[9]);
    return altitude;
  }

  public double getGeoidSeparation() {
    double geoidSeparation = 0;
    if (!this.getWords()[11].equals("")) geoidSeparation = Double.parseDouble(this.getWords()[11]);
    return geoidSeparation;
  }
}
