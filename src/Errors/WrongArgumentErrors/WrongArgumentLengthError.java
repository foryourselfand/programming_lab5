package Errors.WrongArgumentErrors;

import Errors.InputErrors.InputErrorFull;

public class WrongArgumentLengthError extends InputErrorFull {
	public WrongArgumentLengthError(String commandNameWithArguments, int argumentsLengthExpected, int argumentsLengthActual) {
		super(commandNameWithArguments + "\nНеверная длина аргументов. Ожидалось: " + argumentsLengthExpected + "; Получено: " + argumentsLengthActual);
	}
}
