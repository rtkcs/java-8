package eu.rtakacs.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.TimeZone;

import eu.rtakacs.Helper;

public class TimeZonesCalendars {
	
	public static void main(String[] args){
		
		Helper.print("ZoneId, ZonedDateTime");
		ZoneId romeZone = ZoneId.of("Europe/Rome");
		ZoneId zoneId = TimeZone.getDefault().toZoneId();
		
		LocalDate date = LocalDate.of(2017, 9, 20);
		ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
		System.out.println(zdt1);
		
		LocalDateTime dateTime = LocalDateTime.of(2017, 9, 20, 21, 46, 37);
		ZonedDateTime zdt2 = dateTime.atZone(romeZone);
		System.out.println(zdt2);
		
		Helper.print("Instant -> ZonedDateTime");
		Instant instant = Instant.now();
		ZonedDateTime zdt3 = instant.atZone(romeZone);
		ZonedDateTime zdt4 = instant.atZone(zoneId);
		System.out.println("ZonedDateTime, Rome   = " + zdt3);
		System.out.println("ZonedDatetime, Prague = " + zdt4);
		
		//convert LocalDateTime -> Instant by using ZoneId
		Helper.print("convert LocalDateTime -> Instant by using ZoneId");
		LocalDateTime dateTime2 = LocalDateTime.of(2017, Month.SEPTEMBER, 20, 21, 52, 48);
		ZoneOffset offset = ZoneOffset.ofHours(2);
		Instant instantFromDateTime = dateTime2.toInstant(offset);
		Instant instantFromDateTime2 = dateTime2.toInstant((ZoneOffset)romeZone);
		System.out.println("Instant from DateTime = " + instantFromDateTime);
		System.out.println("Instant from DateTime = " + instantFromDateTime2);
		
		
		//ZoneOffset
		Helper.print("offset");
		ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
		LocalDateTime dateTime3 = LocalDateTime.now();
		OffsetDateTime dateTimeNewYork = OffsetDateTime.of(dateTime3, newYorkOffset);
		System.out.println("Now = " + dateTime3);
		System.out.println("New York = " + dateTimeNewYork);
	
	}
}
