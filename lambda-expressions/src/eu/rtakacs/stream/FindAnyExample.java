package eu.rtakacs.stream;

import java.util.stream.Stream;

public class FindAnyExample {

	public static void main(String[] args) {
		
		String quote = "No matter how many mistakes you make or how slow you progress, you are still way ahead of everyone who isn't trying.";
		Stream.of( quote.split("[ .,]") ).parallel().findAny().ifPresent((s)-> System.out.println(s));
		
		
	}

}
