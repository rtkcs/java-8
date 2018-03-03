package eu.rtakacs.interfaces.drink;

public interface IDrink {
	default double getAlcoholPercent() {
		return 39.0;
	}
	
	static String computeAlcoholPercent() {
		return "IDrink.computeAlcoholPercent";
	}
	
	//Illegal combination of modifiers for the interface method testMethod; only one of abstract, default, or static permitted
//	default static String testMethod() {
//		return "IDrink.testMethod";
//	}
}
