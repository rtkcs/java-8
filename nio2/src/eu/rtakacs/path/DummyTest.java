package eu.rtakacs.path;

import java.util.LinkedHashSet;
import java.util.Set;

public class DummyTest {

	public static void main(String[] args) {
		
//		Set<String> set = null;
		Set<String> set = new LinkedHashSet<>();
		
		for(String s : set) {
			System.out.println(s);
		}
	}
}
