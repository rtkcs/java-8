package eu.rtakacs.cf.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Pipelining synchronous tasks.
 * 
 * @author TAK10892
 *
 */
public class Discount {
	
	public enum Code{
		NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
		private final int percentage;
		Code(int percentage){
			this.percentage = percentage;
		}
	}
	
	private String shopName;
	
	public Discount(String name) {
		this.shopName = name;
	}
	
	public String getName() {
		return this.shopName;
	}
	
	static List<Discount> shops = Arrays.asList( 
			new Discount("BestPrice"),		//1
			new Discount("LetsSaveBig"),	//2
			new Discount("MyFavoriteShop"),	//3
			new Discount("BuyItAll"),		//4
			new Discount("ShopEasy"));		//5

	public static void main(String[] args) {
		
		//
		//--- sequential stream
		//
		System.out.println();
		System.out.println("---------- sequential stream ----------");
		long start = System.nanoTime();
		System.out.println(findPrices("iPhone X"));
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("--Done in " + duration + " msecs.");
		
		//
		//--- sequential stream
		//		
		System.out.println();
		System.out.println("---------- CompletableFuture with custom executor ----------");
		start = System.nanoTime();
		System.out.println(findPricesCF("iPhone X"));
		duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("--Done in " + duration + " msecs.");

		//
		//--- Stream of Futures
		//
		System.out.println();
		System.out.println("---------- Stream of Futures ----------");
		final long startF = System.nanoTime();
		
//		findPricesStream("iPhone X")
//			.map( f -> f.thenAccept( s -> System.out.println(s + " done in " + (System.nanoTime() - start) / 1_000_000 + " msec") ) );
//			.map(CompletableFuture::join);
		
		CompletableFuture[] futures = findPricesStream("iPhone X")
				.map(  f -> f.thenAccept( s -> System.out.println(s + " done in " + ((System.nanoTime() - startF) / 1_000_000) + " msec") ) ) 
				.toArray(size -> new CompletableFuture[size]);
		CompletableFuture.allOf(futures).join();
		
		duration = (System.nanoTime() - startF) / 1_000_000;
		System.out.println("--All shopt have now responded in " + duration + " msecs.");		
	}
	
	
	public static List<String> findPrices(String product){
		return shops.stream()
				.map(discount -> discount.getPrice(product))
				.map(Quote::parse)
				.map(Discount::applyDiscount)
				.collect(Collectors.toList());
	}
	
	public static List<String> findPricesCF(String product){
		Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), 
				new ThreadFactory() {
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setDaemon(true);
				return t;
			}
		});
		
		List<CompletableFuture<String>> priceFutures = shops.stream()
				.map( shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor) )
				.map( future -> future.thenApply(Quote::parse) )
				.map( future -> future.thenCompose( quote -> CompletableFuture.supplyAsync( () -> Discount.applyDiscount(quote), executor ) ) )
				.collect( Collectors.toList() );
				
		return priceFutures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());
	}
	
	public static Stream<CompletableFuture<String>> findPricesStream(String product){
		return shops.stream()
				.map(shop -> CompletableFuture.supplyAsync( () -> shop.getPrice(product)) )
				.map(future -> future.thenApply(Quote::parse))
				.map(future -> future.thenCompose( quote -> CompletableFuture.supplyAsync( () -> Discount.applyDiscount(quote) ) ));
	}
	
	public String getPrice(String product) {
		Random random = new Random();
		double price = calculatePrice(product);
		Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
		return String.format("%s:%.2f:%s", this.shopName, price, code);
	}
	
	private double calculatePrice(String product) {
//		delay();
		randomDelay();
		Random random = new Random();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}
	
	public static String applyDiscount(Quote quote) {
		return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
	}
	
	public static double apply(double price, Code code) {
		delay();
//		return format(price* (100 - code.percentage) / 100);
		return price* (100 - code.percentage) / 100;
	}	
	
	public static void delay() {
		try {
			Thread.sleep(1000L);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static Random random = new Random();
	
	public static void randomDelay() {
		int delay = 500 + random.nextInt(2000);
		try {
			Thread.sleep(delay);
		} catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

//	public static String format(double d) {
//		return String.format("%.2f", d);
//	}
}
