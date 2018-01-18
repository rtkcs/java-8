package eu.rtakacs.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class PrintingParsingDateTime {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.now();
		System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));	//20170919
		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));	//2017-09-19
		
		LocalDate date1 = LocalDate.parse("20170918", DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(date1);
		LocalDate date2 = LocalDate.parse("2017-09-18", DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println(date2);
		
		//creating a DateTimeFormatter from pattern
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date3 = LocalDate.of(2017, 9, 20);
		String formattedDate = date3.format(formatter);
		System.out.println("Formatted date = " + formattedDate);
		
		LocalDate date4 = LocalDate.parse(formattedDate,formatter);
		
		//creating a localized DateTimeeFormatter
		DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d.MMMM yyyy", Locale.ITALIAN);
		LocalDate date5 = LocalDate.of(2017, 9, 20);
		String formattedDate2 = date5.format(italianFormatter);
		System.out.println("Formatted Italian Date = " + formattedDate2);
		
		LocalDate date6 = LocalDate.parse(formattedDate2, italianFormatter);
		
		//building a DateTimeFormatter
		DateTimeFormatter italianFormatter2 = new DateTimeFormatterBuilder()
				.appendText(ChronoField.DAY_OF_MONTH)
				.appendLiteral(".")
				.appendText(ChronoField.MONTH_OF_YEAR)
				.appendLiteral(" ")
				.appendText(ChronoField.YEAR)
				.parseCaseInsensitive()
				.toFormatter(Locale.ITALIAN);
		String formattedDate3 = date5.format(italianFormatter2);
		System.out.println("Builded Formatted Italian Date = " + formattedDate3);
		
	}

}
