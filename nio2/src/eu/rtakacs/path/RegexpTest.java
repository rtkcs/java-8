package eu.rtakacs.path;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpTest {
	
	public static void main(String[] args) {
		
		
		String currentLine = "insert into ZVK_TEILAKTENNOTIZ (logId, erstellDatum, ersteller, bearbDatum, bearbeiter, notiz, rootObjId, nextLogId, parentObjectId, oid) values (30, '12/08/2017 11:00:02.000', 'Bestandsbereinigung', '12/08/2017 11:00:02.000', 'Bestandsbereinigung', 'VBMAX=0 gesetzt (wegen COBRA-16612) für TA-Nr 1', 4447958, 2147483647, 1, 1)";
		System.out.println(currentLine);
		Pattern p = Pattern.compile("'\\d\\d/\\d\\d/\\d\\d\\d\\d \\d\\d:\\d\\d:\\d\\d.000'");
		Matcher m = p.matcher(currentLine);
		
		StringBuffer sb = new StringBuffer();
		
		
		while(m.find()) {
			System.out.println(m.start());
			System.out.println(m.end());
			System.out.println(m.groupCount());
			
			String s = currentLine.substring(m.start(), m.end()-5)+"'";
			System.out.println(s);
			
			System.out.println(currentLine.substring(m.start(), m.end()));
			
			
			System.out.println();
			m.appendReplacement(sb, s);
			
		}
		m.appendTail(sb);
		
		System.out.println(sb.toString());
	}
}
