package Errors;

import Errors.InputErrors.InputErrorFull;

/**
 * Ошибка попытки рекурсивного исполнения файла
 */
public class ScriptAlreadyExecutedError extends InputErrorFull {
	public ScriptAlreadyExecutedError() {
		super("Нельзя повторно исполнять сценарий из файла что бы не возникла рекурсия");
	}
}
