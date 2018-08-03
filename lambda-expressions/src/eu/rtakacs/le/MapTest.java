package eu.rtakacs.le;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MapTest {

	public static void main(String[] args) {
		
		//
		//--stream.map
		//
		System.out.println("--stream.map");
		List<String> strList = Arrays.asList("a","bb", "ccc");
		Function<String, Integer> f = x -> x.length();
		Consumer<Integer> c = x -> System.out.println("Len:" + x + " ");
		strList.stream().map(f).forEach(c);
		
		//
		//--Map.compute
		//
		System.out.println("--Map.compute");
		Map<Integer, List<String>> group = new HashMap<>();
		List<String> value = new ArrayList<>();
		value.add("one");
		value.add("eins");
		group.put(1, value);
		
		value = new ArrayList<>();
		value.add("two");
		value.add("zwei");
		group.put(2, value);
		
		BiFunction<Integer, List<String>, List<String>> remappingFunction = (k,v) -> {
			if(v==null) {
				System.out.println("key: " + k + " is empty");
				return null;
			} else {
				System.out.println("key: "+ k + " has value: " + v.toString());
				return v;
			}
		};
		group.compute(1, remappingFunction);
		group.compute(2, remappingFunction);
		
		//
		//--Map.computeIfAbsent
		//
		System.out.println("--Map.computeIfAbsent");
		Function<Integer,List<String>> absentMappingFunction = i -> {
			List<String> l = new ArrayList<>();
			l.add(Integer.toString(i));
			return l;
		};
		group.compute(3, remappingFunction);
		group.computeIfAbsent(3, absentMappingFunction);
		group.compute(3, remappingFunction);
		
		//
		//--Map.computeIfPresent
		//		
		System.out.println("--Map.computeIfPresent");
		BiFunction<Integer, List<String>, List<String>> presentFunction = (Integer i2, List<String> l2) -> { l2.add( i2.toString() ); return l2; };
		group.computeIfPresent(1, presentFunction);
		group.compute(1, remappingFunction);
		
		
		//
		//--Map.merge
		//
		
		
		
		//
		//--Map.replaceAll
		//
		
		
		
	}

}
