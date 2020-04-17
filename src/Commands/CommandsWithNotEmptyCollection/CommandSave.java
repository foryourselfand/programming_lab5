package Commands.CommandsWithNotEmptyCollection;

import Utils.Context;

public class CommandSave extends CommandWithNotEmptyCollection {
	public CommandSave(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
	
	}
	
	@Override
	public String getName() {
		return "save";
	}
	
	@Override
	public String getDescription() {
		return "сохранить коллекцию в файл";
	}
}
