package eu.rtakacs.swtch;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SwitchTest {

	public static void main(String[] args) {
		
		//
		//---SWITCH 1
		//
		System.out.println("-------switch 1");
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
		
		
		//
		//---SWITCH 2
		//		
		System.out.println("-------switch 2");
//		String[] ss = new String[] {"a", "b", null}; //java.lang.NullPointerException
		String[] ss = new String[] {"a", "b", "c"};
		for(String s:ss) {
			switch(s) {
				case "a": System.out.println("a");
//				case null : System.out.println("null"); //does not compile: case expressions must be constant expressions
			}
		}
		
		//
		//---SWITCH 3
		//
		int val = 1_000_000;
		switch(val) {
			case 1_000_000: System.out.println("1_000_000");
				break;
			case 1000000: System.out.println("1_000_000");	//will not compile: Duplicate case
				break;
		}
		
	}

}
