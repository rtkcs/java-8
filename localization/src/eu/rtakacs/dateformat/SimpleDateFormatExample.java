package eu.rtakacs.dateformat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDateFormatExample {
	
	private static Date date = new Date();
//	private static Locale locale = Locale.GERMAN;
	private static Locale locale = Locale.forLanguageTag("sk");
	
	public static void sdf(String s) {
		 
		SimpleDateFormat sdf = new SimpleDateFormat(s, locale);
		System.out.println(sdf.format(date));
	}

	public static void main(String[] args) {
		
		sdf("MMMM");
		sdf("zzzz");
		sdf("zzz");
		sdf("MM/yy");
		sdf("dd-MM-yyyy HH:mm:ss:SSS");
		sdf("'Week:' w wwww");
		sdf("'Day in year:' D");
		sdf("'Month:' MMMM");
		sdf("'Day name:' E EEEE");
		sdf("'Time zone:' z zzzz Z ZZZZ");
		sdf("'Time zone:' X XX XXX");
		sdf("'Era designator:' G GGGG");
		
		System.out.println();
		System.out.println("--------- Examples from Java Doc");

		sdf("yyyy.MM.dd G 'at' HH:mm:ss z");
		sdf("EEE, MMM d, ''yy");
		sdf("h:mm a");
		sdf("hh 'o''clock' a, zzzz");		
		sdf("K:mm a, z");
		sdf("yyyyy.MMMMM.dd GGG hh:mm aaa");
		sdf("EEE, d MMM yyyy HH:mm:ss Z");
		sdf("yyMMddHHmmssZ");
		sdf("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		sdf("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		sdf("YYYY-'W'ww-u");
		
	}

}
