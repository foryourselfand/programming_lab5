import java.util.Scanner;

abstract public class LineReader {
	protected Scanner scanner;
	
	public String readLine(String prefix) {
		System.out.print(prefix);
		
		String lineReaded = this.scanner.nextLine();
		
		String postfix = this.getPostfix(lineReaded);
		
		System.out.print(postfix);
		
		return lineReaded;
	}
	
	abstract boolean hasSomethingToRead();
	
	abstract String getPostfix(String lineReaded);
}
