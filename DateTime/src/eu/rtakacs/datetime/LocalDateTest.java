package eu.rtakacs.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateTest {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of(2014, 3, 18);
		int year = date.getYear();
		Month month = date.getMonth();
		int day = date.getDayOfMonth();
		DayOfWeek dow = date.getDayOfWeek();
		int len = date.lengthOfMonth();
		boolean leap = date.isLeapYear();
		
		LocalDate today = LocalDate.now();
		
		//reading LodalDate values using a TemporalField
		int yearToday = today.get(ChronoField.YEAR);
		int monthToday = today.get(ChronoField.MONTH_OF_YEAR);
		int dayToday = today.get(ChronoField.DAY_OF_MONTH);
		
		
		LocalTime time = LocalTime.of(13, 45, 20);
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();
		
		
		LocalDate date1 = LocalDate.parse("2014-06-18");
		LocalTime time1 = LocalTime.parse("13:45:20");
		
		//creating LocalDateTime directly or by combining a date and time
		LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
		LocalDateTime dt2 = LocalDateTime.of(date1, time1);
		LocalDateTime dt3 = date1.atTime(13, 45, 20);
		LocalDateTime dt4 = date1.atTime(time1);
		LocalDateTime dt5 = time1.atDate(date1);
		
		LocalDate date2  = dt1.toLocalDate();
		LocalTime time2 = dt1.toLocalTime();
		
		//Instant
		Instant inst1 = Instant.ofEpochSecond(3);
		//these 3 are the same
		Instant inst2 = Instant.ofEpochSecond(3, 0);
		Instant inst3 = Instant.ofEpochSecond(2, 1_000_000_000);
		Instant inst4 = Instant.ofEpochSecond(4, -1_000_000_000);
		
		Instant inst5 = Instant.ofEpochSecond(4, -999_999_999);
		Instant inst6 = Instant.ofEpochSecond(2, 1000_000_001);
		
//		int dayInst1 = Instant.now().get(ChronoField.DAY_OF_MONTH);
		
		//Duration
		Duration d1 = Duration.between(time1, time2);
		Duration d2 = Duration.between(dt1, dt2);
		Duration d3 = Duration.between(inst1, inst2);
		
		//Period
		Period tenDays = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
		
		Duration minutes3 = Duration.ofMinutes(3);
		Duration minutes31 = Duration.of(3, ChronoUnit.MINUTES);
		
		Period days10 = Period.ofDays(10);
		Period weeks3 = Period.ofWeeks(3);
		Period yers2Months6day1 = Period.of(2, 6, 1);
		
	}

}
