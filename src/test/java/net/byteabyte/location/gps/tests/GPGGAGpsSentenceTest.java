package net.byteabyte.location.gps.tests;

import net.byteabyte.location.gps.GPGGAGpsSentence;
import net.byteabyte.location.gps.Latitude;
import net.byteabyte.location.gps.Longitude;
import net.byteabyte.location.gps.PositionFix;
import org.junit.Test;

import static org.junit.Assert.*;

public class GPGGAGpsSentenceTest {

  private String gpggaSentence = "$GPGGA,123519,4807.038,N,01131.000,E,1,08,0.9,545.4,M,46.9,M,,*47";

  @Test
  public void testGPGGAParsing(){
    GPGGAGpsSentence sentence = new GPGGAGpsSentence(gpggaSentence);

    assertEquals("$GPGGA", sentence.getSentenceName());
    assertEquals(12, sentence.getUTCTime().getHours());
    assertEquals(35, sentence.getUTCTime().getMinutes());
    assertEquals(19, sentence.getUTCTime().getSeconds());

    assertEquals(48117300, sentence.getLatitude().toE6());
    assertEquals(Latitude.North, sentence.getLatitude().getIndicator());
    assertEquals("48º7.038' N", sentence.getLatitude().toString());

    assertEquals(Longitude.East, sentence.getLongitude().getIndicator());
    assertEquals(11516666, sentence.getLongitude().toE6());
    assertEquals("11º31.0' E", sentence.getLongitude().toString());

    assertEquals(PositionFix.SPSMode, sentence.getPositionFix());
    assertEquals(8, sentence.getSatelitesUsed());
    assertEquals(0.9, sentence.getHDOP(), 0);
    assertEquals(545.4, sentence.getAltitude(), 0);
    assertEquals(46.9, sentence.getGeoidSeparation(), 0);
  }

}