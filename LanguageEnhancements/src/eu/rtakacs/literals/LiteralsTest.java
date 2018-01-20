package eu.rtakacs.literals;

public class LiteralsTest {

	public static void main(String[] args) {
		
		int x = 1___3;
		long y = 1__________3;
		float z = 3.141_592_653_59f;
		System.out.println(x + " " + y + " " +z);
		
//		long a = _123L;		//cannot be resolved to a variable
//		long b = 123_L; 	//Underscores have to be located within digits
//		float c = 3._14159; //Underscores have to be located within digits
		
		// A floating point number written in binary cannot use any suffix. 
		// But a floating point number written in decimal or hex can use the floating point suffices f, F, d, and D.
		// You might want to go through Section 3.10.1 and 3.10.2 of Java Language Specification to understand how this works.
		float x1  = 0x10_000;	//hex 
		float x10 = 0X10_000;	//hex
		
		float x2 = 10_000f;		//decimal
		
		float x3 = 0b10000;		//binary
		float x4 = 0B10000;		//binary		
	}

}
