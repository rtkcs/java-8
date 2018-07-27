package eu.rtakacs.le;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class ReduceTest {

	public static void main(String[] args) {
		

		BinaryOperator<String> bo = (s1, s2) -> s1.concat(s2);
		List<String> names = new ArrayList<>();
		names.add("Orange");
		names.add("Banana");
		names.add("Apple");
		List<String> emptyList = new ArrayList<>();
		
		String finalValue;
		//
		//-- T reduce(T identity, BinaryOperator<T> accumulator)
		//		
		finalValue = names.stream().reduce("Fruits: ", bo);
		System.out.println(finalValue);
		
		
		finalValue = emptyList.stream().reduce("Empty list: ", bo);
		System.out.println(finalValue);
		
		//
		//--- Optional<T> reduce(BinaryOperator<T> accumulator)
		//
		Optional<String> result;
		result = names.stream().reduce(bo);
		System.out.println(result.orElse("empty"));
		
		result = emptyList.stream().reduce(bo);
		System.out.println(result.orElse("empty"));
		
		//
		//--- <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
		//
		BiFunction<String, String, String> bf = (ss1,ss2) -> ss1.concat(ss2).concat(", ");
		finalValue = names.stream().reduce("Reduce with BiFunction: ", bf, bo);
		System.out.println(finalValue);
	}
}
