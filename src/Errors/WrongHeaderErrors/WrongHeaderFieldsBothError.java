package Errors.WrongHeaderErrors;

import java.util.Set;

/**
 * Ошибка неправильного заголова
 * Сообщение об недостающие элементы вместе с лишние элементы
 */
public class WrongHeaderFieldsBothError extends WrongHeaderError {
	public WrongHeaderFieldsBothError(Set<String> missingFields, Set<String> extraFields) {
		super(WrongHeaderError.MESSAGE_MISSING + missingFields + "\n"
				+ WrongHeaderError.MESSAGE_EXTRA + extraFields);
	}
}
