package eu.rtakacs.locks;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalTest {

	public static void main(String[] args) {
		
		System.out.println("----- ThreadLocalRandom -----");
		System.out.println("");
		System.out.println("nextInt");
		System.out.println(ThreadLocalRandom.current().nextInt());
		
		System.out.println();
		System.out.println("nextInt(15)");
		System.out.println(ThreadLocalRandom.current().nextInt(15));
		
		System.out.println();
		System.out.println("5 x nextInt between inclusive 1 and exclusive 101:");
		for(int f=1;f<6;f++){
			int i = ThreadLocalRandom.current().nextInt(0, 101);
			System.out.println(i);
		}

		System.out.println();
		System.out.println("unlimited IntStream, get the first int ");
		int ii = ThreadLocalRandom.current().ints().findFirst().getAsInt();
		System.out.println(ii);
		
		System.out.println();
		System.out.println("IntStream with 5 values:");
		ThreadLocalRandom.current().ints(5).forEach(f -> System.out.println(f));
		
		System.out.println();
		System.out.println("IntStream with 5 values from 0 to 10:");
		ThreadLocalRandom.current().ints(5, 0, 11).forEach(f -> System.out.println(f));
	}

}
