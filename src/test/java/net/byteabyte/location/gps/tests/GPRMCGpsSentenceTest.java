package net.byteabyte.location.gps.tests;

import java.util.Calendar;
import net.byteabyte.location.gps.GPRMCGpsSentence;
import net.byteabyte.location.gps.Latitude;
import net.byteabyte.location.gps.Longitude;
import org.junit.Test;

import static org.junit.Assert.*;

public class GPRMCGpsSentenceTest {

  private String validGprmcFixed = "$GPRMC,123519,A,4807.038,N,01131.000,E,022.4,084.4,230394,003.1,W*6A";
  private String validGprmcNotFixed = "$GPRMC,123519,V,4807.038,N,01131.000,E,022.4,084.4,230394,003.1,W*6A";

  @Test
  public void testValidFixedGPRMCSentence(){

    GPRMCGpsSentence sentence = new GPRMCGpsSentence(validGprmcFixed);

    assertEquals("$GPRMC", sentence.getSentenceName());
    assertEquals(12, sentence.getGpsDateTime().get(Calendar.HOUR_OF_DAY));
    assertEquals(35, sentence.getGpsDateTime().get(Calendar.MINUTE));
    assertEquals(19, sentence.getGpsDateTime().get(Calendar.SECOND));
    assertTrue(sentence.getFixed());
    assertEquals(48117300, sentence.getLatitude().toE6());
    assertEquals(Latitude.North, sentence.getLatitude().getIndicator());
    assertEquals("48º7.038' N", sentence.getLatitude().toString());
    assertEquals(Longitude.East, sentence.getLongitude().getIndicator());
    assertEquals(11516666, sentence.getLongitude().toE6());
    assertEquals(22.4, sentence.getSpeedOverGround().getKnots(), 0);
    assertEquals(84.4, sentence.getCourseOverGround(), 0);
    assertEquals(23, sentence.getGpsDateTime().get(Calendar.DAY_OF_MONTH));
    assertEquals(3-1, sentence.getGpsDateTime().get(Calendar.MONTH));
    assertEquals(94, sentence.getGpsDateTime().get(Calendar.YEAR));
    assertEquals("003.1", sentence.getMagneticVariation());
    assertEquals("6A", sentence.getCheckSum());
    assertTrue(sentence.validCheckSum());
  }

  @Test
  public void testValidNotFixedGPRMCSentence(){

    GPRMCGpsSentence sentence = new GPRMCGpsSentence(validGprmcNotFixed);

    assertEquals("$GPRMC", sentence.getSentenceName());
    assertEquals(12, sentence.getGpsDateTime().get(Calendar.HOUR_OF_DAY));
    assertEquals(35, sentence.getGpsDateTime().get(Calendar.MINUTE));
    assertEquals(19, sentence.getGpsDateTime().get(Calendar.SECOND));
    assertFalse(sentence.getFixed());

    assertEquals(48117300, sentence.getLatitude().toE6());
    assertEquals(Latitude.North, sentence.getLatitude().getIndicator());
    assertEquals("48º7.038' N", sentence.getLatitude().toString());

    assertEquals(Longitude.East, sentence.getLongitude().getIndicator());
    assertEquals(11516666, sentence.getLongitude().toE6());

    assertEquals(22.4, sentence.getSpeedOverGround().getKnots(), 0);
    assertEquals(84.4, sentence.getCourseOverGround(), 0);
    assertEquals(23, sentence.getGpsDateTime().get(Calendar.DAY_OF_MONTH));
    assertEquals(3-1, sentence.getGpsDateTime().get(Calendar.MONTH));
    assertEquals(94, sentence.getGpsDateTime().get(Calendar.YEAR));
    assertEquals("003.1", sentence.getMagneticVariation());
    assertEquals("6A", sentence.getCheckSum());
    assertTrue(sentence.validCheckSum());
  }
}