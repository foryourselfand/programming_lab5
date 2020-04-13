package Errors.ArgumentErrors;

import Errors.InputErrorFull;

public class WrongArgumentError extends InputErrorFull {
	public WrongArgumentError(String argumentName, String errorMessage) {
		super("Неверный аргумент с именем " + argumentName + ". " + errorMessage + ".");
	}
}
