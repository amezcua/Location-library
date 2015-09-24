package net.byteabyte.location.gps.tests;

import net.byteabyte.location.gps.GPVTGGpsSentence;
import org.junit.Test;

import static org.junit.Assert.*;

public class GPVTGGpsSentenceTest {
  private String gpvtgSentence = "$GPVTG,054.7,T,034.4,M,005.5,N,010.2,K*48";

  @Test
  public void testGpvtgSentenceParsing(){
    GPVTGGpsSentence sentence = new GPVTGGpsSentence(gpvtgSentence);

    assertEquals("$GPVTG", sentence.getSentenceName());

    assertEquals(54.7, sentence.getTrueCourse(), 0);
    assertEquals(34.4, sentence.getMagneticCourse(), 0);
    assertEquals(5.5, sentence.getSpeedKnots(), 0);
    assertEquals(10.2, sentence.getSpeedKmH(), 0);
  }
}