package net.byteabyte.location.gps;

public class GPGLLGpsSentence extends GpsSentenceBase {

	private static final long serialVersionUID = 1L;
	
	private boolean fixed;
	private LatitudeLongitude latitude;
	private LatitudeLongitude longitude;
	private TimeSpan utcTime;
	
	public GPGLLGpsSentence(String Sentence){
		super(Sentence);

		this.setSentenceName("$GPGLL");
		this.setDescription("Geographic Position - Latitude/Longitude");

		fixed = isFixed(this.getWords()[6]);
		latitude = new NMEALatitudeLongitude(this.getWords()[1], this.getWords()[2]);
		longitude = new NMEALatitudeLongitude(this.getWords()[3], this.getWords()[4]);

		if(this.getWords()[5].length() == 6){
			// Only HHMMSS
			utcTime = new TimeSpan(
				Integer.parseInt(this.getWords()[5].substring(0, 2)),
				Integer.parseInt(this.getWords()[5].substring(2, 4)),
				Integer.parseInt(this.getWords()[5].substring(4, 6)));
		}else{
			// HHMMSS.MS
			utcTime = new TimeSpan(
				Integer.parseInt(this.getWords()[5].substring(0, 2)),
				Integer.parseInt(this.getWords()[5].substring(2, 4)),
				Integer.parseInt(this.getWords()[5].substring(4, 6)),
				Integer.parseInt(this.getWords()[5].substring(7)));
		}
	}

	public boolean getFixed() { return fixed; }
	
	public TimeSpan getUtcTime() { return utcTime; }
	
	public LatitudeLongitude getLatitude() { return latitude; }

	public LatitudeLongitude getLongitude() { return longitude; }
	
	private boolean isFixed(String Status){
		return Status.equals("A");
	}
}
