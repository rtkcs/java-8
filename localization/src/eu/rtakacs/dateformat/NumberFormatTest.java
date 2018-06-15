package eu.rtakacs.dateformat;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {

	public static void main(String[] args) {
		
		double amount = 12345.789;
		Locale localeFr = new Locale("fr","FR");
		NumberFormat nf = NumberFormat.getInstance(localeFr);
		String s = nf.format(amount);
		nf = NumberFormat.getInstance();
		
		Number amount2 = null;
		try {
			amount2 = nf.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Amount = " + amount);
		System.out.println("Amount Formatted fr FR = " + s);
		System.out.println("Amount Parsed = " + amount2);
	}

}
