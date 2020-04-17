package Errors.InputErrors;

public class InputErrorFull extends InputErrorShort {
	public InputErrorFull(String message) {
		super("Ошибка ввода: " + message);
	}
}
