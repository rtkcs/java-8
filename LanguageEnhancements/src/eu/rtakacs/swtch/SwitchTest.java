package eu.rtakacs.swtch;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SwitchTest {

	public static void main(String[] args) {
		
//		Set<String> literals = new TreeSet<String>();
		Set<String> literals = new LinkedHashSet<String>();
		literals.add("b");
		literals.add("a");
		literals.add("c");
		literals.add("a");
		
		for(String s : literals) {
			switch(s) {
				default: 
					System.out.println("default");
					break;
				case "a": 
					System.out.println("a");
//					break;
				case "b": 
					System.out.println("b");
					break;
			}
		}
		
	}

}
