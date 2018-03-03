package eu.rtakacs.stream.oo.factory;

public class Loan implements Product {
	
	public Loan() {}
	public Loan(int i, int j, String s) {
		System.out.println(String.format("i=%d, j=%d, s=%s", i, j, s));
	}
}
