package Errors;

public class WrongLocalDateError extends InputError {
	public WrongLocalDateError() {
		super("Неправильный формат даты ISO. Пример 2020-12-31.");
	}
}
