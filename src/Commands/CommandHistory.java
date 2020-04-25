package Commands;

import Utils.Context;

import java.util.Iterator;

/**
 * Команда вывода последних 12 команд (без их аргументов)
 */
public class CommandHistory extends Command {
	public CommandHistory(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		Iterator<Command> commandHistory = this.context.commandsHolder.getCommandsHistory();
		System.out.format("Последние %d комманд (без их аргументов):\n", Context.HISTORY_SIZE);
		commandHistory.forEachRemaining(command->System.out.println(command.getName()));
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
