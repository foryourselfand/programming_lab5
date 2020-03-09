import SourseReader.SourceReader;
import SourseReader.SourceReaderFile;
import SourseReader.SourceReaderTerminal;

import java.io.FileNotFoundException;

public class LineReader {
	private SourceReader sourceReaderTerminal;
	private SourceReader sourceReaderActive;
	
	public LineReader() {
		sourceReaderTerminal = new SourceReaderTerminal(System.in);
		sourceReaderActive = sourceReaderTerminal;
	}
	
	public boolean hasSomethingToRead() {
		return this.sourceReaderActive.hasSomethingToRead();
	}
	
	public void setSourceReader(String path) throws FileNotFoundException {
		this.sourceReaderActive = new SourceReaderFile(path);
	}
	
	public String readLine(String prefix, boolean repeatOnException) {
		String lineRead = "";
		boolean needToRead = true;
		
		while (needToRead) {
			
			if (! this.sourceReaderActive.hasSomethingToRead())
				this.sourceReaderActive = sourceReaderTerminal;
			
			System.out.print(prefix);
			try {
				lineRead = this.sourceReaderActive.getLineReadPrintPostfix();
				
				needToRead = false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
				lineRead = "";
				if (! repeatOnException)
					needToRead = false;
			}
		}
		
		return lineRead;
	}
}
