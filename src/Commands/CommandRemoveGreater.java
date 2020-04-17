package Commands;

import Utils.Context;

public class CommandRemoveGreater extends Command {
	public CommandRemoveGreater(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
	
	}
	
	@Override
	public String getName() {
		return "remove_greater";
	}
	
	@Override
	public String getDescription() {
		return "удалить из коллекции все элементы, превышающие заданный";
	}
}
