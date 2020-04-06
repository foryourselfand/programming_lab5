package SourseReader;

import java.util.Scanner;

public class SourceReaderString extends SourceReader {
	public SourceReaderString(String value){
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
}
