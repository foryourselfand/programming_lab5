import Commands.*;
import Expectables.Argument;
import Utils.CommandsExecutor;
import Utils.CommandsHolder;
import Utils.Context;
import Utils.LineReader;

public class Main {
	public static void main(String[] args) {
		CommandsHolder commandsHolder = new CommandsHolder();
		
		CommandsExecutor commandsExecutor = new CommandsExecutor(commandsHolder);
		
		LineReader lineReader = new LineReader();
		
		Context context = new Context();
		context.setCommandsHolder(commandsHolder);
		context.setCommandsExecutor(commandsExecutor);
		context.setLineReader(lineReader);
		
		commandsHolder
				.addCommand(new CommandHelp(context))
				.addCommand(new CommandShow(context))
				.addCommand(new CommandRemoveById(context))
				.addCommand(new CommandExecuteScript(context))
				.addCommand(new CommandHistory(context))
		;
		
		
		while (context.lineReader.hasSomethingToRead()) {
			String lineRead = context.lineReader.readLine(">>> ", new Argument("commandName"));
			commandsExecutor.executeCommandByName(lineRead);
		}
	}
}

// execute_script /Users/foryourselfand/Documents/java/itmo/programming_lab5/res/script_1
