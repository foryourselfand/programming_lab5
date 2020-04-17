package SourseReaders;

import java.util.Scanner;

public class SourceReaderString extends SourceReader {
	private String source;
	
	public SourceReaderString(String value) {
		this.source = value;
		this.scanner = new Scanner(value);
	}
	
	@Override
	public boolean hasSomethingToRead() {
		return true;
	}
	
	@Override
	public String getPostfix(String lineRead) {
		return lineRead + "\n";
	}
	
	@Override
	public String getSource() {
		return source;
	}
}
