package Errors;

public class WrongLineElementsLengthError extends InputErrorFull {
	public WrongLineElementsLengthError(String[] line, int expectedLength, int actualLength) {
		super("Неверная длинна элементов в строке: " + String.join(",", line) + ". Ожидалось: " + expectedLength + ". Получено: " + actualLength);
	}
}
