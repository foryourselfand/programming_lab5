package Errors;

import Errors.InputErrors.InputError;

/**
 * Ошибка пустой коллекции
 */
public class CollectionIsEmptyError extends InputError {
	public CollectionIsEmptyError() {
		super("Коллекция пустая");
	}
}
