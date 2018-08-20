package eu.rtakacs.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import eu.rtakacs.Helper;

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

	@Override
	public String toString() {
		return System.lineSeparator() + "Entity [name=" + name + ", category=" + category + ", price=" + price + "]";
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
		System.out.println(categorySet);
		
		///--- 3 Collectors.toSet
		Set<String> categorySet2 = entities.stream().map(Entity::getCategory).collect(Collectors.toSet());
		System.out.println(categorySet2);
		
		
		///
		///--- stream.collect, Collectors.groupingBy
		///
		Helper.print("grouping to Map<String category, List<Entity>>");
		Map<String, List<Entity>> entitiesMap =  entities.stream().collect(Collectors.groupingBy( Entity::getCategory ));
		System.out.println(entitiesMap);
		

		Helper.print("grouping to Map<Double price, List<String name>>");
		Map<Double, List<String>> entitiesMap2 = entities.stream().collect(Collectors.groupingBy(Entity::getPrice, Collectors.mapping(Entity::getName, Collectors.toList())));
		System.out.println(entitiesMap2);
		
		
		Helper.print("grouping by categoty, by price");
		Map<String, Map<Double, List<Entity>>> entitiesMap3 = entities.stream().collect(Collectors.groupingBy(Entity::getCategory, Collectors.groupingBy(Entity::getPrice)));
		System.out.println(entitiesMap3);
	}

}
