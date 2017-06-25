package Timestamps;

import java.util.ArrayList;

public class TimestampsLogic {
	
	private static ArrayList<Timestamp> timestamps = new ArrayList<Timestamp>();
	
	public static void onButtonOpenClicked()
	{
		timestamps.add(new Timestamp(new java.sql.Date(System.currentTimeMillis()), TimestampStatus.Gestartet));
	}public static void onButtonCloseClicked()
	{
		timestamps.add(new Timestamp(new java.sql.Date(System.currentTimeMillis()), TimestampStatus.Geschlossen));
	}
}
