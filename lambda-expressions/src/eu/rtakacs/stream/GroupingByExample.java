package eu.rtakacs.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

class Entity{
	private String name;
	private String category;
	private double price;
	
	public Entity(String name, String category, double price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

public class GroupingByExample {

	public static void main(String[] args) {
		
		List<Entity> entities = Arrays.asList(
				new Entity("Windows", "OperatingSystem", 3.0),
				new Entity("Linux", "OperatingSystem", 1.0),
				new Entity("Unix", "OperatingSystem", 5.0),
				new Entity("CPU", "Hardware", 5.0),
				new Entity("GPU", "Hardware", 3.0)
				);
		ToDoubleFunction<Entity> entityPrice = Entity::getPrice;
		
		///
		///--- groupingBy
		///
		entities.stream()
		.collect(Collectors.groupingBy(Entity::getCategory))
		.forEach((keyString, valueEntityList) -> {
			double averagePrice = valueEntityList.stream().collect(Collectors.averagingDouble(entityPrice));
			System.out.println(keyString + " : " + averagePrice);
		});
		
		
		///
		///--- toSet 
		///
		Set<String> categorySet = new HashSet<>();
		///--- 1
		entities.stream().map(e -> e.getCategory()).forEach(c -> categorySet.add(c));
		
		///--- 2 
		entities.stream().map(Entity::getCategory).forEach(categorySet::add);
		
		///--- 3 Collectors.toSet
		entities.stream().map(Entity::getCategory).collect(Collectors.toSet());
		System.out.println(categorySet);
	}

}
