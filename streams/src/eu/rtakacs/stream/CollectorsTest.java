package eu.rtakacs.stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import eu.rtakacs.stream.helper.Dish;
import eu.rtakacs.stream.helper.Helper;

import static java.util.stream.Collectors.*;

public class CollectorsTest {

	public static void main(String[] args) {
		
		Helper.print("Collectors.countint");
		long howManyDishes = DishStream.menu.stream().collect(Collectors.counting());
		System.out.println(howManyDishes);
		
		
		Helper.print("Collectors.maxBy(Comparator)");
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> mostCalorieDish = DishStream.menu.stream()
				.collect(Collectors.maxBy(dishCaloriesComparator));
		System.out.println(mostCalorieDish);
		
		
		Helper.print("Collectors.summingInt");
		int totalCalories = DishStream.menu.stream().collect(summingInt(Dish::getCalories));
		double avgCalories = DishStream.menu.stream().collect(averagingInt(Dish::getCalories));
		System.out.println(String.format("Total calories: %d, Average calories %f", totalCalories, avgCalories));
		
		
		//
		// gathering summary information at once
		//
		Helper.print("IntSummaryStatistics");
		IntSummaryStatistics menuStatistics = DishStream.menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);
		
		
		Helper.print("Collectors.joining");
		String shortMenu = DishStream.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
		System.out.println(shortMenu);
		
	}
}
