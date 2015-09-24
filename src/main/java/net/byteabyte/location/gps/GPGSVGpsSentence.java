package net.byteabyte.location.gps;

public class GPGSVGpsSentence extends GpsSentenceBase {
	private int numberOfMessages; // This sentence comes in a few consecutive messages.
	private int messageNumber; // Number of this message in the block
	private int satellitesInView; // Number of visible satellites
	private SatelliteInView[] satellites; // Information about the satellites in this sentence

	public GPGSVGpsSentence(String Sentence){
		super(Sentence);
		
		this.setSentenceName("$GPGSV");
		this.setDescription("GNSS Satellites in View");

		numberOfMessages = Integer.parseInt(this.getWords()[1]);
		messageNumber = Integer.parseInt(this.getWords()[2]);
		satellitesInView = Integer.parseInt(this.getWords()[3]);

		int satelliteCountInSentence = (this.getWordCount() - 3) / 4;

		satellites = new SatelliteInView[satelliteCountInSentence];

		int satelliteWordIndex = 4;
		int currentIndex;
		for(int i=0; i < satelliteCountInSentence; i++)
		{
			satellites[i] = new SatelliteInView();
			currentIndex = satelliteWordIndex;
			if(!this.getWords()[currentIndex].equals(""))
				satellites[i].setSatelliteID(Integer.parseInt(this.getWords()[currentIndex]));
			satelliteWordIndex ++;
			
			currentIndex = satelliteWordIndex;
			if(!this.getWords()[currentIndex].equals(""))
				satellites[i].setElevation(Double.parseDouble(this.getWords()[currentIndex]));
			satelliteWordIndex ++;

			currentIndex = satelliteWordIndex;
			if(!this.getWords()[currentIndex].equals(""))
				satellites[i].setAzimuth(Double.parseDouble(this.getWords()[currentIndex]));
			satelliteWordIndex ++;
			
			currentIndex = satelliteWordIndex;
			if(!this.getWords()[currentIndex].equals(""))
				satellites[i].setSignalToNoiseRatio(Double.parseDouble(this.getWords()[currentIndex]));
			satelliteWordIndex ++;
		}
	}
	
	public int getNumberOfMessages() { return numberOfMessages; }
	public int getMessageNumber() { return messageNumber; }
	public int getSatellitesInView() { return satellitesInView; }
	public SatelliteInView[] getSatellites() { return satellites; }
}
