package Commands;

import Utils.Context;

/**
 * Команда, для выполнения которых необходима не пустая коллекция
 * Комманда, после выполнения сохраняет коллекцию во временный csv файл
 */
public abstract class CommandWithNotEmptyCollectionSaveAfterExecute extends CommandWithNotEmptyCollection {
	public CommandWithNotEmptyCollectionSaveAfterExecute(Context context) {
		super(context);
	}
	
	/**
	 * Проверяет количество элементов коллекции
	 * Выполняется только если коллекция не пустая
	 * После выполнения сохраняет коллекцию во временный csv файл
	 *
	 * @param commandArguments аргументы комманды
	 */
	@Override
	public void executeWithArgumentsValidation(String[] commandArguments) {
		super.executeWithArgumentsValidation(commandArguments);
		this.context.csvSaver.saveCollectionToTempCSVFile(this.context.collectionManager.getCollection());
	}
}
