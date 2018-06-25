package eu.rtakacs.resourcebundle;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class PropertyResourceBundleExample {

	public static void main(String[] args) {
		
		//
		//--- load resource bundle property file from folder "resources" 
		//

		System.out.println("--- load resource bundle property file from folder 'resources'");
		Locale.setDefault(new Locale("en","US"));
		Locale l = new Locale("jp","JP");

		ResourceBundle rb; 
		rb =ResourceBundle.getBundle("appmessages",l);
		System.out.println( "BaseBundleName = " + rb.getBaseBundleName());
		String s = rb.getString("greeting");
		System.out.println(s);
		
		System.out.println();
		
		//
		//--- load resource bundle property file from eu.rtakacs.resourcebundle
		//
		System.out.println("--- load resource bundle property file from eu.rtakacs.resourcebundle");
		rb = ResourceBundle.getBundle("eu.rtakacs.resourcebundle.appmessages");
		Enumeration<String> keys = rb.getKeys();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = rb.getString(key);
			System.out.println(key + "=" + value);
		}

		
	}

}
