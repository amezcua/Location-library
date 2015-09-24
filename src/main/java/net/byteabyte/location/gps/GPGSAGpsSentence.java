package net.byteabyte.location.gps;

public class GPGSAGpsSentence extends GpsSentenceBase {
	private int satelliteOnChannel1 = -1;
	private int satelliteOnChannel2 = -1;
	private int satelliteOnChannel3 = -1;
	private int satelliteOnChannel4 = -1;
	private int satelliteOnChannel5 = -1;
	private int satelliteOnChannel6 = -1;
	private int satelliteOnChannel7 = -1;
	private int satelliteOnChannel8 = -1;
	private int satelliteOnChannel9 = -1;
	private int satelliteOnChannel10 = -1;
	private int satelliteOnChannel11 = -1;
	private int satelliteOnChannel12 = -1;
	private double pDOP = -1; // Position dillution of precision
	private double hDOP = -1; // Horizontal dillution of precision
	private double vDOP = -1; // Vertical dillution of precision
	
	public GPGSAGpsSentence(String Sentence){
		super(Sentence);
		
		this.setSentenceName("$GPGSA");
		this.setDescription("GNSS DOP and Active Satellites");

		int currentWordPos = 2;

		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			satelliteOnChannel1 = Integer.parseInt(this.getWords()[currentWordPos]);
		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			satelliteOnChannel2 = Integer.parseInt(this.getWords()[currentWordPos]);
		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			satelliteOnChannel3 = Integer.parseInt(this.getWords()[currentWordPos]);
		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			satelliteOnChannel4 = Integer.parseInt(this.getWords()[currentWordPos]);
		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			satelliteOnChannel5 = Integer.parseInt(this.getWords()[currentWordPos]);
		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			satelliteOnChannel6 = Integer.parseInt(this.getWords()[currentWordPos]);
		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			satelliteOnChannel7 = Integer.parseInt(this.getWords()[currentWordPos]);
		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			satelliteOnChannel8 = Integer.parseInt(this.getWords()[currentWordPos]);
		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			satelliteOnChannel9 = Integer.parseInt(this.getWords()[currentWordPos]);
		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			satelliteOnChannel10 = Integer.parseInt(this.getWords()[currentWordPos]);
		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			satelliteOnChannel11 = Integer.parseInt(this.getWords()[currentWordPos]);
		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			satelliteOnChannel12 = Integer.parseInt(this.getWords()[currentWordPos]);

		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			pDOP = Double.parseDouble(this.getWords()[currentWordPos]);

		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			hDOP = Double.parseDouble(this.getWords()[currentWordPos]);

		currentWordPos ++;
		if(!this.getWords()[currentWordPos].equals(""))
			vDOP = Double.parseDouble(this.getWords()[currentWordPos]);
		
	}
	
	public Mode1 getMode1() {
		String mode1String = this.getWords()[1];
		return mode1String.equals("M") ? Mode1.Manual : Mode1.Automatic; 
	}
	public Mode2 getMode2() { 
		int mode2value = Integer.parseInt(this.getWords()[2]);
		switch(mode2value){
			case 1:{
				return Mode2.FixNotAvailable;
			}
			case 2:{
				return Mode2.TwoDimensions;
			}
			case 3:{
				return Mode2.ThreeDimensions;
			}
			default:{
				return Mode2.FixNotAvailable;
			}
		}
	}
	public int getSatelliteOnChannel1() { return satelliteOnChannel1; }
	public int getSatelliteOnChannel2()	{ return satelliteOnChannel2; }
	public int getSatelliteOnChannel3() { return satelliteOnChannel3; }
	public int getSatelliteOnChannel4()	{ return satelliteOnChannel4; }
	public int getSatelliteOnChannel5() { return satelliteOnChannel5; }
	public int getSatelliteOnChannel6() { return satelliteOnChannel6; }
	public int getSatelliteOnChannel7()	{ return satelliteOnChannel7; }
	public int getSatelliteOnChannel8()	{ return satelliteOnChannel8; }
	public int getSatelliteOnChannel9()	{ return satelliteOnChannel9; }
	public int getSatelliteOnChannel10() { return satelliteOnChannel10; }
	public int getSatelliteOnChannel11() { return satelliteOnChannel11; }
	public int getSatelliteOnChannel12() { return satelliteOnChannel12; }
	public double getPDOP() { return pDOP; }
	public double getHDOP() { return hDOP;	}
	public double getVDOP()	{ return vDOP; }
}
