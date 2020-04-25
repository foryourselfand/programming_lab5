package Errors.InputErrors;

/**
 * Ошибка ввода с префиксом об ошибке ввода
 */
public class InputErrorFull extends InputError {
	public InputErrorFull(String message) {
		super("Ошибка ввода: " + message);
	}
}
