package eu.rtakacs.le;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

class Book{
	private String name;
	private Double price;
	
	Book(String name, Double price){
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}

public class SupplierTest {

	public static void main(String[] args) {
		Book b1 = new Book("Java 8 in Action", 30.00);
		Book b2 = new Book("Thinking in Java", null);
		Supplier s1 = b1::getPrice;
		Supplier s2 = b2::getPrice;
		System.out.println(b1.getName() + " " + s1.get());
		System.out.println(b2.getName() + " " + s2.get());
		
		DoubleSupplier ds1 = b1::getPrice;
		System.out.println(b1.getName() + " " + ds1.getAsDouble());
		
		DoubleSupplier ds2 = b2::getPrice;
//		System.out.println(b2.getName() + " " + ds2.getAsDouble());//java.lang.NullPointerException
	}

}
