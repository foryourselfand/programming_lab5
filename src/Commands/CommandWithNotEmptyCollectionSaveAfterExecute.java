package Commands;

import Utils.Context;

public abstract class CommandWithNotEmptyCollectionSaveAfterExecute extends CommandWithNotEmptyCollection {
	public CommandWithNotEmptyCollectionSaveAfterExecute(Context context) {
		super(context);
	}
	
	@Override
	public void executeWithValidation(String[] commandArguments) {
		super.executeWithValidation(commandArguments);
		this.context.csvSaver.saveCollectionCSV(this.context.collectionManager.getCollection());
	}
}
