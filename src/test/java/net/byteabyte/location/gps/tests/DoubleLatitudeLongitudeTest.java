package net.byteabyte.location.gps.tests;

import net.byteabyte.location.gps.DoubleLatitudeLongitude;
import net.byteabyte.location.gps.Latitude;
import net.byteabyte.location.gps.LatitudeLongitude;
import net.byteabyte.location.gps.Longitude;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLatitudeLongitudeTest {

  @Test
  public void testLatitudeNorth(){
    LatitudeLongitude north = new DoubleLatitudeLongitude(40.25, Latitude.North);

    assertEquals("N", north.getIndicator());
    assertEquals(40, north.getDegrees());

    double minutes = 0.25 * 60; // (40.25 - 40) * 60
    assertEquals(minutes, north.getMinutes(), 0d);

    double doubleValue = 40.25d;
    assertEquals(doubleValue, north.toDouble(), 0d);

    assertEquals(40250000, north.toE6());
    assertEquals("40º15.0' N", north.toString());
  }

  @Test
  public void testLatitudeSouth(){
    LatitudeLongitude south = new DoubleLatitudeLongitude(20.87, Latitude.South);

    assertEquals("S", south.getIndicator());
    assertEquals(20, south.getDegrees());

    double minutes = 0.87 * 60;
    assertEquals(minutes, south.getMinutes(), 0.1d);

    double doubleValue = -20.87d;
    assertEquals(doubleValue, south.toDouble(), 0d);

    assertEquals(-20870000, south.toE6());
    assertEquals("20º52.2' S", south.toString());
  }

  @Test
  public void testLongitudeEast(){
    LatitudeLongitude east = new DoubleLatitudeLongitude(2.34, Longitude.East);

    assertEquals("E", east.getIndicator());
    assertEquals(2, east.getDegrees());

    double minutes = 0.34 * 60;
    assertEquals(minutes, east.getMinutes(), 0.1d);

    double doubleValue = 2.34d;
    assertEquals(doubleValue, east.toDouble(), 0d);

    assertEquals(2340000, east.toE6());
    assertEquals("2º20.4' E", east.toString());
  }

  @Test
  public void testLongitudeWest(){
    LatitudeLongitude east = new DoubleLatitudeLongitude(32.43, Longitude.West);

    assertEquals("W", east.getIndicator());
    assertEquals(32, east.getDegrees());

    double minutes = 0.43 * 60;
    assertEquals(minutes, east.getMinutes(), 0.1d);

    double doubleValue = -32.43d;
    assertEquals(doubleValue, east.toDouble(), 0d);

    assertEquals(-32430000 , east.toE6());
    assertEquals("32º25.8' W", east.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwExceptionOnNorthLatitudeGreaterThan90(){
    new DoubleLatitudeLongitude(91, Latitude.North);
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwExceptionOnNorthLatitudeLessThanMinus90(){
    new DoubleLatitudeLongitude(-91, Latitude.North);
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwExceptionOnSouthLatitudeGreaterThan90(){
    new DoubleLatitudeLongitude(91, Latitude.South);
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwExceptionOnSouthLatitudeLessThanMinus90(){
    new DoubleLatitudeLongitude(-91, Latitude.South);
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwExceptionOnEastLongitudeGreaterThan180(){
    new DoubleLatitudeLongitude(181, Longitude.East);
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwExceptionOnEastLongitudeLessThanMinus180(){
    new DoubleLatitudeLongitude(-181, Longitude.East);
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwExceptionOnWestLongitudeGreaterThan180(){
    new DoubleLatitudeLongitude(181, Longitude.West);
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwExceptionOnWestLongitudeLessThanMinus180(){
    new DoubleLatitudeLongitude(-181, Longitude.West);
  }
}