package Errors.WrongHeaderErrors;

import Errors.InputErrors.InputErrorFull;

/**
 * Ошибка неправильного заголовка
 */
public class WrongHeaderError extends InputErrorFull {
	/**
	 * Сообщение о недостающих элементах
	 */
	public static String MESSAGE_MISSING = "Недостающие элементы: ";
	
	/**
	 * Сообщение о лишних элементах
	 */
	public static String MESSAGE_EXTRA = "Лишние элементы: ";
	
	public WrongHeaderError(String message) {
		super("Неверный заголовок csv файла: \n" + message + "\n");
	}
}
