package Errors;

public class WrongLineElementsLengthError extends InputError {
	public WrongLineElementsLengthError(String[] line, int expectedLength, int actualLength) {
		super("Неверная длинна элементов в строке: " + String.join(",", line) + ". Ожидалось: " + expectedLength + ". Получено: " + actualLength);
	}
}
