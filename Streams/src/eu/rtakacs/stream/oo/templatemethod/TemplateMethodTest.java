package eu.rtakacs.stream.oo.templatemethod;

public class TemplateMethodTest {

	public static void main(String[] args) {
		
		OnlineBanking ob = new OnlineBanking(){
			void makeCustomerHappy(Customer c) {
				System.out.println("Hello " + c.firstName + " " + c.lastName + " !");
			}
		};
		ob.processCustomer(1);
		
		
		
		OnlineBankingLambda obl = new OnlineBankingLambda();
		obl.processCustomerLambda(1, (Customer c) -> System.out.println("Hello " + c.firstName + " " + c.lastName + " from lambda template method!"));

	}

}
