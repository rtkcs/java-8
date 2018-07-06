package eu.rtakacs.le;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;

class Student{
	private String name;
	private int marks;
	
	Student(String name, int marks){
		this.name = name;
		this.marks = marks;
	}
	
	void addMarks(int m){
		this.marks+=m;
	}
	void debug() {
		System.out.println(this.name+ ":" + this.marks);
	}
	
}

public class StreamTest1 {

	public static void main(String[] args) {
		//hello,world
		//hello,world
		List<StringBuilder> messages = Arrays.asList(new StringBuilder(), new StringBuilder());
		messages.stream().forEach(s -> s.append("helloworld"));
		messages.forEach(s -> {s.insert(5, ","); System.out.println(s);});
		
		//0
		//1
		List<Integer> integers = Arrays.asList(new Integer(0), new Integer(1));
		integers.stream().forEach(c -> {c = c + 10;});
		integers.forEach(c -> System.out.println(c));
		
		//s1:15
		//s2:25
		//s3:35
		List<Student> sList = Arrays.asList(new Student("s1", 10), new Student("s2", 20), new Student("s3",30));
		Consumer<Student> increaseMarks = s -> s.addMarks(5);
		sList.forEach(increaseMarks);
		sList.stream().forEach(Student::debug);
		
		//10.0
		//12.0
		List<Double> dList = Arrays.asList(10.0, 12.0);
		Consumer<Double> df = x -> x=x+10;
		dList.stream().forEach(df);
		dList.forEach(d -> System.out.println(d));
	}

}
