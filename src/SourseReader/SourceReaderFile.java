package SourseReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SourceReaderFile extends SourceReader {
	private String path;
	
	public SourceReaderFile(String path) throws FileNotFoundException {
		this.path = path;
		this.scanner = new Scanner(new File(path));
	}
	
	@Override
	public boolean hasSomethingToRead() {
		return this.scanner.hasNextLine();
	}
	
	@Override
	public String getPostfix(String lineRead) {
		return lineRead + "\n";
	}
	
	@Override
	public String getSource() {
		return path;
	}
}
