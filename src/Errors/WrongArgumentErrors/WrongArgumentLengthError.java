package Errors.WrongArgumentErrors;

import Errors.InputErrors.InputErrorFull;

public class WrongArgumentLengthError extends InputErrorFull {
	public WrongArgumentLengthError(int argumentsLengthExpected, int argumentsLengthActual, String postfix) {
		super("Неверная длина аргументов. Ожидалось: " + argumentsLengthExpected + "; Получено: " + argumentsLengthActual + postfix);
	}
	
	public WrongArgumentLengthError(int argumentsLengthExpected, int argumentsLengthActual) {
		this(argumentsLengthExpected, argumentsLengthActual, "");
	}
}
