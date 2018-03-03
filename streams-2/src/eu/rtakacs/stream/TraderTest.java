package eu.rtakacs.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import eu.rtakacs.stream.helper.Helper;
import eu.rtakacs.stream.helper.Trader;
import eu.rtakacs.stream.helper.Transaction;

public class TraderTest {
	
	static Trader raoul = new Trader("Raoul", "Cambridge");
	static Trader mario = new Trader("Mario","Milan");
	static Trader alan = new Trader("Alan","Cambridge");
	static Trader brian = new Trader("Brian","Cambridge");
	
	public static List<Transaction> transactions = Arrays.asList(
			new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000),
			new Transaction(raoul, 2011, 400),
			new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700),
			new Transaction(alan, 2012, 950)
			);
	
	public static void main(String[] args){
		
//		1. Find all transactions in the year 2011 and sort them by value (small to high).
		Helper.print("1. Find all transactions in the year 2011");
		transactions.stream()
			.filter(t -> t.getYear()==2011)
			.sorted((t1,t2) -> t1.getValue()-t2.getValue())
			.forEach(tt -> System.out.println(tt.toString()));

		
//		2. What are all the unique cities where the traders work?
		Helper.print("2. What are all the unique cities where the traders work?");
		transactions.stream()
			.map((Transaction t) -> t.getTrader().getCity())
			.distinct()
			.forEach(System.out::println);
		
		Helper.print("2.");
		Set<String> cities = transactions.stream()
			.map(transaction -> transaction.getTrader().getCity())
			.collect(Collectors.toSet());
		cities.forEach(System.out::println);
		
//		3. Find all traders from Cambridge and sort them by name.
		Helper.print("3. Find all traders from Cambridge and sort them by name");
		transactions.stream()
			.map((Transaction t) -> t.getTrader())
			.filter(tr -> (tr.getCity().equals("Cambridge")))
			.distinct()
			.sorted((tr1,tr2) -> tr1.getName().compareTo(tr2.getName()))
			.forEach(System.out::println);
			
//		4. Return a string of all traders’ names sorted alphabetically.
		Helper.print("4. Return a string of all traders’ names sorted alphabetically.");
		String tradeStr = transactions.stream()
			.map( t -> t.getTrader().getName() )
			.distinct()
			.sorted()
			.reduce("", (name1,name2)->name1+name2+" ");
		System.out.println(tradeStr);
		
		String tradeStr2 = transactions.stream()
				.map(transaction -> transaction.getTrader().getName())
				.distinct()
				.sorted()
				.collect(Collectors.joining(" "));
		System.out.println(tradeStr2);
			
		
//		5. Are any traders based in Milan?
		Helper.print("5. Are any traders based in Milan?");
		boolean anyFromMilan = transactions.stream()
			.map(t -> t.getTrader().getCity())
			.anyMatch(c -> c.equals("Milan"));
		System.out.println("Are any traders from Milan? " + anyFromMilan);
		
		boolean milanBased = transactions.stream()
				.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		System.out.println(milanBased);
		
//		6. Print all transactions’ values from the traders living in Cambridge.
		Helper.print("6. Print all transactions’ values from the traders living in Cambridge.");
		transactions.stream()
			.filter(t -> t.getTrader().getCity().equals("Cambridge"))
			.forEach(t->System.out.println(t.getValue()));
		
//		7. What’s the highest value of all the transactions?
		Helper.print("7. What’s the highest value of all the transactions?");
		Optional<Transaction> opt1 = transactions.stream()
			.max((t1,t2)-> Integer.compare(t1.getValue(), t2.getValue()) );
		System.out.println(opt1.get().getValue());
		
		Optional<Integer> highestValue = transactions.stream()
				.map(Transaction::getValue)
				.reduce(Integer::max);
		System.out.println(highestValue.get());
		
		
//		8. Find the transaction with the smallest value.
		Helper.print("8. Find the transaction with the smallest value.");
		Optional<Transaction> opt2 = transactions.stream()
			.min((t1,t2)-> Integer.compare(t1.getValue(), t2.getValue()));
		System.out.println(opt2.get());
		
		Optional<Transaction> smallestTransaction = transactions.stream()
				.reduce((t1,t2)->t1.getValue() < t2.getValue() ? t1:t2);
		System.out.println(smallestTransaction.get());
		
		Optional<Transaction> smallestTransaction2 = transactions.stream()
				.min(Comparator.comparing(Transaction::getValue));
		System.out.println(smallestTransaction2.get());
	}

}
