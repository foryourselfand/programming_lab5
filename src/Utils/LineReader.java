package Utils;

import SourseReader.SourceReader;
import SourseReader.SourceReaderFactory;

public class LineReader {
	private SourceReader sourceReader;
	private boolean repeatOnException;
	
	public LineReader(SourceReader sourceReader, boolean repeatOnException) {
		this.sourceReader = sourceReader;
		this.repeatOnException = repeatOnException;
	}
	
	public LineReader() {
		this.sourceReader = SourceReaderFactory.getSourceReaderTerminal();
		this.repeatOnException = false;
	}
	
	public String readLine(String prefix) {
		String lineRead = "";
		boolean needToRead = true;
		
		while (needToRead && this.hasSomethingToRead()) {
			
			System.out.print(prefix);
			try {
				lineRead = this.sourceReader.getLineReadPrintPostfix();
				
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
	
	public boolean hasSomethingToRead() {
		if (! this.sourceReader.hasSomethingToRead())
			this.sourceReader = SourceReaderFactory.getSourceReaderTerminal();
		return this.sourceReader.hasSomethingToRead();
	}
	
	public void setSourceReader(SourceReader sourceReader) {
		this.sourceReader = sourceReader;
	}
	
	public void setRepeatOnException(boolean repeatOnException) {
		this.repeatOnException = repeatOnException;
	}
}
