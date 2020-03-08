import Commands.Command;
import Commands.CommandsHolder;

public class CommandsExecutor {
	private CommandsHolder commandsHolder;
	
	public CommandsExecutor(CommandsHolder commandsHolder) {
		this.commandsHolder = commandsHolder;
	}
	
	public void executeCommandByName(String name) {
		Command commandToExecute = commandsHolder.getCommandByName(name);
		commandToExecute.execute();
	}
}
