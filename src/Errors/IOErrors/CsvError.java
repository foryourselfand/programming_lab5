package Errors.IOErrors;

import Errors.InputErrors.InputErrorFull;

/**
 * Ошибка CSV файла
 */
public class CsvError extends InputErrorFull {
	public CsvError() {
		super("csv файл должен быть корректен");
	}
}
