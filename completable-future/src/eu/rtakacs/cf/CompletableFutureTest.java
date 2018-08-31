package eu.rtakacs.cf;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class CompletableFutureTest {

	public static void main(String[] args) {
		
		CompletableFutureTest test = new CompletableFutureTest();
		long start = System.nanoTime();
		
		Future<Double> futurePrice  = test.getPriceAsync("iPhone X");
		Future<Double> futurePrice2 = test.getPriceAsync2("iPhone XI");
		
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Invocation returned after " + invocationTime + " msec");
		
		try {
			double price = futurePrice.get();
			System.out.printf("Price  is %.2f%n", price);
			
			price = futurePrice2.get();
			System.out.printf("Price2 is %.2f%n", price);
			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Price returned after " + retrievalTime + " msec");
		
	}
	
	public double getPrice(String product) {
		return calculatePrice(product);
	}
	
	
	/**
	 * Implementing getPriceAsync method.
	 * @param product
	 * @return
	 */
	public Future<Double> getPriceAsync(String product){
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		new Thread( () -> {
			try {
				double price = calculatePrice(product);
				futurePrice.complete(price);
			}catch(Exception e) {
				futurePrice.completeExceptionally(e);
			}
		}).start();
		return futurePrice;
	}
	
	public Future<Double> getPriceAsync2(String product){
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}
	
	public double calculatePrice(String product) {
		delay();
//		throw new RuntimeException("Product not available");
		return ThreadLocalRandom.current().nextDouble() * product.charAt(0) + product.charAt(1); 
//		Random random = new Random();
//		return random.nextDouble() * product.charAt(0) + product.charAt(1);
		
	}
	
	public static void delay() {
		try {
			Thread.sleep(1000L);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	

}
