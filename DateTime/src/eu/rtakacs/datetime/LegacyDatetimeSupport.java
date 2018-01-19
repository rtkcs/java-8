package eu.rtakacs.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class LegacyDatetimeSupport {
	
	public static void main(String[] args) {
			
		// Date -> Instant
		Instant timestamp = new Date().toInstant();
		LocalDateTime date = LocalDateTime.ofInstant(timestamp, ZoneId.of(ZoneId.SHORT_IDS.get("ECT")));
		System.out.println("Date = " + date);
		
		//Calendar -> Instant
		Instant time = Calendar.getInstance().toInstant();
		System.out.println(time);
		
		//TimeZone -> ZoneId
		ZoneId defaultZone = TimeZone.getDefault().toZoneId();
		System.out.println(defaultZone);
		
		ZonedDateTime gregorianCalendarDateTime = new GregorianCalendar().toZonedDateTime();
		System.out.println(gregorianCalendarDateTime);
		
		Date dt = Date.from(Instant.now());
		System.out.println(dt);
		
		TimeZone tz = TimeZone.getTimeZone(defaultZone);
		System.out.println(tz);
		
		GregorianCalendar gCalendar = GregorianCalendar.from(gregorianCalendarDateTime);
		System.out.println(gCalendar);
	}
}
