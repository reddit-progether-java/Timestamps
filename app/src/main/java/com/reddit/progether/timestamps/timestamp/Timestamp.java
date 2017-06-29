package com.reddit.progether.timestamps.timestamp;

import java.sql.Date;

public class Timestamp {
	
	Date date;
	TimestampStatus status;
	
	public Timestamp(Date date, TimestampStatus status) {
		this.date = date;
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TimestampStatus getStatus() {
		return status;
	}
	public void setStatus(TimestampStatus status) {
		this.status = status;
	}
}
