package eu.rtakacs.stream.parallel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatefulLambdaExpressionExample {

	public static void main(String[] args) {
		
		Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> listOfIntegers = new ArrayList<>( Arrays.asList(intArray) );
		
		List<Integer> serialStorage = new ArrayList<>();
	     
		System.out.println("Serial stream:");
		listOfIntegers
		    .stream()
		    
		    // Don't do this! It uses a stateful lambda expression.
		    .map(e -> { serialStorage.add(e); return e; })
		    
		    .forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");
		     
		serialStorage
		    .stream()
		    .forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");
		System.out.println("");

		System.out.println("Parallel stream:");
		List<Integer> parallelStorage = Collections.synchronizedList( new ArrayList<>() );
		listOfIntegers
		    .parallelStream()
		    
		    // Don't do this! It uses a stateful lambda expression.
		    .map(e -> { parallelStorage.add(e); return e; })
		    
		    .forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");
		     
		parallelStorage
		    .stream()
		    .forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");
	}
}
