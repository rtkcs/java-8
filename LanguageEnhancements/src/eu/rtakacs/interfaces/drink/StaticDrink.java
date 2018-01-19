package eu.rtakacs.interfaces.drink;

public class StaticDrink implements IDrink{

	//Unresolved compilation problem: 
	//The method computeAlcoholPercent() of type CrazyDrink must override or implement a supertype method
	//@Override
	public static String computeAlcoholPercent() {
		return "static CrazyDrink.computeAlcoholPercent";
	}
	
	public static void main(String[] args) {
		System.out.println(IDrink.computeAlcoholPercent());
		System.out.println(StaticDrink.computeAlcoholPercent());
	}
}
