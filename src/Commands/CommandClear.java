package Commands;

import Utils.Context;

/**
 * Команда очищения коллекции
 */
public class CommandClear extends CommandWithNotEmptyCollectionSaveAfterExecute {
	public CommandClear(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		this.context.collectionManager.getCollection().clear();
		System.out.println("Коллекция очищена");
	}
	
	@Override
	public String getName() {
		return "clear";
	}
	
	@Override
	public String getDescription() {
		return "очистить коллекцию";
	}
}
