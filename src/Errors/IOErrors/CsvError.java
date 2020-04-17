package Errors.IOErrors;

import Errors.InputErrors.InputErrorFull;

public class CsvError extends InputErrorFull {
	public CsvError() {
		super("csv файл должен быть корректен");
	}
}
