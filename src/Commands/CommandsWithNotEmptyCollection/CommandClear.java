package Commands.CommandsWithNotEmptyCollection;

import Utils.Context;

public class CommandClear extends CommandWithNotEmptyCollection {
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