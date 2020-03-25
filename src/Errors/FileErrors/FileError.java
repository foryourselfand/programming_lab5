package Errors.FileErrors;

import Errors.InputError;

public class FileError extends InputError {
	public FileError(String message) {
		super("Проблема с файлом. " + message);
	}
}
