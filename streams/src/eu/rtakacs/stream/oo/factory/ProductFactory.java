package eu.rtakacs.stream.oo.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProductFactory {
	
	
	public static Product createProduct(String name) {
		switch (name) {
		case "loan":
			return new Loan();
		case "stock":
			return new Stock();
		case "bond":
			return new Bond();
		default:
			throw new IllegalArgumentException("No such product " + name);
		}
	}
	
	final static Map<String, Supplier<Product>> map = new HashMap<>();
	static {
		map.put("loan", Loan::new);
		map.put("stock", Stock::new);
		map.put("bond", Bond::new);
	}
	final static Map<String, TriFunction<Integer, Integer, String, Product>> map3 = new HashMap<>();
	static {
		map3.put("loan", Loan::new);
		map3.put("stock", Stock::new);
		map3.put("bond", Bond::new);
	}
	
	public static Product createProductWithLambda(String name) {
		Supplier<Product> p = map.get(name);
		if(p!=null) {
			return p.get();
		}
		throw new IllegalArgumentException("No such product " + name);
	}
	
	public static Product createProductWithLambdaTri(String name) {
		TriFunction<Integer, Integer, String, Product> f = map3.get(name);
		Product p = null;
		if(f!=null) {
			p = f.apply(1, 2, "3");
		}
		return p;
	}
}

