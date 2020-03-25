package Errors;

public class NoSuchCommandError extends InputError {
	public NoSuchCommandError(String message) {
		super("Комманда с именем " + message + " не существует.");
	}
}
