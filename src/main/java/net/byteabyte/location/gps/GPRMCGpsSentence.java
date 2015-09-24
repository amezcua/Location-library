package net.byteabyte.location.gps;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class GPRMCGpsSentence extends GpsSentenceBase {

	private GregorianCalendar calendar;
	private boolean fixed = false;
	private LatitudeLongitude latitude;
	private LatitudeLongitude longitude;
	private GpsSpeed speedOverGround;
	private double courseOverGround;
	private String magneticVariation;
	
	public GPRMCGpsSentence(String SentenceInstance){
		super(SentenceInstance);
	
		this.setSentenceName("$GPRMC");
		this.setDescription("Recommended Minimum Specific GPS/TRANSIT Data");

		fixed = isFixed(this.getWords()[2]);
		latitude = new NMEALatitudeLongitude(this.getWords()[3], this.getWords()[4]);
		longitude = new NMEALatitudeLongitude(this.getWords()[5], this.getWords()[6]);
		speedOverGround = new GpsSpeed(this.getWords()[7]);
		if(this.getWords()[8].equals("")){
			courseOverGround = -1;
		}else{
			courseOverGround = Double.parseDouble(this.getWords()[8]);
		}
		if(this.getWordCount() > 10)
			magneticVariation = this.getWords()[10];

		calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), Locale.getDefault());
		int year = Integer.parseInt(this.getWords()[9].substring(4, 6));
		int month = Integer.parseInt(this.getWords()[9].substring(2, 4)) - 1; // Month starts in 0
		int day = Integer.parseInt(this.getWords()[9].substring(0, 2));
		int hour = Integer.parseInt(this.getWords()[1].substring(0, 2));
		int minute = Integer.parseInt(this.getWords()[1].substring(2, 4));
		int seconds = Integer.parseInt(this.getWords()[1].substring(4, 6));
		calendar.set(year, month, day, hour, minute, seconds);
	}
	
	public boolean getFixed() { return fixed; }
	public GregorianCalendar getGpsDateTime() { return calendar; }
	public LatitudeLongitude getLatitude() { return latitude; }
	public LatitudeLongitude getLongitude() { return longitude; }
	public GpsSpeed getSpeedOverGround() { return speedOverGround;	}
	public double getCourseOverGround() { return courseOverGround;	}
	public String getMagneticVariation() { return magneticVariation; }
	
	private boolean isFixed(String Status) {
		return Status.equals("A");
	}
}
