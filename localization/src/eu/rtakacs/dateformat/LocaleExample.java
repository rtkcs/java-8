package eu.rtakacs.dateformat;

import java.util.Locale;

public class LocaleExample {

	public static void printLocale(String description, Locale locale) {

		System.out.println();
		System.out.println("--------------" + description);
		System.out.println("Locale.toString = " + locale.toString());
		System.out.println("Locale.getLanguage = " + locale.getLanguage());
		System.out.println("Locale.getCountry = " + locale.getCountry());
		System.out.println("Locale.getVariant = " + locale.getVariant());
		System.out.println("Locale.getDisplayCountry = " + locale.getDisplayCountry());
		System.out.println("Locale.getDisplayLanguage = " + locale.getDisplayLanguage());
		System.out.println("Locale.getDisplayName = " + locale.getDisplayName());
		System.out.println("Locale.getDisplayScript = " + locale.getDisplayScript());
		System.out.println("Locale.getISO3Country = " + locale.getISO3Country());
		System.out.println("Locale.getISO3Language = " + locale.getISO3Language());
		System.out.println("Locale.getScript = " + locale.getScript());

		// System.out.println("Locale.getLanguage = " + locale2.get);
		// System.out.println("Locale.getLanguage = " + locale2.get);
		// System.out.println("Locale.getLanguage = " + locale2.get);
		System.out.println();

	}

	public static void main(String[] args) {
		
		Locale locale = Locale.getDefault();
		LocaleExample.printLocale("Locale.getDefault", locale);
		Locale locale2 = Locale.forLanguageTag("sk");
		LocaleExample.printLocale("Locale.forLanguage('sk')", locale2);
		
		Locale localeDisplay = Locale.getDefault(Locale.Category.DISPLAY);
		Locale localeFormat = Locale.getDefault(Locale.Category.FORMAT);
		printLocale("Category.DISPLAY", localeDisplay);
		printLocale("Category.FORMAT", localeFormat);
	}

}
