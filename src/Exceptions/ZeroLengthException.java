package Exceptions;

public class ZeroLengthException extends RuntimeException {
	public ZeroLengthException() {
		super("Строка не может быть пустой");
	}
}
