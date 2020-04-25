package Errors;

import Errors.InputErrors.InputErrorFull;

/**
 * Ошибка не сущестсования команды
 */
public class NoSuchCommandError extends InputErrorFull {
	public NoSuchCommandError(String message) {
		super("Комманда с именем " + message + " не существует. Посмотреть справку по доступным командам >>> help");
	}
}
