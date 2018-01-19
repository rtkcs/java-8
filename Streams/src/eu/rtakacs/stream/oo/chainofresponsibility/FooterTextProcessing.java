package eu.rtakacs.stream.oo.chainofresponsibility;

public class FooterTextProcessing extends ProcessingObject<String> {

	@Override
	protected String handleWork(String s) {
		return s + System.getProperty("line.separator") + "\t\t\t\t\t\t normal observer";
	}

}
