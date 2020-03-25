package Commands;

import Utils.Context;

public class CommandShow extends Command {
	public CommandShow(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		super.execute(commandArguments);
	}
	
	@Override
	public String getNameOfCommand() {
		return "show";
	}
}
