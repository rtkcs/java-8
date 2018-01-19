package eu.rtakacs.stream.oo.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FactoryTest {
	
	
	
	public static void main(String[] args) {
		Product p1 = ProductFactory.createProduct("loan");
		System.out.println("Product created: " + p1.getClass());
		
		Product p2 = ProductFactory.createProductWithLambda("loan");
		System.out.println("Product created: " + p2.getClass());
		
		Product p3 = ProductFactory.createProductWithLambda("loan5");
		System.out.println("Product created: " + p2.getClass());
	}

}
