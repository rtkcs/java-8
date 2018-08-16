package eu.rtakacs.stream.parallel;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {

	public static void main(String[] args) {
		List<String> values = Arrays.asList("a","b");
		String s = values.parallelStream().reduce("_", (a,b)-> a.concat(b));
		System.out.println(s);
		System.out.println();
		System.out.println();
		
		System.out.println("--- complex example");
		List<String> values2 = Arrays.asList(
			"a", "b", "c", "d", "e", "f", "g",
			"a", "b", "c", "d", "e", "f", "g",
			"a", "b", "c", "d", "e", "f", "g",
			"a", "b", "c", "d", "e", "f", "g"
		);
		
		String s2 = values2.parallelStream().peek( System.out::println)
				.reduce("_", 
						(a,b)->{ System.out.println("reducing  " + a + " and " + b + " Thread: " + Thread.currentThread().getName()); return a.concat(b);}, 
						(a,b)->{ System.out.println("combining " + a + " and " + b + " Thread: " + Thread.currentThread().getName()); return a.concat(b);}
						);
		System.out.println(s2);
	}
}
