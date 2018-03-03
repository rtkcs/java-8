package eu.rtakacs.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DayLightSavingTest {

	public static void main(String[] args) {
			
		//change of summer time to winter time
		LocalDateTime ldtSummer = LocalDateTime.of(2017, 10, 28, 20, 00);
		ZonedDateTime zdtSummer = ZonedDateTime.of(ldtSummer, ZoneId.systemDefault());
		
		Duration duration1Day = Duration.ofDays(1);
		Period period1Day = Period.ofDays(1);
		System.out.println("Duration 1 day = " + duration1Day);
		System.out.println("Period   1 day = " + period1Day);
		
		ZonedDateTime dayAfterSummer1 = zdtSummer.plus(duration1Day);
		ZonedDateTime dayAfterSummer2 = zdtSummer.plus(period1Day);
		ZonedDateTime dayAfterSummer3 = zdtSummer.plusDays(1);
		
		System.out.println();
		System.out.println("-------change of summer time to winter time:	Sunnday: 29. October 2017, 3:00 -> 2:00");
		System.out.println(zdtSummer);
		System.out.println("+1 day with Duration    = " + dayAfterSummer1);
		System.out.println("+1 day with Period      = " + dayAfterSummer2);
		System.out.println("+1 day with plusDays(1) = " + dayAfterSummer3);//like Period
		
		System.out.println("Duration between " + zdtSummer + ", " + dayAfterSummer1 + " = " + Duration.between(zdtSummer, dayAfterSummer1));
		System.out.println("Duration between " + zdtSummer + ", " + dayAfterSummer2 + " = " + Duration.between(zdtSummer, dayAfterSummer2));
		System.out.println("Period   between " + zdtSummer.toLocalDate() + ", " + dayAfterSummer1.toLocalDate() + " = " + Period.between(zdtSummer.toLocalDate(), dayAfterSummer1.toLocalDate()));
		System.out.println("Period   between " + zdtSummer.toLocalDate() + ", " + dayAfterSummer2.toLocalDate() + " = " + Period.between(zdtSummer.toLocalDate(), dayAfterSummer2.toLocalDate()));
		
		System.out.println();
		System.out.println("equals, isAfter, isBefore, isEqual");
		System.out.println("zdtSummer.equals(dayAfterSummer1)   " + zdtSummer.equals(dayAfterSummer1) + "; zdtSummer = " + zdtSummer + ", dayAfterSummer1 = " + dayAfterSummer1);
		System.out.println("zdtSummer.isAfter(dayAfterSummer1)  " + zdtSummer.isAfter(dayAfterSummer1) + "; zdtSummer = " + zdtSummer + ", dayAfterSummer1 = " + dayAfterSummer1);
		System.out.println("zdtSummer.isBefore(dayAfterSummer1) " + zdtSummer.isBefore(dayAfterSummer1) + ";  zdtSummer = " + zdtSummer + ", dayAfterSummer1 = " + dayAfterSummer1);
		System.out.println("zdtSummer.isEqual(dayAfterSummer1)  " + zdtSummer.isEqual(dayAfterSummer1) + "; zdtSummer = " + zdtSummer + ", dayAfterSummer1 = " + dayAfterSummer1);
		
		
		
		//change of winter time to summer time
		LocalDateTime ldtWinter = LocalDateTime.of(2018, 3, 24, 20, 00);
		ZonedDateTime zdtWinter = ZonedDateTime.of(ldtWinter, ZoneId.systemDefault());
		
		ZonedDateTime dayAfterWinter1 = zdtWinter.plus(duration1Day);
		ZonedDateTime dayAfterWinter2 = zdtWinter.plus(period1Day);
		ZonedDateTime dayAfterWinter3 = zdtWinter.plusDays(1);
		
		System.out.println();
		System.out.println("-------change of winter time to summer time:	Sunnday: 25. March 2018, 2:00 -> 3:00");
		System.out.println(zdtWinter);
		System.out.println("+1 day with Duration    = " + dayAfterWinter1);
		System.out.println("+1 day with Period      = " + dayAfterWinter2);
		System.out.println("+1 day with plusDays(1) = " + dayAfterWinter3);//like Period
		
		//Offset Date Time
		System.out.println();
		System.out.println("-------OffsetDateTime 	change of winter time to summer time:	Sunnday: 25. March 2018, 2:00 -> 3:00");
		OffsetDateTime odtWinter = OffsetDateTime.of(2018, 3, 24, 20, 00, 00, 00, ZoneOffset.ofHours(1));
		OffsetDateTime ostAfterWinter1 = odtWinter.plus(duration1Day);
		OffsetDateTime ostAfterWinter2 = odtWinter.plus(period1Day);
		OffsetDateTime ostAfterWinter3 = odtWinter.plusDays(1);
		System.out.println("+1 day with Duration    = " + ostAfterWinter1);
		System.out.println("+1 day with Period      = " + ostAfterWinter2);
		System.out.println("+1 day with plusDays(1) = " + ostAfterWinter3);
	}

}
