package eu.rtakacs.interfaces;

public class BasicAccount extends DefaultAccount implements IAccount {
	
//	public String getId() {
//		return super.getId();
//		//return "BasicAccount.getId";
//	}
	
	public static void main(String[] args) {
		IAccount a = new BasicAccount();
		System.out.println(a.getId());
	}
}
