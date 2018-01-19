package eu.rtakacs.stream.oo.chainofresponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponsibilityTest {

	public static void main(String[] args) {
		ProcessingObject<String> p1 = new HeaderTextProcessing();
		ProcessingObject<String> p2 = new FooterTextProcessing();
		p1.setSuccessor(p2);
		
		String result = p1.handle("Lambdas in Java 8");
		System.out.println(result);
		
		//
		//--- Observer using lambda expressions
		//
		
		UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
		UnaryOperator<String> footerProcessing = (String text) -> text + System.getProperty("line.separator") + "\t\t\t\t\t\t Lambda expression observer, UnaryOperator";
		Function<String, String> pipeline = headerProcessing.andThen(footerProcessing);
		String s = pipeline.apply("Lambdas in Java 8");
		System.out.println(s);
	}

}
