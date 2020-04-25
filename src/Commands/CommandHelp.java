package Commands;

import Utils.Context;

import java.util.Iterator;

/**
 * Команда вывода справки по доступным коммандам
 */
public class CommandHelp extends Command {
	public CommandHelp(Context context) {
		super(context);
	}
	
	
	@Override
	public void execute(String[] commandArguments) {
		Iterator<Command> commands = this.context.commandsHolder.getCommands();
		commands.forEachRemaining(command->System.out.println(command.getFullInformation()));
	}
	
	@Override
	public String getName() {
		return "help";
	}
	
	@Override
	public String getDescription() {
		return "вывести справку по доступным командам";
	}
}
