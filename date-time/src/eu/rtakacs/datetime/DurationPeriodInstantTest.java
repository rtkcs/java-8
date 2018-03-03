package eu.rtakacs.datetime;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;


public class DurationPeriodInstantTest {

	public static void main(String[] args) {
		
		System.out.println("-------- Duration --------");
		System.out.println("Duration 3650 seconds    = " + Duration.ofSeconds(3650));
		System.out.println("Duration 2.5 seconds     = " + Duration.ofSeconds(2, 500_000_000));
		System.out.println("Duration 10 minutes      = " + Duration.ofMinutes(10));
		System.out.println("Duration 10 hour         = " + Duration.ofHours(10));
		System.out.println("Duration 12 days         = " + Duration.ofDays(12));
		System.out.println("Duration 99_999_999 days = " + Duration.of(99_999_999, ChronoUnit.DAYS));
		System.out.println("Duration -3650 seconds    = " + Duration.ofSeconds(-3650));
		
		
		System.out.println();
		System.out.println("-------- Period --------");
		System.out.println("Period 0 days    = " + Period.ofDays(0));
		System.out.println("Period.from(Period.ZERO) = " + Period.from(Period.ZERO)); 
		System.out.println("Period 33 days    = " + Period.ofDays(33));
		System.out.println("Period 3 weeks    = " + Period.ofWeeks(3));
		System.out.println("Period 6 weeks    = " + Period.ofWeeks(6));
		System.out.println("Period 58 months  = " + Period.ofMonths(58));
		System.out.println("Period 5 years    = " + Period.ofYears(2));
		System.out.println("Period 365 years  = " + Period.ofYears(356));
		System.out.println("Periond 10Y 5M 3D = " + Period.of(10, 5, 3));
		System.out.println("Period.ofDays(1) = " +Period.ofMonths(1).ofDays(1));
		
		LocalDate ld = LocalDate.now();
		LocalDate ld1M3D = ld.plus(Period.of(0, 1, 3));
		System.out.println(ld1M3D);
		
		
		System.out.println();
		System.out.println("-------- Instant --------");
		System.out.println("Instant.MIN = " + Instant.MIN);
		System.out.println("Instant.MAX = " + Instant.MAX);
		System.out.println("Instant.EPOCH = " + Instant.EPOCH);
		System.out.println("Instant.now = " + Instant.now());
		System.out.println(Instant.parse("2017-10-20T13:27:30.00Z"));
		System.out.println("Instant.now().truncatedTo(ChronoUnit.DAYS) = " + Instant.now().truncatedTo(ChronoUnit.DAYS));
		System.out.println("Instant.now().truncatedTo(ChronoUnit.HOURS)= " + Instant.now().truncatedTo(ChronoUnit.HOURS));
		
		Instant instant13Days = Instant.now().plus(7, ChronoUnit.DAYS);
		System.out.println("HalfDays from now = " + Instant.now().until(instant13Days, ChronoUnit.HALF_DAYS));
		System.out.println("Hours    from now = " + Instant.now().until(instant13Days, ChronoUnit.HOURS));
		
		
		
		System.out.println();
		System.out.println("-------- Clock --------");
		Clock clock = Clock.systemUTC();
		System.out.println( clock.instant() );
		Clock clock2H = Clock.offset(clock, Duration.ofHours(2));
		System.out.println(clock2H.instant());
	}
}
