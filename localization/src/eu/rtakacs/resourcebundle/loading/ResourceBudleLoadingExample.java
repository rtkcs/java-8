package eu.rtakacs.resourcebundle.loading;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBudleLoadingExample {
	
	public static void loadResourceBundle(Locale locale) {
		ResourceBundle rb = ResourceBundle.getBundle("eu.rtakacs.resourcebundle.loading.Messages", locale);
		System.out.println(rb.getString("hello"));
	}
	
	public static void main(String[] args) {
		
		System.out.println("---- Messages.properties will be never loaded, because Messages.java list resource bundle has priority");
		System.out.println();

		loadResourceBundle(new Locale("de", "DE"));
		loadResourceBundle(new Locale("de"));
		loadResourceBundle(Locale.GERMAN);
		loadResourceBundle(Locale.GERMANY);
		loadResourceBundle(Locale.ROOT);
		loadResourceBundle(Locale.US);

	}

}
