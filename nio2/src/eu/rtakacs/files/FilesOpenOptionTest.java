package eu.rtakacs.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilesOpenOptionTest {

	public static void main(String[] args) throws IOException {
		
		Path resources = Paths.get("resources").toAbsolutePath();
		Path fileWrite = Files.createTempFile(resources, "write", ".txt");
		System.lineSeparator();
		
		Files.write(fileWrite, ("fileWrite StandardOpenOption.CREATE" +  System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		//java.nio.file.FileAlreadyExistsException
//		Files.write(fileWrite, ("fileWrite StandardOpenOption.CREATE_NEW" +  System.lineSeparator()).getBytes(), StandardOpenOption.CREATE_NEW);
		Files.write(fileWrite, ("fileWrite StandardOpenOption.WRITE" +  System.lineSeparator()).getBytes(), StandardOpenOption.WRITE);
		Files.write(fileWrite, ("fileWrite StandardOpenOption.APPEND" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
		//java.lang.IllegalArgumentException: APPEND + TRUNCATE_EXISTING not allowed
//		Files.write(fileWrite, "fileWrite 2".getBytes(), StandardOpenOption.APPEND, StandardOpenOption.TRUNCATE_EXISTING);

	}

}
