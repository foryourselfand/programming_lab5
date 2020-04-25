package Errors.WrongHeaderErrors;

import java.util.Set;

/**
 * Ошибка неправильного заголова
 * Сообщение об одном из: либо недостающие элементы, либо лишние
 */
public class WrongHeaderFieldsSingleError extends WrongHeaderError {
	public WrongHeaderFieldsSingleError(String message, Set<String> fields) {
		super(message + ": " + fields);
	}
}
