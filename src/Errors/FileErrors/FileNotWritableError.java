package Errors.FileErrors;

public class FileNotWritableError extends FileError {
	public FileNotWritableError(String path) {
		super("В файл с путем " + path + " нельзя записывать.");
	}
}
