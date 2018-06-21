package eu.rtakacs.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertyResourceBundleExample {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("fr","CA"));
//		Locale.setDefault(new Locale("en","US"));
		Locale l = new Locale("jp","JP");
//		Locale l = new Locale("en");
		ResourceBundle rb = ResourceBundle.getBundle("appmessagess",l);
		String s = rb.getString("greeting");
		System.out.println(s);
	}

}
