package SourseReader;

import java.io.FileNotFoundException;

public class SourceReaderFactory {
	private static SourceReader sourceReaderTerminal = new SourceReaderTerminal(System.in);
	
	public static SourceReader getSourceReaderTerminal() {
		return sourceReaderTerminal;
	}
	
	public static SourceReader getSourceReaderFile(String path) throws FileNotFoundException {
		return new SourceReaderFile(path);
	}
}
