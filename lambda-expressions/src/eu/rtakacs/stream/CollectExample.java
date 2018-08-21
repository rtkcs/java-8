package eu.rtakacs.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleConsumer;
import java.util.stream.Collectors;

import eu.rtakacs.Helper;

class Averager implements DoubleConsumer{
	
	private int count = 0;
	private double total = 0;
	
	public double average() {
		return count > 0 ? total/count : 0;
	}
	
	@Override
	public void accept(double d) {
		total += d;
		count++;
	}
	
	public void combine(Averager other) {
		total += other.total;
		count += other.count;
	}
	
}

public class CollectExample {

	public static void main(String[] args) {
		
		List<Entity> entities = Arrays.asList(
				new Entity("Eat that frog","book", 10.0),
				new Entity("Discipline","book", 20.0),
				new Entity("Make your life","book", 30.0),
				new Entity("Python","programming language", 0.0)
				);

		///
		///---Double Consumer, own collector class
		///
		Averager averageCollect = entities.stream()
				.map(Entity::getPrice)
				.collect(Averager::new, Averager::accept, Averager::combine);
		
		System.out.println("Average price of entities is : " + averageCollect.average());
		
		
		///
		///---Collectors.reducing
		///
		Map<String, Double> totalPriceByCategory = entities.stream()
		.collect(
				Collectors.groupingBy(
						Entity::getCategory,
						Collectors.reducing(0.0, Entity::getPrice, Double::sum)));
		 System.out.println("totalPriceByCategory : " + totalPriceByCategory);
		 
		 
		 ///
		 ///---Collectors.toMap
		 ///
		 try {
			 Map<String,String> entityMap = entities.stream()
					 .peek(e -> System.out.println(e.toString()))
					 .collect(Collectors.toMap(eKey -> eKey.getCategory(), eValue -> eValue.getName()));
			 entityMap.forEach( (key,value)-> System.out.println(key + " " + value));
		 }catch(IllegalStateException e) {
			 Helper.print("Exception ->");
			 e.printStackTrace();
			 Helper.print("<- Exception");
		 }
		 
		 Map<String, String> entityMap2 = entities.stream()
				 .peek(System.out::println)
				 .collect(Collectors.toMap(key->key.getCategory(), value-> value.getName(), (o,n)-> /*o + ", " + */n));
		 entityMap2.forEach((k,v)-> System.out.println(k + " = " + v));
		 
		 
		 ///
		 ///---Collectors.joining
		 ///
		 Helper.print("Collectors.joining");
		 String s = entities.stream()
		 .map(e -> e.getName())
		 .collect(Collectors.joining(", "));
		 System.out.println(s);
		 
		 String ss = entities.stream()
				 .map(e -> e.getName())
				 .collect(Collectors.joining(", ", "Prefix_", "_suffix"));
		 System.out.println(ss);
	}

}
