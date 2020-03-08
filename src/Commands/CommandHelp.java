package Commands;

import java.util.List;

public class CommandHelp extends Command {
	private CommandsHolder commandHolder;
	
	public CommandHelp(CommandsHolder commandsHolder) {
		this.commandHolder = commandsHolder;
	}
	
	@Override
	public void execute() {
		List<Command> commands = this.commandHolder.getCommands();
		
		for (Command command : commands) {
			System.out.println(command.getNameOfCommand());
		}
	}
	
	@Override
	public String getNameOfCommand() {
		return "help";
	}
}
