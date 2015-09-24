package net.byteabyte.location.gps;

public class GPVTGGpsSentence extends GpsSentenceBase {
	private double trueCourse;
	private double magneticCourse;
	private double speedKnots;
	private double speedKmh;
	
	public GPVTGGpsSentence(String Sentence){
		super(Sentence);
	
		this.setSentenceName("$GPVTG");
		this.setDescription("Course Over Ground and Ground Speed");

		if(!this.getWords()[1].equals(""))
			trueCourse = Double.parseDouble(this.getWords()[1]);

		if(!this.getWords()[3].equals(""))
			magneticCourse = Double.parseDouble(this.getWords()[3]);

		if(!this.getWords()[5].equals(""))
			speedKnots = Double.parseDouble(this.getWords()[5]);

		if(!this.getWords()[7].equals(""))
			speedKmh = Double.parseDouble(this.getWords()[7]);
	}
	
	public double getTrueCourse() { return trueCourse;	}
	public double getMagneticCourse() { return magneticCourse;	}
	public double getSpeedKnots() { return speedKnots;	}
	public double getSpeedKmH() { return speedKmh;	}
}
