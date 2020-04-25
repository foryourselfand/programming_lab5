package Commands;

import Utils.Context;

/**
 * Комманда, после выполнения сохраняет коллекцию во временный csv файл
 */
public abstract class CommandSaveAfterExecute extends Command {
	public CommandSaveAfterExecute(Context context) {
		super(context);
	}
	
	/**
	 * После выполнения сохраняет коллекцию во временный csv файл
	 * @param commandArguments аргументы комманды
	 */
	@Override
	public void executeWithArgumentsValidation(String[] commandArguments) {
		super.executeWithArgumentsValidation(commandArguments);
		this.context.csvSaver.saveCollectionToTempCSVFile(this.context.collectionManager.getCollection());
	}
}
