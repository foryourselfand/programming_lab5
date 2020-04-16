package Commands;

import Utils.Context;

public class CommandHistory extends Command {
	public CommandHistory(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
	}
	
	@Override
	public String getNameOfCommand() {
		return "history";
	}
}
