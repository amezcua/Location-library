package net.byteabyte.location.gps.tests;

import net.byteabyte.location.gps.GPGSVGpsSentence;
import net.byteabyte.location.gps.SatelliteInView;
import org.junit.Test;

import static org.junit.Assert.*;

public class GPGSVGpsSentenceTest {

  private String gpgsvSentence = "$GPGSV,2,1,08,01,40,083,46,02,17,308,41,12,07,344,39,14,22,228,45*75";

  @Test
  public void testGpgsvSentenceParsing(){
    GPGSVGpsSentence sentence = new GPGSVGpsSentence(gpgsvSentence);

    assertEquals("$GPGSV", sentence.getSentenceName());
    assertEquals(2, sentence.getNumberOfMessages());
    assertEquals(1, sentence.getMessageNumber());
    assertEquals(8, sentence.getSatellitesInView());

    SatelliteInView s = sentence.getSatellites()[0];
    assertEquals(1, s.getSatelliteID());
    assertEquals(40, s.getElevation(), 0);
    assertEquals(83, s.getAzimuth(), 0);
    assertEquals(46, s.getSignalToNoiseRatio(), 0);

    s = sentence.getSatellites()[1];
    assertEquals(2, s.getSatelliteID());
    assertEquals(17, s.getElevation(), 0);
    assertEquals(308, s.getAzimuth(), 0);
    assertEquals(41, s.getSignalToNoiseRatio(), 0);

    s = sentence.getSatellites()[2];
    assertEquals(12, s.getSatelliteID());
    assertEquals(7, s.getElevation(), 0);
    assertEquals(344, s.getAzimuth(), 0);
    assertEquals(39, s.getSignalToNoiseRatio(), 0);

    s = sentence.getSatellites()[3];
    assertEquals(14, s.getSatelliteID());
    assertEquals(22, s.getElevation(), 0);
    assertEquals(228, s.getAzimuth(), 0);
    assertEquals(45, s.getSignalToNoiseRatio(), 0);
  }
}