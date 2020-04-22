package Commands;

import Utils.Context;

public abstract class CommandSaveAfterExecute extends Command {
	public CommandSaveAfterExecute(Context context) {
		super(context);
	}
	
	@Override
	public void executeWithValidation(String[] commandArguments) {
		super.executeWithValidation(commandArguments);
		this.context.csvSaver.saveCollectionCSV(this.context.collectionManager.getCollection());
	}
}
