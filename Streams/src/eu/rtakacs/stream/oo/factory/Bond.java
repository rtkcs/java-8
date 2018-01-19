package eu.rtakacs.stream.oo.factory;

public class Bond implements Product {
	
	public Bond() {}
	public Bond(int i, int j, String s) {
		System.out.println(String.format("i=%d, j=%d, s=%s", i, j, s));
	}
}
