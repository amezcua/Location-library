package net.byteabyte.location.gps;

public class TimeSpan {
	private int days = 0;
	private int hours = 0;
	private int minutes = 0;
	private int seconds = 0;
	private int milliseconds = 0;
	
	public TimeSpan(int hours, int minutes, int seconds){
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public TimeSpan(int hours, int minutes, int seconds, int milliseconds){
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;
	}
	
	public TimeSpan(int days, int hours, int minutes, int seconds, int milliseconds){
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;
	}

	public int getDays() {
		return days;
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public int getMilliseconds() {
		return milliseconds;
	}
	
}