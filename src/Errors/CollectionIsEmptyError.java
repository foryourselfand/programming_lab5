package Errors;

import Errors.InputErrors.InputError;

public class CollectionIsEmptyError extends InputError {
	public CollectionIsEmptyError() {
		super("Коллекция пустая");
	}
}
