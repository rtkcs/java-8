package eu.rtakacs.stream.oo.factory;

public class Stock implements Product {

	public Stock() {}
	public Stock(int i, int j, String s) {
		System.out.println(String.format("i=%d, j=%d, s=%s", i, j, s));
	}	
}
