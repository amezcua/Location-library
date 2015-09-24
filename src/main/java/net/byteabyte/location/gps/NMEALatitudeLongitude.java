package net.byteabyte.location.gps;

public class NMEALatitudeLongitude extends LatitudeLongitude {
	private static final long serialVersionUID = 1L;

	public NMEALatitudeLongitude(String LatitudeString, String Indicator){
		final String indicator = Indicator.toUpperCase();
		
		if(indicator.equals("E")){
			setDegrees(Integer.parseInt(LatitudeString.substring(0, 3)));
			setMinutes(Double.parseDouble(LatitudeString.substring(3)));
		}else if(indicator.equals("W")){
			setDegrees(Integer.parseInt(LatitudeString.substring(0, 3)));
			setMinutes(Double.parseDouble(LatitudeString.substring(3)));
		}else if(indicator.equals("N")){
			setDegrees(Integer.parseInt(LatitudeString.substring(0, 2)));
			setMinutes(Double.parseDouble(LatitudeString.substring(2)));
		}else if(indicator.equals("S")){
			setDegrees(Integer.parseInt(LatitudeString.substring(0, 2)));
			setMinutes(Double.parseDouble(LatitudeString.substring(2)));
		}
		
		setIndicator(indicator);
	}
}
