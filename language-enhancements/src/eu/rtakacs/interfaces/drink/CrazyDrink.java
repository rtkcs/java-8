package eu.rtakacs.interfaces.drink;

public class CrazyDrink implements IColdDrink {

	@Override
	public String getName() {
		return "CrazyDrink.getName";
	}
	
	public String computeAlcoholPercent() {
		return "CrazyDrink.computeAlcoholPercent";
	}
	
	
	public static void main(String[] args) {
		CrazyDrink cd = new CrazyDrink();
		System.out.println(cd.getName());
		System.out.println(cd.getAlcoholPercent());
		System.out.println(IDrink.computeAlcoholPercent());
		System.out.println(cd.computeAlcoholPercent());
	}
}
