package Errors.WrongArgumentErrors;

import Errors.InputErrors.InputErrorFull;

public class WrongArgumentError extends InputErrorFull {
	public WrongArgumentError(String argumentName, String errorMessage) {
		super("Неверный аргумент с именем " + argumentName + ". " + errorMessage + ".");
	}
}
