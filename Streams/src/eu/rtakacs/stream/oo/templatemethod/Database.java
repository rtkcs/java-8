package eu.rtakacs.stream.oo.templatemethod;

public class Database {
	
	public static Customer getCustomerWithId(int id) {
		Customer c = new Customer();
		c.setId(id);
		c.setFirstName("John");
		c.setLastName("Doe");
		return c;
	}
}
