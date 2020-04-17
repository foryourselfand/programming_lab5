package Commands;

import Utils.Context;

public class CommandClear extends Command {
	public CommandClear(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
	
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
