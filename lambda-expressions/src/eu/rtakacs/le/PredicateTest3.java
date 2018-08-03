package eu.rtakacs.le;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest3 {

	public static boolean checkList(List<String> list, Predicate<List> p) {
		return p.test(list);
	}
	
	public static void main(String[] args) {
		boolean b;
		b = checkList(new ArrayList<String>(), (al) -> al.isEmpty());
		System.out.println(b);
		
		b = checkList(new ArrayList<String>(), (al) -> al.add("Hello World"));
		System.out.println(b);

	}

}
