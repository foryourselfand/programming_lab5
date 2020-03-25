package Errors.FileErrors;

public class FileNotRegularFileError extends FileError {
	public FileNotRegularFileError(String path) {
		super(path + " не является обычным файлом.");
	}
}
