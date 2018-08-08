package eu.rtakacs.stream;

import java.util.stream.Stream;

public class AnyMatchExample {

	public static void main(String[] args) {
		
		String citation = "Look for the good in every person and every situation. You'll almost always find it.";
		boolean b = Stream.of(citation.split("[ ,.]")).anyMatch(p -> p.startsWith("p"));
		System.out.println(b);
	}

}
