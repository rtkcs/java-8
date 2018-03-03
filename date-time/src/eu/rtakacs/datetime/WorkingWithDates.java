package eu.rtakacs.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import eu.rtakacs.datetime.temporal.NextWorkingDay;

public class WorkingWithDates {

	public static void main(String[] args) {
		
		LocalDate date1 = LocalDate.of(2014, 3, 18);				//2014-03-18
		LocalDate date2 = date1.withYear(2011);						//2011-03-18
		LocalDate date3 = date2.withDayOfMonth(25);					//2011-03-25
		LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);	//2011-09-25
		
		LocalDate date5 = date1.plusWeeks(1);
		LocalDate date6 = date5.minusYears(3);
		LocalDate date7 = date6.plus(6, ChronoUnit.MONTHS);
		
		
		LocalDate date = LocalDate.of(2014, 3, 18);
		date = date.with(ChronoField.MONTH_OF_YEAR, 9);
		date = date.plusYears(2).minusDays(10);
		date.withYear(2011);
		System.out.println(date);//2016-09-8
		
		
		//Temporal Adjusters
		LocalDate date10 = LocalDate.of(2014, 3, 18);									//2014-03-18
		LocalDate date11 = date10.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));	//2014-03-23
		LocalDate date12 = date11.with(TemporalAdjusters.lastDayOfMonth());				//2014-03-31
		
		
		LocalDate date20 = LocalDate.of(2017, 9, 18);			//Monday
		LocalDate date21 = date20.with(new NextWorkingDay());	//Tuesday
		LocalDate date22 = LocalDate.of(2017, 9, 22);		 	//Friday
		LocalDate date23 = date22.with(new NextWorkingDay());	//Moday
		
		LocalDate date24 = date22.with(temporal ->{
			DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
			int dayToAdd = 1;
			if(dow==DayOfWeek.FRIDAY) dayToAdd = 3;
			else if(dow==DayOfWeek.SATURDAY) dayToAdd = 2;
			return temporal.plus(dayToAdd, ChronoUnit.DAYS);
		});
		
		TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
				temporal ->{
					DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
					int dayToAdd = 1;
					if(dow==DayOfWeek.FRIDAY) dayToAdd = 3;
					if(dow==DayOfWeek.SATURDAY) dayToAdd = 2;
					return temporal.plus(dayToAdd, ChronoUnit.DAYS);
				});
		LocalDate date25 = date22.with(nextWorkingDay);
		
		
	}

}
