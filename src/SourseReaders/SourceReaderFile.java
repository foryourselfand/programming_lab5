package SourseReaders;

import Errors.IOErrors.FileNotExistError;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SourceReaderFile extends SourceReader {
	private String path;
	
	public SourceReaderFile(String path) {
		this.path = path;
		try {
			this.scanner = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			throw new FileNotExistError();
		}
	}
	
	@Override
	public boolean hasSomethingToRead() {
		return this.scanner.hasNextLine();
	}
	
	@Override
	public String getPostfix(String lineRead) {
		return lineRead + "\n";
	}
	
	@Override
	public String getSource() {
		return path;
	}
}
