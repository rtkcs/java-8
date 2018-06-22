package eu.rtakacs.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ListResourceBundleExample {

	public static void main(String[] args) {
		
		Locale locale = new Locale("fr");
		ResourceBundle rb;
		rb = ResourceBundle.getBundle("eu.rtakacs.resourcebundle.MyResources", locale);
//		rb = ResourceBundle.getBundle("eu.rtakacs.resourcebundle.MyResources");
		String s1 = rb.getString("s1");
		Dimension d = (Dimension)rb.getObject("s8");
		
		System.out.println(s1);
		System.out.println(d);
	}
}
