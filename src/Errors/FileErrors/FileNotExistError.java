package Errors.FileErrors;

public class FileNotExistError extends FileError {
	public FileNotExistError(String path) {
		super("Файл с путем " + path + " не существует.");
	}
}
