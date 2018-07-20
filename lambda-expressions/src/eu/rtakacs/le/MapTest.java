package eu.rtakacs.le;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MapTest {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("a","bb", "ccc");
		Function<String, Integer> f = x -> x.length();
		Consumer<Integer> c = x -> System.out.println("Len:" + x + " ");
		strList.stream().map(f).forEach(c);
	}

}
