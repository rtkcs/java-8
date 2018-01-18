package eu.rtakacs.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import eu.rtakacs.stream.helper.Helper;

public class NumericRanges {
	
	
	public static void main(String[] args) {
		
		Helper.print("IntStream");
		IntStream evenNumbers = IntStream.rangeClosed(1, 100)
										.filter(n -> n % 2 == 0);
		System.out.println(evenNumbers.count());
		
		
		//pythagorean theorem
		Helper.print("pythagorean theorem1");
		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100)
						.filter(b -> Math.sqrt(a*a + b*b)%1==0)
						.mapToObj(b -> new int[]{a,b,(int)Math.sqrt(a*a + b*b)})
						
						);
		pythagoreanTriples.limit(6).forEach(p -> System.out.println("("+p[0]+", "+p[1]+", "+p[2]+")"));
		
		Helper.print("pythagorean theorem2");
		Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100)
							.mapToObj(b -> new double[]{a,b,Math.sqrt(a*a + b*b)})
							.filter(p -> p[2] % 1 == 0)
						);
		pythagoreanTriples2.limit(6).forEach(p -> System.out.println("("+p[0]+", "+p[1]+", "+p[2]+")"));
				
	}

}
