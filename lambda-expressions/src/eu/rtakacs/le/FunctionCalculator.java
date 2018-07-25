package eu.rtakacs.le;

import java.util.function.Function;

public class FunctionCalculator {
	
	
	public static void main(String[] args) {
		double principle = 100;
		int interestRate = 5;
		double amount = computeInteger(principle, x-> x*interestRate);
		System.out.println(amount);
		
		amount = computeDouble(principle, x-> x*interestRate);
		System.out.println(amount);
	}
	
	public static double computeDouble(double base, Function<Double, Double> function) {
		return function.apply(base);
	}
	
	public static double computeInteger(double base, Function<Integer, Integer> function) {
		return function.apply((int)base);
	}

}
