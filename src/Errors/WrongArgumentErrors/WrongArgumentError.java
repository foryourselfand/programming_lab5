package Errors.WrongArgumentErrors;

import Errors.InputErrors.InputErrorFull;

/**
 * Ошибка аргумента
 */
public class WrongArgumentError extends InputErrorFull {
	public WrongArgumentError(String argumentName, String errorMessage) {
		super("Неверный аргумент с именем " + argumentName + ". " + errorMessage + ".");
	}
}
