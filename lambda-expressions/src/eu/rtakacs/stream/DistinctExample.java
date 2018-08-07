package eu.rtakacs.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DistinctExample {

	public static void main(String[] args) {
		
		String s1 = "Successful people are always looking for opportunities to help others. Unsuccessful people are always asking, What's in it for me?";
		String s2 = "It doesn't matter where you are coming from. All that matters is where you are going.";
		String s3 = "Positive expectations are the mark of the superior personality.";
		String s4 = "Never complain, never explain. Resist the temptation to defend yourself or make excuses.";
		List<String> sentences = Arrays.asList(s1, s2, s3, s4);
		
		///
		///-- all words without repetition
		///
		
		Stream<String> strm = sentences.stream()
				.flatMap(str -> Stream.of(str.split("[ ,.?]")))
				.filter(s -> s.length()>0)
				.distinct();
		strm.forEach(c -> System.out.println(c));
	}

}
