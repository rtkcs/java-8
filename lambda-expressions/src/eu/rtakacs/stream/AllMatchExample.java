package eu.rtakacs.stream;

import java.util.Arrays;
import java.util.List;

public class AllMatchExample {

	public static void main(String[] args) {
		List<String> programmingLanguages = Arrays.asList("python","C++","C", "C#", "java");
		
		boolean flag = programmingLanguages.stream().allMatch(
				str -> {
					System.out.println(str);
					return str.equals("python");
		});
		System.out.println(flag);

	}

}
