package Commands;

import Utils.Context;

public class CommandUpdate extends Command {
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
