package eu.rtakacs.dateformat;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DateFormatExample {
	

	
	public static void main(String[] args) {
		
		Date date = new Date();
		Locale locale = Locale.getDefault();
		Locale locale2 = Locale.forLanguageTag("sk");
		LocaleExample.printLocale("Locale.getDefault()", locale);
		LocaleExample.printLocale("Locale.forLanguageTag(\"sk\")", locale2);

		
		DateFormat df1 = DateFormat.getDateInstance();
		DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL);//SHORT, MEDIUM, LONG, FULL
		DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMAN);
		
		
		System.out.println();
		System.out.println("-- date");
		System.out.println(df1.format(date));
		System.out.println(df2.format(date));
		System.out.println(df3.format(date));
		

		
		DateFormat df4 = DateFormat.getTimeInstance();
		DateFormat df5 = DateFormat.getTimeInstance(DateFormat.FULL);
		DateFormat df6 = DateFormat.getTimeInstance(DateFormat.FULL, Locale.GERMAN);
		
		System.out.println();
		System.out.println("-- time");
		System.out.println(df4.format(date));
		System.out.println(df5.format(date));
		System.out.println(df6.format(date));

		
		DateFormat df7 = DateFormat.getDateTimeInstance();
		DateFormat df8 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
		DateFormat df9 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.GERMAN);
		
		System.out.println();
		System.out.println("-- dateTime");
		System.out.println(df7.format(date));
		System.out.println(df8.format(date));
		System.out.println(df9.format(date));		
		
		System.out.println();
		System.out.println(df1.getCalendar().getTime());
		
		String s = df1.format(date);
 
		try {
			Date d = df1.parse(s);
			System.out.println(df5.format(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
