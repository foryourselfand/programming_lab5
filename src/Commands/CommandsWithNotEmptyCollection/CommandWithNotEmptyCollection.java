package Commands.CommandsWithNotEmptyCollection;

import Commands.Command;
import Errors.CollectionIsEmptyError;
import Utils.Context;

public abstract class CommandWithNotEmptyCollection extends Command {
	public CommandWithNotEmptyCollection(Context context) {
		super(context);
	}
	
	@Override
	public void executeWithValidation(String[] commandArguments) {
		this.validateCollectionSize();
		this.validateArguments(commandArguments);
		
		this.printDescriptionAndExecute(commandArguments);
	}
	
	public void validateCollectionSize() {
		boolean collectionIsEmpty = this.context.collectionManager.getCollectionIsEmpty();
		if (collectionIsEmpty) {
			throw new CollectionIsEmptyError();
		}
	}
}
