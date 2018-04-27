package eu.rtakacs.filevisitor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class JavaFileChecker extends SimpleFileVisitor<Path> {

	private final PathMatcher matcher;
	private static int count;
	
	public JavaFileChecker(){
		matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
	}
	
	void check(Path p){
		System.out.println(p);
		if(p!=null && matcher.matches(p)){
			count++;
		}
	}
	
	public int getCount(){
		return count;
	}
	
	public FileVisitResult visitFile(Path p, BasicFileAttributes attrs){
		check(p);
		return FileVisitResult.CONTINUE;
	}
	
	public static void main(String[] args) throws IOException{
		JavaFileChecker jfc = new JavaFileChecker();
		Files.walkFileTree(Paths.get("").toAbsolutePath(), jfc);
		System.out.println("Number of *.java files = " + jfc.getCount());
	}
}
