package Commands.CommandsWithNotEmptyCollection;

import Utils.Context;

public class CommandUpdate extends CommandWithNotEmptyCollection {
	public CommandUpdate(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
	
	}
	
	@Override
	public String getName() {
		return "update";
	}
	
	@Override
	public String getDescription() {
		return "обновить значение элемента коллекции, id которого равен заданному";
	}
}
