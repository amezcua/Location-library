package net.byteabyte.location.gps.tests;

import net.byteabyte.location.gps.GPGSAGpsSentence;
import net.byteabyte.location.gps.Mode1;
import net.byteabyte.location.gps.Mode2;
import org.junit.Test;

import static org.junit.Assert.*;

public class GPGSAGpsSentenceTest {

  private String gpgsaSentence = "$GPGSA,A,3,04,05,,09,12,,,24,,,,,2.5,1.3,2.1*39";

  @Test
  public void testGPGSAParsing(){
    GPGSAGpsSentence sentence = new GPGSAGpsSentence(gpgsaSentence);

    assertEquals("$GPGSA", sentence.getSentenceName());
    assertEquals(Mode1.Automatic, sentence.getMode1());
    assertEquals(Mode2.ThreeDimensions, sentence.getMode2());
    assertEquals(4, sentence.getSatelliteOnChannel1());
    assertEquals(5, sentence.getSatelliteOnChannel2());
    assertEquals(-1, sentence.getSatelliteOnChannel3());
    assertEquals(9, sentence.getSatelliteOnChannel4());
    assertEquals(12, sentence.getSatelliteOnChannel5());
    assertEquals(-1, sentence.getSatelliteOnChannel6());
    assertEquals(-1, sentence.getSatelliteOnChannel7());
    assertEquals(24, sentence.getSatelliteOnChannel8());
    assertEquals(-1, sentence.getSatelliteOnChannel9());
    assertEquals(-1, sentence.getSatelliteOnChannel10());
    assertEquals(-1, sentence.getSatelliteOnChannel11());
    assertEquals(-1, sentence.getSatelliteOnChannel12());

    assertEquals(2.5, sentence.getPDOP(), 0);
    assertEquals(1.3, sentence.getHDOP(), 0);
    assertEquals(2.1, sentence.getVDOP(), 0);

  }
}