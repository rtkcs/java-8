package eu.rtakacs.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {
	
	public static void main(String[] args) {
		
		System.out.println("------- LocalDate Formatted -------");
		LocalDate date = LocalDate.now();
		System.out.println("Default format of LocalDate   = " + date);
		System.out.println("Custom formatter d::MMM::uuuu = " + date.format( DateTimeFormatter.ofPattern("d::MMM::uuuu")) );
		System.out.println("Formatter BASIC_ISO_DATE      = " + date.format( DateTimeFormatter.BASIC_ISO_DATE) );
		System.out.println("Formatter ISO_DATE            = " + date.format( DateTimeFormatter.ISO_DATE) );
//		System.out.println("Formatter ISO_TIME = " + date.format( DateTimeFormatter.ISO_DATE_TIME) );//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: HourOfDay
		System.out.println("Formatter ISO_LOCAL_DATE      = " + date.format( DateTimeFormatter.ISO_LOCAL_DATE) );
		System.out.println("Formatter ISO_WEEK_DATE       = " + date.format( DateTimeFormatter.ISO_WEEK_DATE) );

		
		System.out.println();
		System.out.println("------- LocalDateTime Formatted -------");
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("Default format of LocalDate   = " + dateTime);
		System.out.println("Custom formatter d::MMM::uuuu = " + dateTime.format( DateTimeFormatter.ofPattern("d::MMM::uuuu")) );
		System.out.println("Custom formatter d::MMM::uuuu HH::mm::ss = " + dateTime.format( DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")) );
		System.out.println("Custom formatter uuuu-MM-dd HH:mm:ss = " + dateTime.format( DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")) );
		System.out.println("Formatter BASIC_ISO_DATE      = " + dateTime.format( DateTimeFormatter.BASIC_ISO_DATE) );
		System.out.println("Formatter ISO_DATE            = " + dateTime.format( DateTimeFormatter.ISO_DATE) );
		System.out.println("Formatter ISO_DATE_TIME       = " + dateTime.format( DateTimeFormatter.ISO_DATE_TIME) );
//		System.out.println("Formatter ISO_DATE_TIME       = " + dateTime.format( DateTimeFormatter.ISO_INSTANT) );//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: InstantSeconds
		System.out.println("Formatter ISO_LOCAL_DATE      = " + dateTime.format( DateTimeFormatter.ISO_LOCAL_DATE) );
		System.out.println("Formatter ISO_LOCAL_DATE_TIME = " + dateTime.format( DateTimeFormatter.ISO_LOCAL_DATE_TIME) );
		System.out.println("Formatter ISO_LOCAL_TIME      = " + dateTime.format( DateTimeFormatter.ISO_LOCAL_TIME) );
//		System.out.println("Formatter ISO_LOCAL_TIME      = " + dateTime.format( DateTimeFormatter.ISO_OFFSET_DATE) );//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds
		System.out.println("Formatter ISO_WEEK_DATE       = " + dateTime.format( DateTimeFormatter.ISO_WEEK_DATE) );
//		System.out.println("Formatter ISO_WEEK_DATE       = " + dateTime.format( DateTimeFormatter.ISO_ZONED_DATE_TIME) );//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds
//		System.out.println("Formatter ISO_WEEK_DATE       = " + dateTime.format( DateTimeFormatter.RFC_1123_DATE_TIME) );
		
		System.out.println();
		System.out.println("------- OffsetDateTime Formatted -------");
		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		System.out.println("Default format of LocalDate   = " + offsetDateTime);
		System.out.println("Custom formatter d::MMM::uuuu = " + offsetDateTime.format( DateTimeFormatter.ofPattern("d::MMM::uuuu")) );
		System.out.println("Formatter BASIC_ISO_DATE      = " + offsetDateTime.format( DateTimeFormatter.BASIC_ISO_DATE) );
		System.out.println("Formatter ISO_DATE            = " + offsetDateTime.format( DateTimeFormatter.ISO_DATE) );
		System.out.println("Formatter ISO_DATE_TIME       = " + offsetDateTime.format( DateTimeFormatter.ISO_DATE_TIME) );
		System.out.println("Formatter ISO_INSTANT         = " + offsetDateTime.format( DateTimeFormatter.ISO_INSTANT) );//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: InstantSeconds
		System.out.println("Formatter ISO_LOCAL_DATE      = " + offsetDateTime.format( DateTimeFormatter.ISO_LOCAL_DATE) );
		System.out.println("Formatter ISO_LOCAL_DATE_TIME = " + offsetDateTime.format( DateTimeFormatter.ISO_LOCAL_DATE_TIME) );
		System.out.println("Formatter ISO_LOCAL_TIME      = " + offsetDateTime.format( DateTimeFormatter.ISO_LOCAL_TIME) );
		System.out.println("Formatter ISO_OFFSET_DATE     = " + offsetDateTime.format( DateTimeFormatter.ISO_OFFSET_DATE) );
		System.out.println("Formatter ISO_OFFSET_DATE_TIME= " + offsetDateTime.format( DateTimeFormatter.ISO_OFFSET_DATE_TIME) );
		System.out.println("Formatter ISO_OFFSET_TIME     = " + offsetDateTime.format( DateTimeFormatter.ISO_OFFSET_TIME) );
		System.out.println("Formatter ISO_ORDINAL_DATE    = " + offsetDateTime.format( DateTimeFormatter.ISO_ORDINAL_DATE) );
		System.out.println("Formatter ISO_TIME            = " + offsetDateTime.format( DateTimeFormatter.ISO_TIME) );
		System.out.println("Formatter ISO_WEEK_DATE       = " + offsetDateTime.format( DateTimeFormatter.ISO_WEEK_DATE) );
		System.out.println("Formatter ISO_ZONED_DATE_TIME = " + offsetDateTime.format( DateTimeFormatter.ISO_ZONED_DATE_TIME) );//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds
		System.out.println("Formatter RFC_1123_DATE_TIME  = " + offsetDateTime.format( DateTimeFormatter.RFC_1123_DATE_TIME) );

		System.out.println();
		System.out.println("------- Instant Formatted -------");		
		Instant timestamp = Instant.now();
		System.out.println("Default format of Instant = " + timestamp);
		
		System.out.println();
		System.out.println("------- Parse Example -------");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss");
		LocalDateTime dt = LocalDateTime.parse("23::okt::2017 13::57::48", dtf);
		System.out.println(dt);
		
		System.out.println();
		System.out.println("------- Calling Function -------");		
		System.out.println(formatDate(ZonedDateTime.now()));
		
		
		
	}
	
	public static String formatDate(ZonedDateTime ldt) {
		return DateTimeFormatter.ISO_ZONED_DATE_TIME.format(ldt);
	}
}
