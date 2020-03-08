import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineReaderFile extends LineReader {
	public LineReaderFile(String filePath) throws FileNotFoundException {
		this.scanner = new Scanner(new File(filePath));
	}
	
	@Override
	boolean hasSomethingToRead() {
		return this.scanner.hasNextLine();
	}
	
	@Override
	String getPostfix(String lineReaded) {
		return lineReaded + "\n";
	}
}
