package eu.rtakacs.stream;

import java.util.Arrays;
import java.util.List;

import eu.rtakacs.stream.helper.Dish;

public class DishStream {
	
	public static List<Dish> menu = Arrays.asList(
			new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", false, 700, Dish.Type.OTHER),
			new Dish("pizza", true, 700, Dish.Type.OTHER),
			new Dish("prawns", false, 700, Dish.Type.FISH),
			new Dish("salmon", false, 700, Dish.Type.FISH)
			);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
