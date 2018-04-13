package eu.rtakacs.pathmatcher;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest {

	public static void print(String matchString, PathMatcher pathMatcher, Path path){
		
		System.out.println("match string = " + matchString);
		System.out.println("path = " + path);
		System.out.println("pathMatcher = " + pathMatcher.matches(path));
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		FileSystem fileSystem = FileSystems.getDefault();
		
		String matchString1 = "glob:C:/**/*.java";
		PathMatcher pathMatcher1 = fileSystem.getPathMatcher(matchString1);
		Path path1 = Paths.get("src", "eu", "rtakacs", "pathmatcher", "PathMatcherTest.java" ).toAbsolutePath();
		print(matchString1, pathMatcher1, path1);
		
		
		String matchString2 = "glob:**.{java,class,txt}";
		PathMatcher pathMatcher2 = fileSystem.getPathMatcher(matchString2);
		Path path2 = Paths.get("src", "eu", "rtakacs", "pathmatcher", "PathMatcherTest.java" ).toAbsolutePath();
		print(matchString2, pathMatcher2, path2);
		
		
		String matchString3 = "glob:**/testFile.?";
		PathMatcher pathMatcher3 = fileSystem.getPathMatcher(matchString3);
		Path path3  = Paths.get("src", "eu", "rtakacs", "pathmatcher", "PathMatcherTest.java" ).toAbsolutePath();
		Path path3a = Paths.get("src", "eu", "rtakacs", "pathmatcher", "testFile.j" ).toAbsolutePath();
		print(matchString3, pathMatcher3, path3);
		print(matchString3, pathMatcher3, path3a);
	}
}
