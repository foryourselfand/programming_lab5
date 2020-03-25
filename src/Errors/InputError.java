package Errors;

public class InputError extends Error {
	public static String ErrorMessage = "Ошибка ввода: ";
	
	public InputError(String message) {
		super(InputError.ErrorMessage + message);
	}
	
	public static String getErrorMessageWithoutRepeating(String errorMessage) {
		return errorMessage.replace(InputError.ErrorMessage, "");
	}
}
