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
		
		
		///
		///--- change object values
		///
		System.out.println();
		List<Entity> entities = Arrays.asList(
				new Entity("Windows", "OperatingSystem", 3.0),
				new Entity("Linux", "OperatingSystem", 1.0),
				new Entity("Unix", "OperatingSystem", 5.0),
				new Entity("CPU", "Hardware", 5.0),
				new Entity("GPU", "Hardware", 3.0)
				);
		entities.stream().filter(e0 -> e0.getName().equalsIgnoreCase("windows")).forEach(e1 -> e1.setPrice( 50 ));
		entities.stream().forEach(ee -> System.out.println(ee));
		
		
		///
		///--- final or effectively final variable
		///
		int sum = 0;
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5);
		//Local variable sum defined in an enclosing scope must be final or effectively final
		//list.stream().forEach(i -> sum=sum+i); 
		
		long l = 1;
		System.out.println(l);
	}
}
