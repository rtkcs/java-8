package eu.rtakacs.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesIsSameFileTest {

	public static void main(String[] args) throws IOException {

		Path path1 = Paths.get("resources\\fileToCopy.txt").toAbsolutePath();
		Path path2 = Paths.get("resources\\fileCopied.txt").toAbsolutePath();
		
		if(!Files.exists(path1)) {
			Files.createFile(path1);
		}
		
		Files.copy(path1, path2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
		
		if(Files.isSameFile(path1, path2)) {
			System.out.println("Files.isSameFile = true");
		}else {
			System.out.println("Files.isSameFile = false");
		}
	}

}
