package SourseReader;

import java.util.Scanner;

abstract public class SourceReader {
	protected Scanner scanner;
	
	abstract public boolean hasSomethingToRead();
	
	abstract public String getPostfix(String lineRead);
	
	public String getLineReadPrintPostfix() {
		String lineRead = this.scanner.nextLine();
		
		String postfix = this.getPostfix(lineRead);
		System.out.print(postfix);
		
		return lineRead;
	}
}
