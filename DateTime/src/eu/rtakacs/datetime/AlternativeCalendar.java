package eu.rtakacs.datetime;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.IsoChronology;
import java.time.chrono.JapaneseDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import eu.rtakacs.Helper;

public class AlternativeCalendar {
	
	public static void main(String[] args){
		
		Helper.print("Japanese Date");
		LocalDate date = LocalDate.now();
		JapaneseDate japaneseDate = JapaneseDate.from(date);
		System.out.println("Japanese Date = " + japaneseDate);
		
		Chronology japaneseChronology = Chronology.ofLocale(Locale.JAPAN);
		ChronoLocalDate now = japaneseChronology.dateNow();
		System.out.println(now);
		System.out.println(japaneseChronology);
		
		Helper.print("Islamic calendar");
		HijrahDate ramadanDate = HijrahDate.now()
									.with(ChronoField.DAY_OF_MONTH,1)
									.with(ChronoField.MONTH_OF_YEAR, 9);
		System.out.print("Ramadan starts on " + IsoChronology.INSTANCE.date(ramadanDate));
		System.out.println(" and ends on " + IsoChronology.INSTANCE.date(ramadanDate).with(TemporalAdjusters.lastDayOfMonth()));
	}
}
