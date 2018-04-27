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

public class FileVisitorT extends SimpleFileVisitor<Path> {
	
	PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/{n*,r*}");

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		
		System.out.println(dir);
		
		if(pathMatcher.matches(dir)){
			return FileVisitResult.CONTINUE;
		}else{
			return FileVisitResult.SKIP_SUBTREE;
		}
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}


	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println("Visited file: " + file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	public static void main(String[] args) throws IOException {
		FileVisitorT fvt = new FileVisitorT();
		Files.walkFileTree(Paths.get("").toAbsolutePath(), fvt);
	}
}
