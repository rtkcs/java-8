package eu.rtakacs.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.time.Instant;


public class FilesTest2 {

	public static void main(String[] args) throws IOException {
		
		Path resources = Paths.get("resources").toAbsolutePath();
		
		//move
		Path file1 = Files.createTempFile(resources, "file1", ".txt");
		System.out.println("File1 created: " + file1.toAbsolutePath());
		
		Files.write(file1, "file1".getBytes());
		Files.setAttribute(file1, "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
		Files.setAttribute(file1, "dos:readonly", true);
		Files.setLastModifiedTime(file1, FileTime.from(Instant.MIN));
		
		Path file2 = Files.createTempFile(resources, "file2", ".txt");
		System.out.println("File2 created: " + file2.toAbsolutePath() );
		
		Files.move(file1, file2, StandardCopyOption.ATOMIC_MOVE);
		try {
			Files.delete(file1);
		} catch(NoSuchFileException e) {
			e.printStackTrace();
		}
		System.out.println( "file1.toFile().exists() = " + file1.toFile().exists() );
		System.out.println( "file2.toFile().exists() = " + file2.toFile().exists() );
		
		file2.toFile().deleteOnExit();
		
		//copy attributes
		
	}

}
