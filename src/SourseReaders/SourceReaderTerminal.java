package SourseReaders;

import java.io.InputStream;
import java.util.Scanner;

public class SourceReaderTerminal extends SourceReader {
	public SourceReaderTerminal() {
		this.scanner = new Scanner(System.in);
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
