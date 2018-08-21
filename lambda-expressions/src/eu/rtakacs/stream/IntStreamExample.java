package eu.rtakacs.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import eu.rtakacs.Helper;

public class IntStreamExample {

	public static void main(String[] args) {
		
		///
		///---Instream.range(1,5)
		///
		System.out.println("----Instream.range(1,5)");
		IntStream iStream1 = IntStream.range(1,5);
		iStream1.forEach(System.out::println);
		
		///
		///---Instream.rangeClosed(1,5)
		///		
		System.out.println("----Instream.rangeClosed(1,5)");
		IntStream iStream2 = IntStream.rangeClosed(1, 5);
		iStream2.forEach(System.out::println);

		///
		///---Instream.boxed()
		///
		System.out.println("----IntStream.concat().boxed()");
		iStream1 = IntStream.range(1,5);
		iStream2 = IntStream.rangeClosed(1, 5);
		Stream<Integer> integerStream = IntStream.concat(iStream1, iStream2).boxed();
		Map<Integer, List<Integer>> mInteger = integerStream.peek(System.out::println).collect(Collectors.groupingBy(g->g));
		System.out.println(mInteger);
		System.out.println(mInteger.get(3));
		System.out.println(mInteger.get(5));
		
		
		///
		///---Stream.mapToInt()
		///
		Helper.print("Stream.mapToInt()");
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		double dSum = list.stream().mapToInt(i->i).sum();
		System.out.println(dSum);
		
	}

}
