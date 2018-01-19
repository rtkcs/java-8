package eu.rtakacs.stream.oo.templatemethod;

import java.util.function.Consumer;

public abstract class OnlineBanking {
	
	public void processCustomer(int id) {
		Customer c = Database.getCustomerWithId(id);
		makeCustomerHappy(c);
	}
	
	abstract void makeCustomerHappy(Customer c);
	
}
