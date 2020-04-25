package Commands;

import Input.Flat;
import Utils.Context;
import Utils.FlatCreator;

public class CommandAdd extends CommandSaveAfterExecute {
	public CommandAdd(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		Flat flat = FlatCreator.getCreatedFlatFromTerminal(this.context.lineReader);
		this.context.collectionManager.addFlatToCollection(flat);
	}
	
	@Override
	public String getName() {
		return "add";
	}
	
	@Override
	public String getDescription() {
		return "добавить новый элемент в коллекцию";
	}
}
