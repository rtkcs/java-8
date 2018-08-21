package eu.rtakacs.stream.parallel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ForEachOrderedExample {

	public static void main(String[] args) {
		
		List<Integer> source = new ArrayList<Integer>();
		source.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		
		List<Integer> destination = Collections.synchronizedList(new ArrayList<Integer>());
		
		source
//			.parallelStream()
			.stream()
			.peek(item -> destination.add(item))
			.forEachOrdered(System.out::print);
		
		System.out.println();
		
		destination
			.stream()
//			.sorted()
			.forEach(System.out::print);
//			.forEachOrdered(System.out::print);
	}

}
