package Errors.ArgumentErrors;

import Errors.InputError;

public class WrongArgumentLengthError extends InputError {
	public WrongArgumentLengthError(int argumentsLengthExpected, int argumentsLengthActual) {
		super("Неверная длина аргументов. ожидалось: " + argumentsLengthExpected + "; получено: " + argumentsLengthActual);
	}
}
