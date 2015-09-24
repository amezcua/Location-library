package net.byteabyte.location.gps;

import java.io.Serializable;

public class SatelliteInView implements Serializable {
	private int satelliteID;
	private double elevation;
	private double azimuth;
	private double signalToNoiseRatio;
	
	public int getSatelliteID() {
		return satelliteID;
	}
	public void setSatelliteID(int satelliteID) {
		this.satelliteID = satelliteID;
	}
	public double getElevation() {
		return elevation;
	}
	public void setElevation(double elevation) {
		this.elevation = elevation;
	}
	public double getAzimuth() {
		return azimuth;
	}
	public void setAzimuth(double azimuth) {
		this.azimuth = azimuth;
	}
	public double getSignalToNoiseRatio() {
		return signalToNoiseRatio;
	}
	public void setSignalToNoiseRatio(double signalToNoiseRatio) {
		this.signalToNoiseRatio = signalToNoiseRatio;
	}
}
