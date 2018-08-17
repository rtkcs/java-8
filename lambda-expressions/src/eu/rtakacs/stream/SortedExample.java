package eu.rtakacs.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortedExample {

	public static void main(String[] args) {

		List<Entity> entities = Arrays.asList(
				new Entity("Windows", "OperatingSystem", 3.0),
				new Entity("Linux", "OperatingSystem", 1.0),
				new Entity("Unix", "OperatingSystem", 5.0),
				new Entity("CPU", "Hardware", 5.0),
				new Entity("GPU", "Hardware", 3.0)
				);
		
		System.out.println("---Comparator: Category, Price reversed");
		Comparator<Entity> comparator1 = (e1, e2) -> e1.getCategory().compareToIgnoreCase(e2.getCategory());
		Comparator<Entity> comparator2 = comparator1.thenComparing( eee -> eee.getName() );
		
		entities.stream().sorted(comparator1.thenComparing(ee-> ee.getPrice()).reversed()).forEach(e -> System.out.println(e));
		
		System.out.println();
		System.out.println("---Comparator: Category");
		entities.stream().sorted(comparator1).forEach(e -> System.out.println(e));
		
		System.out.println();
		System.out.println("---Comparator: Category, Name");
		entities.stream().sorted(comparator2).forEach(e -> System.out.println(e));
	}

}
