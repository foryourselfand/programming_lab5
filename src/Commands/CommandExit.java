package Commands;

import Utils.Context;

public class CommandExit extends Command {
	public CommandExit(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		System.exit(42);
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
