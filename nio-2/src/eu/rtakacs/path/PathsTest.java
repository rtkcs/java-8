package eu.rtakacs.path;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
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
		
		
		examQuestions();
		

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
	
	public static void examQuestions() {

		Helper.print("exam question 1");
		Path p3 = Paths.get("c:\\data_app\\reports\\daily\\rt.txt");
		System.out.println(p3);
		System.out.println("p3.subpath(1, 2) = " + p3.subpath(1, 2));
		System.out.println("p3.subpath(0, 2) = " + p3.subpath(0, 2));
//		System.out.println("p3.subpath(0, 0) = " + p3.subpath(0, 0));//java.lang.IllegalArgumentException
		
		Helper.print("exam question 2");
		Path p4 = Paths.get("c:\\Users\\.\\Mike\\Pictures\\..\\aboutMe.txt");
		Path p5 = Paths.get("c:\\Users\\readme.txt");
		System.out.println("p4 = " + p4);
		System.out.println("p5 = " + p5);
		System.out.println("p4.relativize(p5) = " + p4.relativize(p5));
		System.out.println("p4.normalize() = " + p4.normalize());
		System.out.println("p4.getRoot = " + p4.getRoot());
		
		Helper.print("exam question 3 - print roots of a file system");
		Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
		System.out.println("Iterable<Path> roots = FileSystems.getDefault().getRootDirectories()");
		for(Path p : roots) {
			System.out.println(p);
		}
		System.out.println("File[] rootFiles = File.listRoots();");
		File[] rootFiles = File.listRoots();
		for(File f : rootFiles) {
			System.out.println(f);
		}
		
		Helper.print("exam question 4");
		Path p6 = Paths.get("\\Users\\Mike");
		Path p7 = Paths.get("\\readme.txt");
		System.out.println("p6 = " + p6);
		System.out.println("p7 = " + p7);
		System.out.println("p6.relativize(p7) = " + p6.relativize(p7));
		System.out.println("p6.resolve(p7) = " + p6.resolve(p7));
		System.out.println("p6.getRoot() = " + p6.getRoot());
		
		Helper.print("exam question 5");
		Path p8 = Paths.get("Users\\Mike");
		Path p9 = Paths.get("readme.txt");
		System.out.println("p8 = " + p8);
		System.out.println("p9 = " + p9);
		System.out.println("p8.relativize(p9) = " + p8.relativize(p9));
		
		
		Helper.print("exam question 6");
		Path p10 = Paths.get("c:\\code\\java\\PathTest.java");
		System.out.println("p10 = " + p10);
		System.out.println("p10.getNameCount = " + p10.getNameCount());
		System.out.println("p10.getRoot = " + p10.getRoot());
		System.out.println("p10.getName(0) = " + p10.getName(0));
		System.out.println("p10.getName(1) = " + p10.getName(1));
		System.out.println("p10.getName(2) = " + p10.getName(2));
		System.out.println("p10.startsWith(\"c:\\\") = " + p10.startsWith("c:\\"));
		System.out.println("p10.startsWith(\"c:\\code\") = " + p10.startsWith("c:\\code"));
		System.out.println("p10.endsWith(\"PathTest.java\") = " + p10.endsWith("PathTest.java"));
		
		
		Helper.print("exam question 7");
		Path p11Source = Paths.get("\\Users\\Mike");
		Path p12Target = Paths.get("\\Users\\John");
		Path p13 = Paths.get("\\Users\\Mike\\dirToCopy");
		Path p14 = Paths.get("dirToCopy");
		System.out.println("p11Source = " + p11Source);
		System.out.println("p12Target = " + p12Target);
		System.out.println("p13 = " + p13);
		System.out.println(p11Source.relativize(p13));
		System.out.println(p12Target.resolve( p11Source.relativize(p13)) );

		System.out.println(p11Source.relativize(p14));
		System.out.println(p12Target.resolve( p11Source.relativize(p14)) );
		
		
		
	}
}
