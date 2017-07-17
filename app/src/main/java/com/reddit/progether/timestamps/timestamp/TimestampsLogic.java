package com.reddit.progether.timestamps.timestamp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TimestampsLogic {

	private ArrayList<Timestamp> timestamps = new ArrayList<Timestamp>();
	
	//true if the latest Timestamp is one wich was created by the onButtonStartClicked method
	//used to avoid multiple start Timestamps in a row
	public boolean isStarted = false;
	
	public void onButtonStartClicked() {
		if(!isStarted){
			timestamps.add(new Timestamp(new java.sql.Date(System.currentTimeMillis()), TimestampStatus.Gestartet));
			isStarted = true;
		}
	}

	public void onButtonStopClicked() {
		timestamps.add(new Timestamp(new java.sql.Date(System.currentTimeMillis()), TimestampStatus.Geschlossen));
		isStarted = false;
	}

	public String timestampsToString() {
		String returnString = "";

		for (Timestamp timestamp : timestamps) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(Long.parseLong(timestamp.getDate().getTime() + ""));

			returnString += timestamp.getStatus() + "\n" + simpleDateFormat.format(calendar.getTime()) + "\n\n";
		}
		return returnString;
	}

	public ArrayList<Timestamp> getTimestamps() {
		return timestamps;
	}
}
