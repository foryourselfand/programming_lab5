package Errors.FileErrors;

public class FileNotReadableError extends FileError{
	public FileNotReadableError(String path) {
		super("Файл с путем " + path + " нельзя прочитать.");
	}
}
