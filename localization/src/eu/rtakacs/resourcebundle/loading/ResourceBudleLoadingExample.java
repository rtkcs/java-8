package eu.rtakacs.resourcebundle.loading;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBudleLoadingExample {
	
	public static void loadResourceBundle(Locale locale) {
		ResourceBundle rb = ResourceBundle.getBundle("eu.rtakacs.resourcebundle.loading.Messages", locale);
		System.out.println(rb.getString("hello"));
		
		System.out.println("---- Print all labels and keys from resource bundle");
		Enumeration<String> enumeration = rb.getKeys();
		while(enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String value = rb.getString(key);
			System.out.println(key + " = " + value);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		System.out.println("---- Messages.properties will be never loaded, because Messages.java list resource bundle has priority");
		System.out.println();
		
		loadResourceBundle(new Locale.Builder().setLanguageTag("de").setRegion("DE").build());
		loadResourceBundle(new Locale("de", "DE"));
		loadResourceBundle(new Locale("DE", "de"));
		loadResourceBundle(new Locale("de"));
		loadResourceBundle(Locale.GERMAN);
		loadResourceBundle(Locale.GERMANY);
		loadResourceBundle(Locale.ROOT);
		loadResourceBundle(Locale.US);
	}

}
