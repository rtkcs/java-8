package eu.rtakacs.twr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesTest {

	public static void main(String[] args) throws Exception {
		readFirstLineFromFile("file.txt");
		// readFirstLineFromFile("nonExistingFile.txt");

		readFirstLineFromFileWithFinallyBlock("file.txt");
//		readFirstLineFromFileWithFinallyBlock("nonExistingFile.txt");
		
		writeToFileZipFileContents("file.zip", "zipFileContent.txt");
	}

	static String readFirstLineFromFile(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			System.out.println("using BufferedReader1");
			return br.readLine();
		}
	}

	static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			System.out.println("using BufferedReader2");
			return br.readLine();
		} finally {
			if (br != null)
				br.close();
		}
	}

	public static void writeToFileZipFileContents(String zipFileName, String outputFileName) throws java.io.IOException {

		java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.US_ASCII;
		java.nio.file.Path outputFilePath = java.nio.file.Paths.get(outputFileName);

		// Open zip file and create output file with
		// try-with-resources statement

		try (java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
				java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset)) {
			// Enumerate each entry
			for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {
				// Get the entry name and write it to the output file
				String newLine = System.getProperty("line.separator");
				String zipEntryName = ((java.util.zip.ZipEntry) entries.nextElement()).getName() + newLine;
				writer.write(zipEntryName, 0, zipEntryName.length());
			}
		}
	}

}
