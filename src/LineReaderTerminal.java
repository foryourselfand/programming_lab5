import java.io.InputStream;
import java.util.Scanner;

public class LineReaderTerminal extends LineReader {
	public LineReaderTerminal(InputStream inputStream) {
		this.scanner = new Scanner(System.in);
	}
	
	@Override
	boolean hasSomethingToRead() {
		return true;
	}
	
	@Override
	String getPostfix(String lineReaded) {
		return "";
	}
}
