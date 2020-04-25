package Expectations;

import Errors.InputErrors.InputError;

/**
 * Ожидание от значения
 */
public interface Expectation {
	/**
	 * Проверяет значение на правильность (соответствие всем ожиданиям)
	 * Если значение не правильно (не соответствуем всем ожиданием) пробрасывается созданная ошибка ввода
	 * @param valueRaw
	 */
	void checkValueCorrectness(String valueRaw);
	
	/**
	 * Возвращает сообщение об ошибке
	 * @return сообщение об ошибке
	 */
	String getErrorMessage();
	
	/**
	 * Возвращает созданное сообщение об ошибке
	 *
	 * @return созданное сообщение об ошибке
	 */
	default InputError createInputError() {
		return new InputError(getErrorMessage());
	}
}
