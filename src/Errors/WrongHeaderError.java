package Errors;

public class WrongHeaderError extends InputError {
	public static String MESSAGE_MISSING = "Недостающие элементы: ";
	public static String MESSAGE_EXTRA = "Лишние элементы: ";
	
	public WrongHeaderError(String message) {
		super("Неверный заголовок csv файла: \n" + message + "\nШаблон: ");
	}
}
