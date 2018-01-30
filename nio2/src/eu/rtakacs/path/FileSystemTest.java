package eu.rtakacs.path;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;



public class FileSystemTest {

	public static void main(String[] args) {
		
		FileSystem fs = FileSystems.getDefault();

		System.out.println("FileSystem.getSeparator = " + fs.getSeparator());
		System.out.println("FileSystem.isOpen = " + fs.isOpen());
		System.out.println("FileSystem.isReadOnly = " + fs.isReadOnly());
		System.out.println("FileSystem.provider = " + fs.provider());
		
		System.out.println("FileSystem.FileStores: ");
		fs.getFileStores().forEach(s -> {System.out.println(" - " + s);});
		
		System.out.println("FileSystem.supportedFileAttributeViews:");
		fs.supportedFileAttributeViews().forEach(s -> System.out.println(" - "+s));
		
		System.out.println("FileSystem.getRootDirectories:");
		fs.getRootDirectories().forEach(s -> System.out.println(" - " + s));
		
		System.out.println("FileSystem.getPath = " + fs.getPath("C:","Windows", "assembly"));


	}

}
