package eu.rtakacs.path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PathsTest {

	public static void main(String[] args) throws URISyntaxException, IOException {
		

		Path p1 = Paths.get("");
		testPath(p1,"this project");
		
		
		Path p2 = Paths.get("C:", "Windows","assembly");
		testPath(p2, "Windows Global Assembly Cache");
		
		pathManipulation(p1.toAbsolutePath(), p2);
		
		URI uri1 = URI.create("file:///"+p1.toAbsolutePath().toString().replaceAll("\\\\", "/"));
		testPath(Paths.get(uri1), "URI file");
		
//		URI uri2 = new URI("http://docs.oracle.com/javase/8/docs/api/index.html?java/nio/file/Paths.html");
//		testPath(Paths.get(uri2), "URI Javadoc Paths");
		

	}
	public static void testPath(Path path, String name) throws IOException{
		Helper.print(name);
		path = path.toAbsolutePath();
		System.out.println("path.toString() = " + path.toString());
		System.out.println("path.toAbsolutePath() = " + path.toAbsolutePath());
		System.out.println("path.toUri() = " + path.toUri());
		System.out.println("path.getNameCount() = " + path.getNameCount());
		System.out.println("path.getFileName() = " + path.getFileName());
		System.out.println("path.getParent() = " + path.getParent());
		
		System.out.println("Iterator: ");
		Iterator<Path> pathIt = path.iterator();
		while(pathIt.hasNext()){
			System.out.print(pathIt.next()+" ");
		}
		System.out.println();
		
		System.out.println( "path.endsWith('assembly') = " + path.endsWith("assembly"));
		System.out.println("path.getNameCount() = " + path.getNameCount());
		System.out.println("path.getRoot() = " + path.getRoot());
		System.out.println("path.isAbsolute() = " + path.isAbsolute());
		System.out.println("path.normalize() = " + path.normalize());
		System.out.println("path.toFile() = " + path.toFile());
		System.out.println("path.subpath(0, 2) = " + path.subpath(0, 2));
		
		System.out.println("path.toRealPath() = " + path.toRealPath());
	}
	
	public static void pathManipulation(Path path1, Path path2){
		
		Helper.print("Path Manipulation");
		System.out.println(path1);
		System.out.println(path2);
		
		System.out.println("path1.relativize(path2) = " + path1.relativize(path2));
		System.out.println("path2.relativize(path1) = " + path2.relativize(path1));
		
		System.out.println("path1.resolve(path2) = " + path1.resolve(path2));
		System.out.println("path2.resolve(path1) = " + path2.resolve(path1));
		
		System.out.println("path1.resolveSibling(path2) = " + path1.resolveSibling(path2));
		System.out.println("path1.resolveSibling('DateTime') = " + path1.resolveSibling("DateTime"));
		
		
	}
}
