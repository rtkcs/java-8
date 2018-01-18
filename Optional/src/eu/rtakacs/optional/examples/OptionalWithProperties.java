package eu.rtakacs.optional.examples;

import java.util.Optional;
import java.util.Properties;

public class OptionalWithProperties {

	public static void main(String[] args){
		Properties p = new Properties();
		p.setProperty("a", "5");
		p.setProperty("b", "true");
		p.setProperty("c", "-3");
		
		System.out.println( readDurationTraditional(p,"a") );
		System.out.println( readDurationTraditional(p,"b") );
		System.out.println( readDurationTraditional(p,"c") );
		System.out.println( readDurationTraditional(p,"d") );
		
		System.out.println();
		System.out.println( readDurationStream(p,"a") );
		System.out.println( readDurationStream(p,"b") );
		System.out.println( readDurationStream(p,"c") );
		System.out.println( readDurationStream(p,"d") );
	}
	
	public static int readDurationTraditional(Properties props, String name){
		
		String value = props.getProperty(name);
		if(value != null){
			try{
				int i = Integer.parseInt(value);
				if(i>0){
					return i;
				}
			}catch(NumberFormatException e){ }
		}
		return 0;
	}
	
	public static int readDurationStream(Properties props, String name){
		return Optional.ofNullable(props.getProperty(name))
				.flatMap(OptionalUtility::stringToInt)
				.filter(i -> i > 0)
				.orElse(0);
	}
}
