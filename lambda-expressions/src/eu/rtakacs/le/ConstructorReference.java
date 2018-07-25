package eu.rtakacs.le;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {
	
	int i;
	public ConstructorReference() {
		this.i = 1;
	}
	public ConstructorReference(int i) {
		this.i = i;
	}
	public void print() {
		System.out.println(this.i);
	}
	
	
	public static void main(String[] args) {
		Supplier<ConstructorReference> s = ConstructorReference::new;
		ConstructorReference cr1 = s.get();
		cr1.print();
		
		Function<Integer, ConstructorReference> f = ConstructorReference::new;
		ConstructorReference cr2 = f.apply(5);
		cr2.print();
		
//		Supplier<ConstructorReference> s2 = ConstructorReference::new(10);//Syntax error on token "new", AssignmentOperator expected after this token
//		Supplier<ConstructorReference> s3 = ConstructorReference(10)::new;//The method ConstructorReference(int) is undefined for the type ConstructorReference
	}

}
