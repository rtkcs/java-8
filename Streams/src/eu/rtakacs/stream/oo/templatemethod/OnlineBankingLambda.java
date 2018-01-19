package eu.rtakacs.stream.oo.templatemethod;

import java.util.function.Consumer;

public class OnlineBankingLambda {

	public void processCustomerLambda(int id, Consumer<Customer> makeCustomerHappy) {
		Customer c = Database.getCustomerWithId(id);
		makeCustomerHappy.accept(c);
	}
}
