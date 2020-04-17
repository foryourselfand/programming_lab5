package Errors;

import Errors.InputErrors.InputErrorFull;

public class NoSuchCommandError extends InputErrorFull {
	public NoSuchCommandError(String message) {
		super("Комманда с именем " + message + " не существует");
	}
}
