package eu.rtakacs.le;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFunctionTest {

	public static void main(String[] args) {
		
		BiPredicate<String, Integer> bip = (s, i) -> s.length()>i;
		BiFunction<String, Integer, String> bif = (s, i) -> {
			if(bip.test(s, i)) {
				return s.substring(0, i);
			}
			else return s;
		};
		
		String str = bif.apply("Hello World", 5);
		System.out.println(str);
	}

}
