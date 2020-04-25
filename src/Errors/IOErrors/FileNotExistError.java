package Errors.IOErrors;

import Errors.InputErrors.InputError;
import Errors.InputErrors.InputErrorFull;

/**
 * Ошибка несуществования файла
 */
public class FileNotExistError extends InputErrorFull {
	public FileNotExistError() {
		super("Файл должен существовать");
	}
}
