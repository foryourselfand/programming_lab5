package Errors;

public class InputErrorFull extends Error {
	public InputErrorFull(String message) {
		super("Ошибка ввода: " + message);
	}
}
