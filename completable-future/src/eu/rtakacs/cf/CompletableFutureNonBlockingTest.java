package eu.rtakacs.cf;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class CompletableFutureNonBlockingTest {
	
	private String shopName;
	
	public CompletableFutureNonBlockingTest(String name) {
		this.shopName = name;
	}
	
	public String getName() {
		return this.shopName;
	}
	
	static List<CompletableFutureNonBlockingTest> shops = Arrays.asList( 
			new CompletableFutureNonBlockingTest("BestPrice"),		//1
			new CompletableFutureNonBlockingTest("LetsSaveBig"),	//2
			new CompletableFutureNonBlockingTest("MyFavoriteShop"),	//3
			new CompletableFutureNonBlockingTest("BuyItAll"),		//4
			new CompletableFutureNonBlockingTest("ShopEasy"));		//5
	
	public static void main(String[] args) {
		
		//
		//--- sequential stream
		//
		System.out.println("---------- sequential stream ----------");
		long start = System.nanoTime();
		System.out.println(findPrices("iPhone X"));
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs.");
		
		//
		//--- parallel stream
		//
		System.out.println();
		System.out.println("----------  parallel stream ---------- ");
		start = System.nanoTime();
		System.out.println(findPricesParallel("iPhone X"));
		duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs.");
		
		//
		//--- CompletableFuture
		//
		System.out.println();
		System.out.println("----------  completable future ---------- ");
		start = System.nanoTime();
		System.out.println(findPricesCF("iPhone X"));
		duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs.");
		
		//
		//--- CompletableFuture custom Executor
		//
		System.out.println();
		System.out.println("----------  completable future with custom executor ---------- ");
		start = System.nanoTime();
		System.out.println(findPricesCFExecutor("iPhone X"));
		duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs.");
		
	}
	
	/**
	 * sequential stream
	 * @param product
	 * @return
	 */
	public static List<String> findPrices(String product){
		return shops.stream()
				.map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
//				.collect(toList());
				.collect(Collectors.toList());
	}
	
	/**
	 * parallel stream
	 * @param product
	 * @return
	 */
	public static List<String> findPricesParallel(String product){
		return shops.parallelStream()
				.map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
				.collect(Collectors.toList());
	}
	
	/**
	 * CompletableFuture
	 * @param product product name
	 * @return
	 */
	public static List<String> findPricesCF(String product){
		List<CompletableFuture<String>> priceFutures = shops.stream()
				.map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
				.collect(Collectors.toList());
		
		return priceFutures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());
	}
	
	/**
	 * CompletableFuture with custom Executor.
	 * @param product product name
	 * @return
	 */
	public static List<String> findPricesCFExecutor(String product){
		Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), 
				new ThreadFactory() {
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setDaemon(true);
				return t;
			}
		});
		List<CompletableFuture<String>> priceFutures = shops.stream()
				.map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product), executor)))
				.collect(Collectors.toList());
		
		return priceFutures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());
	}
	
	
	public double getPrice(String product) {
		return calculatePrice(product);
	}
	
	public double calculatePrice(String product) {
		delay();
//		throw new RuntimeException("Product not available");
		Random random = new Random();
		return random.nextDouble() * product.charAt(0) + product.charAt(1); 
	}
	
	public static void delay() {
		try {
			Thread.sleep(1000L);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
	}	
}
