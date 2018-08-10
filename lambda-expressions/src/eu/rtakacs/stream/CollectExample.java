package eu.rtakacs.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleConsumer;
import java.util.stream.Collectors;

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
		Averager averageCollect = entities.stream()
				.map(Entity::getPrice)
				.collect(Averager::new, Averager::accept, Averager::combine);
		
		System.out.println("Average price of entities is : " + averageCollect.average());
		
		
		Map<String, Double> totalPriceByCategory = entities.stream()
		.collect(
				Collectors.groupingBy(
						Entity::getCategory,
						Collectors.reducing(0.0, Entity::getPrice, Double::sum)));
		 System.out.println("totalPriceByCategory : " + totalPriceByCategory);
		 

	}

}
