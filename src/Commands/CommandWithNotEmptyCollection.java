package Commands;

import Errors.CollectionIsEmptyError;
import Utils.Context;

/**
 * Команда, для выполнения которых необходима не пустая коллекция
 */
public abstract class CommandWithNotEmptyCollection extends Command {
	public CommandWithNotEmptyCollection(Context context) {
		super(context);
	}
	
	/**
	 * Проверяет количество элементов коллекции
	 * Выполняется только если коллекция не пустая
	 * @param commandArguments аргументы комманды
	 */
	@Override
	public void executeWithArgumentsValidation(String[] commandArguments) {
		this.validateCollectionSize();
		this.validateArguments(commandArguments);
		
		this.printDescriptionAndExecute(commandArguments);
	}
	
	/**
	 * Проверяет количество эллементов коллекции
	 * Если пусто - пробрасывает исключение
	 */
	public void validateCollectionSize() {
		boolean collectionIsEmpty = this.context.collectionManager.getIsCollectionEmpty();
		if (collectionIsEmpty) {
			throw new CollectionIsEmptyError();
		}
	}
}
