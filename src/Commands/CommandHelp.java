package Commands;

import Utils.Context;

import java.util.Iterator;

public class CommandHelp extends Command {
	
	public CommandHelp(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		Iterator<Command> commands = this.context.commandsHolder.getCommands();
		
		while (commands.hasNext()) {
			Command command = commands.next();
			System.out.println(command.getFullInformation());
		}
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
