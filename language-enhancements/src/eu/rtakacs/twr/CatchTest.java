package eu.rtakacs.twr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.NoSuchFileException;

public class CatchTest {

	public static void main(String[] args) {
		try (BufferedReader bfr = new BufferedReader(new FileReader("c:\\works\\a.java"))) {
			String line = null;
			while ((line = bfr.readLine()) != null) {
				System.out.println(line);
			}
		}
		// The exception AccessDeniedException is already caught by the
		// alternative IOException
		// The exception NoSuchFileException is already caught by the
		// alternative IOException
		// catch (NoSuchFileException | IOException | AccessDeniedException e) {
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
