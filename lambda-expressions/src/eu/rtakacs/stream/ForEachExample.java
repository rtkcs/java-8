package eu.rtakacs.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ForEachExample {

	public static void main(String[] args) {
		
		List<String> letters = Arrays.asList("j", "a", "v", "a");

		///
		///--- forEach, nothing happens
		///		
		letters.forEach(letter -> letter.toUpperCase());
		letters.forEach(System.out::print);
		
		///
		///--- replaceAll(UnaryOperator uo)
		///
		System.out.println();
		UnaryOperator<String> uo = str -> str.toUpperCase();
		letters.replaceAll(uo);
		letters.forEach(System.out::print);
		
		///
		///--- replaceAll(Consumer c)
		///
		System.out.println();
		letters.forEach(letter -> System.out.print(letter.toUpperCase()));
		
		///
		///--- Collectors.joining()
		///
		System.out.println();
		System.out.println(letters.stream().collect(Collectors.joining()).toUpperCase());
		
		
		String s = letters.stream().collect(Collectors.joining());
		System.out.println(s);
		
		
	}
}
