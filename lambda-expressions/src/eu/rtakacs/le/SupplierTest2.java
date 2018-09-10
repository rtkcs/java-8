package eu.rtakacs.le;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class SupplierTest2 {
	
	public static void main(String[] args) {
		
		
		Book book1 = new Book("Thinking in Java", 19.99);
		Book book2 = new Book("Thinking in C++", 19.99);
		Book book3 = new Book("Java 8", null);
		
		Supplier s1 = book1::getPrice;
		Supplier s2 = () -> book2.getPrice();
		Supplier s3 = book3::getPrice;
		DoubleSupplier sd3 = book3::getPrice;
		
		System.out.println(book1.getName() + " - " + s1.get());
		System.out.println(book2.getName() + " - " + s2.get());
		System.out.println(book3.getName() + " - " + s3.get());
//		System.out.println(book3.getName() + " - " + sd3.getAsDouble());//java.lang.NullPointerException
		
	}

}
