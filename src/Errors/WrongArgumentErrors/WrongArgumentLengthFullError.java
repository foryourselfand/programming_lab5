package Errors.WrongArgumentErrors;

public class WrongArgumentLengthFullError extends WrongArgumentLengthError{
	public WrongArgumentLengthFullError(int argumentsLengthExpected, int argumentsLengthActual, String postfix) {
		super(argumentsLengthExpected, argumentsLengthActual, ". Обязательные аргументы:" + postfix);
	}
}
