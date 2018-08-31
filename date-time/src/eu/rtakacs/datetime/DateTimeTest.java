package eu.rtakacs.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DateTimeTest {

	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		System.out.println("Current Date = " + today);
		
		LocalDate firstDay2018 = LocalDate.of(2019, Month.JANUARY, 1);
		firstDay2018 = LocalDate.of(2019, 1, 1);
		System.out.println("Specifig date = " + firstDay2018);
		
		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in Asia/Kolkata = " + todayKolkata);
		
		//Getting date from the base date 01/01/1970
		LocalDate dateFromBase = LocalDate.ofEpochDay(365);
		System.out.println(dateFromBase);
		
		LocalDate hundredDay2017 = LocalDate.ofYearDay(2017, 100);
		System.out.println("100th day of 2017 = " + hundredDay2017);
		
		
		System.out.println( "First Day of Month = " + hundredDay2017.with(TemporalAdjusters.firstDayOfMonth()) );
		System.out.println( "Last Day of Month  = " + hundredDay2017.with(TemporalAdjusters.lastDayOfMonth()) );
		System.out.println( "Last Day of Year   = " + hundredDay2017.with(TemporalAdjusters.lastDayOfYear()) );
		
		
		//ZoneIds
		System.out.println();
		System.out.println("------- All zone ids: -------");
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		String[] zoneIds = new String[allZoneIds.size()];
		allZoneIds.toArray(zoneIds);
		List<String> l = new LinkedList<>();
		for(String s : allZoneIds) {
			l.add(s);
		}
		Collections.sort(l);
		
		
		for(String s : l) {
			System.out.println(s);
		}
		
		
	}

}
