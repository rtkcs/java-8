package eu.rtakacs.swtch;

public class SwitchNPETest {

	public static void main(String[] args) {
		String str = null;
		switch(str) {
			case "null" : System.out.println("null");
				break;
			case "": System.out.println();
				break;
			default: System.out.println("default");
		}

	}

}
