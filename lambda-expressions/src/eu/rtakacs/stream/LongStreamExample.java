package eu.rtakacs.stream;

import java.util.stream.LongStream;

public class LongStreamExample {

	public static void main(String[] args) {
		
		int v = 101;
		LongStream ls = LongStream.of(0, 2, 4, v);
		long sum = ls.sum();
		System.out.println(sum);
		v = 103;
				
	}

}
