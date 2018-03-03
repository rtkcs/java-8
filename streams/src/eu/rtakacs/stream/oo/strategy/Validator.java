package eu.rtakacs.stream.oo.strategy;

public class Validator {
	
	private final ValidationStrategy strategy;
	
	public Validator(ValidationStrategy v) {
		this.strategy = v;
	}
	
	public boolean validate(String s) {
		return this.strategy.execute(s);
	}
}
