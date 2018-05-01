package eu.rtakacs.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class IsSameFileTest {

	public static void main(String[] args) throws IOException {
		
		File f = new File("resources\\p1.txt");
		f.createNewFile();
		
		Path p1 = f.toPath().toAbsolutePath();
//		Path p1 = Paths.get("resources\\");
		Path p2 = Paths.get("resources\\p2.txt").toAbsolutePath();
		
		Files.copy(p1, p2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
		
		if(Files.isSameFile(p1, p2)){
			System.out.println("isSameFile(p1,p2) = true");
		} else {
			System.out.println("isSameFile(p1,p2) = false");
		}
		
		f.deleteOnExit();
		p2.toFile().deleteOnExit();
	}

}
