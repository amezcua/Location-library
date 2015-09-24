package net.byteabyte.location.gps;

import java.io.Serializable;

public class GpsSpeed implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private double Knots = 0;
	private double KilometersPerHour = 0;
	private double MilesPerHour = 0;

	public GpsSpeed(String reportedSpeedInKnots){
		if(!reportedSpeedInKnots.trim().equals(""))
		{
			Knots = Double.parseDouble(reportedSpeedInKnots);
			KilometersPerHour = Knots * 1.85185;
			MilesPerHour = Knots * 1.150779;
		}
	}

	public double getKnots() { return Knots; }

	public double getKilometersPerHour() { return KilometersPerHour; }

	public double getMilesPerHour() { return MilesPerHour; }
}
