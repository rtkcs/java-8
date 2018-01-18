package eu.rtakacs.datetime.enthuware;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTime {

	public static void main(String[] args) {
		
		Duration d = Duration.ofHours(25);
		System.out.println(d);
		Period p =  Period.ofDays(1);
		System.out.println(p);
		
		Instant instNow = Instant.now();
		System.out.println(instNow);
//		
//		
		LocalDateTime greatDay = LocalDateTime.parse("2015-01-01");
		String greatDayStr = greatDay.format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(greatDayStr);

	}

}
