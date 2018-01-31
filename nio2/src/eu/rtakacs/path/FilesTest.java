package eu.rtakacs.path;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
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
		
		
		Helper.print("Files.list : " );
		Files.list(path).forEach(p -> System.out.println(" - " + p));
		
		Helper.print("Files.createTemp");
		Path pathTempDir = Files.createTempDirectory("prefix");
		System.out.println("Files.createTempDirectory = " + pathTempDir);
		pathTempDir.toFile().deleteOnExit();
		Path pathTempFile = Files.createTempFile("tempFilePrefix", ".suffix");
		System.out.println("Files.createTempFile = " + pathTempFile);
		pathTempFile.toFile().deleteOnExit();
		
		Path pathTempFile2 = Files.createTempFile(pathTempDir, "", ".temp");
		System.out.println("Files.createTempFile(Path, prefix, suffix, FileAttribute<?>");
		
		
//		System.out.println("Files. = " + Files.);
//		System.out.println("Files. = " + Files.);
//		System.out.println("Files. = " + Files.);
		
		Helper.print("Files.getPosixFilePermissions:");
		try {
			Set<PosixFilePermission> filePermissions = Files.getPosixFilePermissions(path);
			Files.getPosixFilePermissions(path).forEach(s -> System.out.println(s.name()));
		} catch(UnsupportedOperationException | ClassCastException | SecurityException | IOException e){
			System.out.println("  Exception = " + e.getClass());
		}
		
		Helper.print("Files.getFileAttributeView");
		BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		System.out.println("BasicFileAttributeView.name = " + view.name());
		BasicFileAttributes attributes = view.readAttributes();
		System.out.println("BasicFileAttributes.size = " + attributes.size());
		System.out.println("BasicFileAttributes.isDirectory = " + attributes.isDirectory());
		System.out.println("BasicFileAttributes.creationTime = " + attributes.creationTime());
		System.out.println("BasicFileAttributes.isSymbolicLink = " + attributes.isSymbolicLink());
		System.out.println("BasicFileAttributes.isRegularFile = " + attributes.isRegularFile());
		System.out.println("BasicFileAttributes.fileKey = " + attributes.fileKey());
		System.out.println("BasicFileAttributes.isOther = " + attributes.isOther());
		System.out.println("BasicFileAttributes.lastAccessTime = " + attributes.lastAccessTime());
		System.out.println("BasicFileAttributes.lastModifiedTime = " + attributes.lastModifiedTime());
		
		
		filesWrite1();
		filesWrite2();
		filesWrite3();
	}
	
	public static void filesWrite1() {
		Helper.print("filesWrite1");
		Path pathResources = Paths.get("","resources", "testFile1.txt").toAbsolutePath();
		System.out.println("Creating file: " + pathResources);

		try {
			Files.deleteIfExists(pathResources);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> content = new LinkedList<>();
		content.add("File written with function Files.write(Path, Iterable<? extends CharSequence>, Charset, OpenOptions ...");
		content.add("1. line");
		content.add("2. line");
		content.add("3. line");
		
		try {
			Files.write(pathResources, content, Charset.forName("utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void filesWrite2() {
		Helper.print("filesWrite2");
		Path pathResources = Paths.get("","resources", "testFile2.txt").toAbsolutePath();
		System.out.println("Creating file: " + pathResources);
		
		StringBuilder sb = new StringBuilder("File written with function Files.write(Path, bytes[])");
		sb.append(System.lineSeparator());
		sb.append("1. line");
		sb.append(System.lineSeparator());
		sb.append("2. line");
		sb.append(System.lineSeparator());
		sb.append("3. line");
		
		try {
			Files.write(pathResources, sb.toString().getBytes());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void filesWrite3() {
		Helper.print("filesWrite3");
		Path pathResources = Paths.get("","resources", "testFile3.txt").toAbsolutePath();
		System.out.println("Creating file: " + pathResources);
		
		try (BufferedWriter bw = Files.newBufferedWriter(pathResources, Charset.forName("utf-8"))){
			bw.write("File written with BufferedWriter, Files.newBufferedWriter(Path path, Charset cs, OpenOption... options)");
			bw.newLine();
			bw.write("1. line");
			bw.newLine();
			bw.write("2. line");
			bw.newLine();
			bw.write("3. line");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
