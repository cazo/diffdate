package it.bloomp.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	
	private final static long YEAR = 31557600000L;
	private final static long MONTH = 2629800000L;
	private final static int WEEK = 604800016;
	private final static int DAY = 86400000;
	private final static int HOUR = 3600000;
	private final static int MINUTE = 60000;
	private final static int SECOND = 1000;

	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  
		try {
			Date date = simpleDateFormat.parse("2012-05-27 00:00:00");
			long dateMilliseconds = date.getTime();
			
			Calendar now = Calendar.getInstance();
			long nowMilliseconds = now.getTimeInMillis();
			
			long diffMilliseconds;
			boolean future;
			
			if (nowMilliseconds < dateMilliseconds) {
				diffMilliseconds = dateMilliseconds - nowMilliseconds;
				future = true;
			} else {
				diffMilliseconds = nowMilliseconds - dateMilliseconds;
				future = false;
			}
			
			long divider = 0;
			String unit = null;
			
			if (diffMilliseconds > YEAR) {
				divider = YEAR;
				unit = "ano";
			} else if (diffMilliseconds > MONTH) {
				divider = MONTH;
				unit = "mês";
			} else if (diffMilliseconds > WEEK) {
				divider = WEEK;
				unit = "sem";
			} else if (diffMilliseconds > DAY) {
				divider = DAY;
				unit = "dia";
			} else if (diffMilliseconds > HOUR) {
				divider = HOUR;
				unit = "h";
			} else if (diffMilliseconds > MINUTE) {
				divider = MINUTE;
				unit = "min";
			} else if (diffMilliseconds > SECOND) {
				divider = SECOND;
				unit = "seg";
			} else {
				// ...
			}
			
			int result = (int) (diffMilliseconds / divider);
			String humanReadableDate;
			
			if (future) {
				humanReadableDate = "daqui a "+result + unit;
			} else {
				humanReadableDate = result + unit + " atrás";
			}
			
			System.out.println(humanReadableDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}