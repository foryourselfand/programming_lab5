package Commands;

import Utils.Context;

import java.util.List;

public class CommandHelp extends Command {
	
	public CommandHelp(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		List<Command> commands = this.context.commandsHolder.getCommands();
		
		for (Command command : commands)
			System.out.println(command.getFullInformation());
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
