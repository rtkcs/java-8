package eu.rtakacs.stream.oo.strategy;

import eu.rtakacs.stream.helper.Helper;

public class ValidatorTest {

	public static void main(String[] args) {
		Validator numericValidator = new Validator(new IsNumeric());
		boolean b1 = numericValidator.validate("abcdefg");
		System.out.println("Is Numeric = " + b1);
		
		Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
		boolean b2 = lowerCaseValidator.validate("abscdeg");
		System.out.println("Is Lower Case = " + b2);
		
		
		//
		// --- Strategy using lambda expressions
		//
		Helper.print("Strategy using lambda expressions");
		Validator numericValidatorLambda = new Validator((String s) -> s.matches("[a-z]+"));
		boolean b3 = numericValidatorLambda.validate("absdefg");
		System.out.println("Is Numeric = " + b3);
		
		Validator lowerCaseValidatorLambda = new Validator((String s) -> s.matches("\\d+"));
		boolean b4  = lowerCaseValidatorLambda.validate("abcdefg");
		System.out.println("Is lower case = " + b4);
	}

}
