package eu.rtakacs.interfaces;

interface IAccount {
	public default String getId() {
		return "Account.getId";
	}
}
