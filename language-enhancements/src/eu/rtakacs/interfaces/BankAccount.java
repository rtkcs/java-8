package eu.rtakacs.interfaces;


public class BankAccount implements IPremiumAccount{

	@Override
	public String getId() {
		return "BankAccount.getId";
	}
	
	public static void main(String[] args) {
		BankAccount acc = new BankAccount();
		System.out.println(acc.getId());
	}
}