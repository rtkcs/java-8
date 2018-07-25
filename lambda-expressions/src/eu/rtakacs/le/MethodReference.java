package eu.rtakacs.le;

import java.util.Arrays;
import java.util.List;

interface Carnivore{
	default int calories(List<String> food) {
		System.out.println("Calories " + food.size()*100);
		return food.size() * 100;
	}
	int eat(List<String> foods);
}

class Tiger implements Carnivore{
	public int eat(List<String> foods) {
		System.out.println("Eating "+foods);
		return foods.size() * 200;
	}
}

public class MethodReference {
	
	public static int size(List<String> names) {
		System.out.println("Size " + names.size() * 2);
		return names.size() * 2;
	}
	public static void process(List<String> names, Carnivore c) {
		c.eat(names);
	}
	
	public static void main(String[] args) {
		List<String> fnames = Arrays.asList("beeg", "veal", "chicken", "pork");
		Tiger t = new Tiger();
		
		process(fnames, t::eat);
		process(fnames, t::calories);
		process(fnames, MethodReference::size);
		process(fnames, t);
		
		//process(fnames, Carnivore::calories);//Cannot make a static reference to the non-static method calories(List<String>) from the type Carnivore
		//process(fnames, Tiger::eat);//Cannot make a static reference to the non-static method eat(List<String>) from the type Tiger
	}

}
