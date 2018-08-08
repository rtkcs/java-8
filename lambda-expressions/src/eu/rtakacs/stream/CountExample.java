package eu.rtakacs.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountExample {

	public static void main(String[] args) {
		
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17);
		Stream<Integer> primeStream = primes.stream();
		
		Predicate<Integer> predicateLt10 = i -> i<10;
		long countLt10 = primeStream.filter(predicateLt10).count();
		System.out.println(countLt10);
		
		Predicate<Integer> predicateGt10 = i -> i>10;
		//long countGt10 = primeStream.filter(testGt10).count();//java.lang.IllegalStateException: stream has already been operated upon or closed
		//System.out.println(countGt10);
		
		Map<Boolean,List<Integer>> partitionedMap = primes.stream().collect(Collectors.partitioningBy(predicateLt10));
		System.out.println(partitionedMap);
		
		Map<Boolean, Long> map = primes.stream().collect(Collectors.partitioningBy(predicateLt10, Collectors.counting()));
		map.values().forEach(System.out::println);
		
		Map<Boolean, IntSummaryStatistics> summaryMap = primes.stream().collect(Collectors.partitioningBy(predicateLt10, Collectors.summarizingInt( i -> i)));
		System.out.println(summaryMap);
		
		Map<Boolean, Integer> summMap = primes.stream().collect(Collectors.partitioningBy(predicateLt10, Collectors.summingInt( i -> i)));
		System.out.println(summMap);

	}
}
