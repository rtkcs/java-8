package eu.rtakacs.path;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileSystemTest {

	public static void main(String[] args) {
		
		FileSystem fs = FileSystems.getDefault();
		System.out.println("FileSystem.isOpen = " + fs.isOpen());
		System.out.println("FileSystem.getSeparator = " + fs.getSeparator());
		System.out.println("FileSystem.isReadOnly = " + fs.isReadOnly());
		System.out.println("FileSystem.supportedFileAttributeViews:");
		fs.supportedFileAttributeViews().forEach(s->{System.out.println(" - "+s);});
		
	}

}
