package SourseReaders;

import java.util.Scanner;

abstract public class SourceReader {
	protected Scanner scanner;
	
	abstract public boolean hasSomethingToRead();
	
	abstract public String getPostfix(String lineRead);
	
	public String getLineReadPrintPostfix() {
		String lineRead = scanner.nextLine();
		
		String postfix = this.getPostfix(lineRead);
		System.out.print(postfix);
		
		return lineRead;
	}
	
	public abstract String getSource();
}
