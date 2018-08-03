package eu.rtakacs.le;

import java.util.Arrays;
import java.util.List;


class DVD{
	String title;
	double price;
	DVD(String title, double price){
		this.title = title;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}

public class FlatMapTest {	
	public static void main(String[] args) {
		
		List<List<DVD>> dvds = Arrays.asList(
				Arrays.asList(
						new DVD("The Godfather", 7.0),
						new DVD("Short History of Time", 5.0)),
				Arrays.asList(
						new DVD("Mars", 10.0),
						new DVD("Mickey Mouse", 13.0))
				);
		
		double sumOfPrices = dvds.stream()
				.flatMap(dvdList->dvdList.stream())
				.mapToDouble(oneDvd-> oneDvd.getPrice())
//				.map(oneDvd-> oneDvd.getPrice()) //return Stream<Double>, sum() is undefined for Stream<Double>
				.sum();
		System.out.println(sumOfPrices);
	}

}
