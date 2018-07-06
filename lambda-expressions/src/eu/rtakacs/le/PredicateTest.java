package eu.rtakacs.le;

import java.util.function.Predicate;

class Employee{
	int age;
}

public class PredicateTest {

	public static boolean validateEmployee(Employee e, Predicate<Employee> p) {
		return p.test(e);
	}
	
	public static void main(String[] args) {
		Employee e = new Employee();
		System.out.println(validateEmployee(e, p -> p.age<1000));
//		System.out.println(validateEmployee(e, e -> e.age<1000));//Lambda expression's parameter e cannot redeclare another local variable defined in an enclosing scope. 
	}

}
