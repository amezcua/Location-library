package net.byteabyte.location.gps.tests;

import net.byteabyte.location.gps.GPGLLGpsSentence;
import net.byteabyte.location.gps.Latitude;
import net.byteabyte.location.gps.Longitude;
import org.junit.Test;

import static org.junit.Assert.*;

public class GPGLLGpsSentenceTest {

  private String gpgllSentence = "$GPGLL,4916.45,N,12311.12,W,225444,A,*1D";

  @Test
  public void testGPGLLParsing(){
    GPGLLGpsSentence sentence = new GPGLLGpsSentence(gpgllSentence);

    assertEquals("$GPGLL", sentence.getSentenceName());
    assertEquals(22, sentence.getUtcTime().getHours());
    assertEquals(54, sentence.getUtcTime().getMinutes());
    assertEquals(44, sentence.getUtcTime().getSeconds());

    assertEquals(49274166, sentence.getLatitude().toE6());
    assertEquals(Latitude.North, sentence.getLatitude().getIndicator());
    assertEquals("49º16.45' N", sentence.getLatitude().toString());

    assertEquals(Longitude.West, sentence.getLongitude().getIndicator());
    assertEquals(-123185333, sentence.getLongitude().toE6());
    assertEquals("123º11.12' W", sentence.getLongitude().toString());

    assertTrue(sentence.getFixed());
  }

}