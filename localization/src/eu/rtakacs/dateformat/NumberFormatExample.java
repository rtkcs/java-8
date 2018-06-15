package eu.rtakacs.dateformat;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

public class NumberFormatExample {
	
	public static void printNumberFormat(NumberFormat nf) {
		System.out.println("");
		System.out.println("NumberFormat " + nf.toString());
		System.out.println("getMaximumFractionDigits = " + nf.getMaximumFractionDigits());
		System.out.println("getMinimumFractionDigits = " + nf.getMinimumFractionDigits());
		System.out.println("getMaximumIntegerDigits = " + nf.getMaximumIntegerDigits());
		System.out.println("getMinimumIntegerDigits = " + nf.getMinimumIntegerDigits());
		System.out.println("isParseIntegerOnly = " + nf.isParseIntegerOnly());
		System.out.println("getCurrency = " + nf.getCurrency());
		System.out.println("getRoundingMode = " + nf.getRoundingMode());
		System.out.println("isGroupingUsed = " + nf.isGroupingUsed());
		System.out.println(nf.format(123456.789));

		
	}
	
	public static void main(String[] args) {
		
		System.out.println("getAvailableLocales = " + Arrays.asList( NumberFormat.getAvailableLocales() ));
		
		
		
		Locale localeGermany = Locale.GERMANY;
		Locale localeDe = new Locale("de");
		Locale localeSk = new Locale("sk");
		Currency currencyDe = Currency.getInstance(localeGermany);
//		Currency currencySk = Currency.getInstance("sk");
		
		NumberFormat nf1 = NumberFormat.getInstance();
		printNumberFormat(nf1);
		
		
		NumberFormat nf2 = NumberFormat.getInstance(localeDe);
		printNumberFormat(nf2);
		
		NumberFormat nf3 = NumberFormat.getInstance(localeSk);
		printNumberFormat(nf3);
		
		NumberFormat ci1 = NumberFormat.getCurrencyInstance();
//		ci1.setCurrency(currencySk);
		printNumberFormat(ci1);
		
		NumberFormat ci2 = NumberFormat.getCurrencyInstance(localeDe);
		printNumberFormat(ci2);
		
		NumberFormat ii1 = NumberFormat.getIntegerInstance();
		NumberFormat ii2 = NumberFormat.getIntegerInstance(localeDe);
		
		NumberFormat pi1 = NumberFormat.getPercentInstance();
		NumberFormat pi2 = NumberFormat.getPercentInstance(localeDe);
	}

}
