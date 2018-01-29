package eu.rtakacs.path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class FilesTest {

	public static void main(String[] args) throws IOException {
		
		// Check, delete, copy, or move a file or directory by using the Files class 

		Path path = Paths.get("").toAbsolutePath();
		System.out.println("Current working path = " + path);
		System.out.println("Files.exists = " + Files.exists(path, LinkOption.NOFOLLOW_LINKS));
		System.out.println("Files.size = " + Files.size(path));
		System.out.println("Files.getLastModifiedTime = " + Files.getLastModifiedTime(path));
		System.out.println("Files.getOwner = " + Files.getOwner(path, LinkOption.NOFOLLOW_LINKS));
		System.out.println("Files.isDirectory = " + Files.isDirectory(path));
		System.out.println("Files.isExecutable = " + Files.isExecutable(path));
		System.out.println("Files.isHidden = " + Files.isHidden(path));
		System.out.println("Files.isReadable = " + Files.isReadable(path));
		System.out.println("Files.isRegularFile = " + Files.isRegularFile(path));
		System.out.println("Files.isSameFile(path, path) = " + Files.isSameFile(path, path));
		System.out.println("Files.isSymbolicLink = " + Files.isSymbolicLink(path));
		System.out.println("Files.isWritable = " + Files.isWritable(path));
		
//		System.out.println("Files.lines = " + Files.lines(path));
//		System.out.println("Files.lines(path, defaultCharset) = " + Files.lines(path, Charset.defaultCharset()));
		
		
		System.out.println("Files.list : " );
		Files.list(path).forEach(p -> System.out.println(" - " + p));
		
		
		
//		System.out.println("Files. = " + Files.);
//		System.out.println("Files. = " + Files.);
//		System.out.println("Files. = " + Files.);
		
		System.out.print("Files.getPosixFilePermissions:");
		try {
			Set<PosixFilePermission> filePermissions = Files.getPosixFilePermissions(path);
			Files.getPosixFilePermissions(path).forEach(s -> System.out.println(s.name()));
		} catch(UnsupportedOperationException | ClassCastException | SecurityException | IOException e){
			System.out.println("  Exception = " + e.getClass());
		}
		
		createFile();
	}
	
	public static void createFile() {
		
		Path pathResources = Paths.get("","resources").toAbsolutePath();
		System.out.println(pathResources);
//		Path path = Paths.get("", "testFile.txt");
		Path pathTestFile = pathResources.resolve("testFile.txt");
		System.out.println(pathTestFile);
		try {
			Files.deleteIfExists(pathTestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> content = new LinkedList<>();
		content.add("1. line");
		content.add("2. line");
		content.add("3. line");
		
		try {
			Files.write(pathTestFile, content, Charset.forName("utf-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
