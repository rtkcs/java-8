package eu.rtakacs.stream;

import java.util.stream.DoubleStream;

public class DoubleStreamExample {

	public static void main(String[] args) {
		
		int v = 101;
		DoubleStream ds = DoubleStream.of(0.0, 2, 4, v);
		double sum = ds.filter(d -> d%2!=0).sum();
		System.out.println(sum);
	}

}
