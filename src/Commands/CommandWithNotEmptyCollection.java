package Commands;

import Errors.CollectionIsEmptyError;
import Utils.Context;

public abstract class CommandWithNotEmptyCollection extends Command {
	public CommandWithNotEmptyCollection(Context context) {
		super(context);
	}
	
	@Override
	public void executeWithValidation(String[] commandArguments) {
		this.validateArguments(commandArguments);
		this.validateCollectionSize();
		
		this.printDescriptionAndExecute(commandArguments);
	}
	
	public void validateCollectionSize() {
		boolean collectionIsEmpty = this.context.collectionManager.getCollectionIsEmpty();
		if (collectionIsEmpty) {
			throw new CollectionIsEmptyError();
		}
	}
}
