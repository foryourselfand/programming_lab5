package Exceptions;

public class InputError extends Error {
	public InputError(String message) {
		super("Ошибка ввода: " + message);
	}
}
