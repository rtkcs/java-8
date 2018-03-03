package eu.rtakacs.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import eu.rtakacs.stream.helper.Helper;

public class BuildingStreams {
	
	
	public static void main(String[] args){
		
		//stream from values
		Helper.print("Stream from values");
		Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);
		
		
		//stream from arrays
		Helper.print("Stream from arrays");
		int[] numbers = {1,2,3,4,5,6,7,8};
		int sum = Arrays.stream(numbers).sum();
		System.out.println(sum);
		
		
		//stream from files
		Helper.print("Stream from files");
		long uniqueWords = 0;
		try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
							.distinct()
							.count();
			System.out.println("Number of unique words: " + uniqueWords);
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		//stream from function, STREAM.ITERATE
		Helper.print("Fibonacci tuples, iterate");
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0]+t[1]})
				.limit(10)
				.forEach(t -> System.out.println(String.format("(%d,%d)", t[0], t[1]) ));
		
		Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0]+t[1]})
			.limit(10)
			.map(t -> t[0])
			.forEach(System.out::println);
		
		//stream from function, STREAM.GENERATE
		Helper.print("stream.generate");
		Stream.generate(Math::random)
			.limit(5)
			.forEach(System.out::println);
		
		Helper.print("stream.generate, anonymous class");
		IntStream twos = IntStream.generate(new IntSupplier(){
			public int getAsInt(){return 2;}
		});
		twos.limit(3)
		.forEach(System.out::println);
		
		Helper.print("Fibonacci tuples, generate");
		IntSupplier fib2 = new IntSupplier(){
			private int previous = 0;
			private int current = 1;
			public int getAsInt(){
				int oldPrevious = this.previous;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return oldPrevious;
			}
		};
		IntStream.generate(fib2).limit(10).forEach(System.out::println);
		
	}
}
