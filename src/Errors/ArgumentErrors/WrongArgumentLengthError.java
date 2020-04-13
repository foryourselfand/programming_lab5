package Errors.ArgumentErrors;

import Errors.InputErrorFull;

public class WrongArgumentLengthError extends InputErrorFull {
	public WrongArgumentLengthError(int argumentsLengthExpected, int argumentsLengthActual) {
		super("Неверная длина аргументов. Ожидалось: " + argumentsLengthExpected + "; Получено: " + argumentsLengthActual);
	}
}
