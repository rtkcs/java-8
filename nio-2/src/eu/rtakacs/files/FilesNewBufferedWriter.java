package eu.rtakacs.files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.UserPrincipal;

public class FilesNewBufferedWriter {

	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("resources\\bufferedWriter.txt").toAbsolutePath();

		UserPrincipal principal = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("administrator");
		try{
			Files.setAttribute(path, "dos:readonly", false);
			Files.setOwner(path, principal);
		} catch(IOException e){
			e.printStackTrace();
		}		
		
//		try(BufferedWriter bw = Files.newBufferedWriter(path, Charset.forName("UTF-8"), new OpenOption[]{StandardOpenOption.WRITE, StandardOpenOption.DSYNC})){
//		try(BufferedWriter bw = Files.newBufferedWriter(path, Charset.forName("UTF-8"), new OpenOption[]{StandardOpenOption.APPEND, StandardOpenOption.SYNC})){
//		try(BufferedWriter bw = Files.newBufferedWriter(path, Charset.forName("UTF-8"), new OpenOption[]{StandardOpenOption.APPEND, StandardOpenOption.WRITE})){
		try(BufferedWriter bw = Files.newBufferedWriter(path, Charset.forName("UTF-8"), new OpenOption[]{StandardOpenOption.APPEND, StandardOpenOption.WRITE, StandardOpenOption.DSYNC})){
			bw.write("written from buffered writer"+System.lineSeparator());
		}
		
		System.out.println("done");
		
		
		//
		//-- create new file, if file exists truncate existing
		//
		Path path2 =Paths.get("resources\\newFile.txt").toAbsolutePath();
//		try(BufferedWriter bw = Files.newBufferedWriter(path2, Charset.forName("UTF-8"), new OpenOption[]{StandardOpenOption.CREATE})){		// will create always a new file
//		try(BufferedWriter bw = Files.newBufferedWriter(path2, Charset.forName("UTF-8"), new OpenOption[]{StandardOpenOption.CREATE_NEW})){	// if file exists, will throw an java.nio.file.FileAlreadyExistsException
//		try(BufferedWriter bw = Files.newBufferedWriter(path2, Charset.forName("UTF-8"), new OpenOption[]{StandardOpenOption.WRITE})){
//		try(BufferedWriter bw = Files.newBufferedWriter(path2, Charset.forName("UTF-8"), new OpenOption[]{StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE_NEW})){ // if file exists, will throw an java.nio.file.FileAlreadyExistsException
		try(BufferedWriter bw = Files.newBufferedWriter(path2, Charset.forName("UTF-8"), new OpenOption[]{StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE})){
			
			bw.write("only 1 line written"+System.lineSeparator());
		}
		System.out.println("done, create new, truncate existing " + path2);
	}

}
