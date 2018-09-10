package eu.rtakacs.datetime.enthuware;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DaylightSavingsTime {

	public static void main(String[] args) {
		
		///
		/// Given that daylight Savings Time ends on Nov 1 at 2 AM in US/Eastern time zone. 
		/// (As a result, 2 AM becomes 1 AM.), 
		/// what will the following code print?
		///
		LocalDateTime ldt1 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 2, 0);
		ZonedDateTime zdt1 = ZonedDateTime.of(ldt1, ZoneId.of("US/Eastern"));
		LocalDateTime ldt2 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0);
		ZonedDateTime zdt2 = ZonedDateTime.of(ldt2, ZoneId.of("US/Eastern"));
		
		long x = ChronoUnit.HOURS.between(zdt1, zdt2);
		System.out.println(x);
		
		long y = ChronoUnit.HOURS.between(zdt2, zdt1);
		System.out.println(y);
		
		
		///
		/// Given that daylight Savings Time starts on March 8th at 2 AM in US/Eastern time zone. 
		/// (As a result, 2 AM becomes 3 AM.), 
		/// what will the following code print?
		///
		
		LocalDateTime ld1 = LocalDateTime.of(2015, Month.MARCH, 8, 2, 0); 
		ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern")); 
		LocalDateTime ld2 = LocalDateTime.of(2015, Month.MARCH, 8, 3, 0); 
		ZonedDateTime zd2 = ZonedDateTime.of(ld2, ZoneId.of("US/Eastern")); 
		
		long xx = ChronoUnit.HOURS.between(zd1, zd2); 
		System.out.println(xx);
		
		long yy = ChronoUnit.HOURS.between(zd2, zd1);
		System.out.println(yy);
		
		
	}

}
