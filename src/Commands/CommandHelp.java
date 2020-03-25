package Commands;

import Utils.Context;

import java.util.List;

public class CommandHelp extends Command {
	
	public CommandHelp(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		super.execute(commandArguments);
		List<Command> commands = this.context.commandsHolder.getCommands();
		
		for (Command command : commands) {
			System.out.println(command.getNameOfCommand());
		}
	}
	
	@Override
	public String getNameOfCommand() {
		return "help";
	}
}
