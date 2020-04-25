package Errors;

import Errors.InputErrors.InputErrorFull;

/**
 * Ошибка неправильного количества элементов в строке
 */
public class WrongLineElementsLengthError extends InputErrorFull {
	/**
	 * @param line           разбитая строка
	 * @param expectedLength ожидаемая длинна
	 * @param actualLength   реальная длинна
	 */
	public WrongLineElementsLengthError(String[] line, int expectedLength, int actualLength) {
		super("Неверная длинна элементов в строке: " + String.join(",", line) + ". Ожидалось: " + expectedLength + ". Получено: " + actualLength);
	}
}
