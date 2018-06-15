package eu.rtakacs.dateformat;

import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class CurrencyExample {

	public static void main(String[] args) {
		
//		Currency.getAvailableCurrencies().forEach((c)-> {System.out.println(c.getCurrencyCode() + " " + c.getDisplayName() + " " + c.getNumericCode() + " " + c.getSymbol());});
		
//		TreeSet<Currency> ts = new TreeSet<>();
//		ts.addAll(Currency.getAvailableCurrencies().);
//		ts.forEach((c)-> {System.out.println(c.getCurrencyCode() + " " + c.getDisplayName() + " " + c.getNumericCode() + " " + c.getSymbol());});
		
		List<Currency> list = new LinkedList<>(Currency.getAvailableCurrencies());
		
		Comparator<Currency> comparator = new Comparator<Currency>() {

			@Override
			public int compare(Currency c1, Currency c2) {
				return c1.getCurrencyCode().compareTo(c2.getCurrencyCode());
			}
			
		};
		System.out.format("%-5s%-35s%-15s%-7s%20s%n","Code", "DisplayName", "NumericCode", "Symbol", "FractionDigits");
		System.out.println("-----------------------------------------------------------------------------------");
		Collections.sort(list,comparator);
		list.forEach((c)-> {System.out.format("%-5s%-35s%-15d%-7s%20d%n", c.getCurrencyCode(), c.getDisplayName(), c.getNumericCode(), c.getSymbol(), c.getDefaultFractionDigits());});
	}

}
