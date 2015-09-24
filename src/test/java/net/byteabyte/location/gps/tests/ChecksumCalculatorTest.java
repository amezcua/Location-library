package net.byteabyte.location.gps.tests;

import net.byteabyte.location.gps.ChecksumCalculator;
import net.byteabyte.location.gps.GPRMCGpsSentence;
import net.byteabyte.location.gps.GpsSentenceBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChecksumCalculatorTest {

  private String validGprmcFixed = "$GPRMC,123519,A,4807.038,N,01131.000,E,022.4,084.4,230394,003.1,W*6A";

  @Test public void testGetChecksum() throws Exception {
    String checksum = ChecksumCalculator.getChecksum(validGprmcFixed);

    assertEquals("6A", checksum);
  }

  @Test
  public void isValidChecksumInSentence(){
    GpsSentenceBase sentence = new GPRMCGpsSentence(validGprmcFixed);

    assertTrue(sentence.validCheckSum());
  }
}