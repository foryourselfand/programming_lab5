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
	public String getName() {
		return "history";
	}
	
	@Override
	public String getDescription() {
		return "вывести последние 12 команд (без их аргументов)";
	}
}
