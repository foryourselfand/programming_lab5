package Errors.ArgumentErrors;

import Errors.InputError;

public class WrongArgumentError extends InputError {
	public WrongArgumentError(String argumentName, String errorMessage) {
		super("Неверный аргумент с именем " + argumentName + ". " + getErrorMessageWithoutRepeating(errorMessage));
	}
}
