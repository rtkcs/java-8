package eu.rtakacs.stream.parallel;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelAtomicIntegerExample {

	public static void main(String[] args) {
		
		AtomicInteger ai = new AtomicInteger();
		Stream<String> stream = Stream.of("You", "Learn", "More", "From", "Failure", "Than", "From", "Success", "Don’t", "Let", "It", "Stop", "You", "Failure", "Builds", "Character");
		stream.parallel()
		.filter( s -> {
			ai.incrementAndGet();
			return s.contains("Y");
		}).allMatch( x -> x.indexOf("Y") > 0);
		
		System.out.println(ai);
	}

}
