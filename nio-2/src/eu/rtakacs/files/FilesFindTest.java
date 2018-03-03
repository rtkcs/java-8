package eu.rtakacs.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesFindTest {

	public static void main(String[] args) throws IOException {
		
		Path startPath = Paths.get("C:\\Program Files (x86)");

		Stream<Path> sPaths = Files.find(startPath, 1, (p,a)->p.endsWith("Mozilla Firefox") && a.isDirectory());
		sPaths.forEach(p->System.out.println(p));
		
		sPaths = Files.find(startPath, 2, (p,a)->p.endsWith("firefox.exe") && a.isRegularFile());
		sPaths.forEach(p->System.out.println(p));
		
		System.out.println("Search ended");
	}

}
