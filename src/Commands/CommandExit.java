package Commands;

import Utils.Context;

public class CommandExit extends Command {
	public CommandExit(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
	
	}
	
	@Override
	public String getName() {
		return "exit";
	}
	
	@Override
	public String getDescription() {
		return "завершить программу (без сохранения в файл)";
	}
}
