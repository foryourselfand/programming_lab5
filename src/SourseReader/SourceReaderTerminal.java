package SourseReader;

import java.io.InputStream;
import java.util.Scanner;

public class SourceReaderTerminal extends SourceReader {
	public SourceReaderTerminal(InputStream inputStream){
		this.scanner = new Scanner(inputStream);
	}
	
	@Override
	public boolean hasSomethingToRead() {
		return true;
	}
	
	@Override
	public String getPostfix(String lineRead) {
		return "";
	}
	
	@Override
	public String getSource() {
		return "Терминал";
	}
}
