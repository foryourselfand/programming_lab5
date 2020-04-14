package Errors;

public class ScriptAlreadyExecutedError extends InputErrorFull {
	public ScriptAlreadyExecutedError() {
		super("Нельзя повторно исполнять сценарий из файла что бы не возникла рекурсия");
	}
}
