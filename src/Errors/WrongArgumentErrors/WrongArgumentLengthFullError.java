package Errors.WrongArgumentErrors;

/**
 * Ошибка длинны аргументов с постфиксом обязательных аргументов
 */
public class WrongArgumentLengthFullError extends WrongArgumentLengthError{
	public WrongArgumentLengthFullError(int argumentsLengthExpected, int argumentsLengthActual, String postfix) {
		super(argumentsLengthExpected, argumentsLengthActual, ". Обязательные аргументы:" + postfix);
	}
}
