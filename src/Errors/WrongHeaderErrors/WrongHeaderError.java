package Errors.WrongHeaderErrors;

import Errors.InputErrors.InputErrorFull;

public class WrongHeaderError extends InputErrorFull {
	public static String MESSAGE_MISSING = "Недостающие элементы: ";
	public static String MESSAGE_EXTRA = "Лишние элементы: ";
	
	public WrongHeaderError(String message) {
		super("Неверный заголовок csv файла: \n" + message + "\nШаблон: ");
	}
}
