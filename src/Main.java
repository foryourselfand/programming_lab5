import Commands.*;
import Expectables.Argument;
import Utils.*;

public class Main {
	public static void main(String[] args) {
		CollectionManager collectionManager = new CollectionManager();
		LineReader lineReader = new LineReader();
		CommandsHolder commandsHolder = new CommandsHolder();
		CommandsExecutor commandsExecutor = new CommandsExecutor(commandsHolder);
		
		Context context = new Context();
		context.setLineReader(lineReader);
		context.setCommandsHolder(commandsHolder);
		context.setCommandsExecutor(commandsExecutor);
		context.setCollectionManager(collectionManager);
		
		commandsHolder
				.addCommand(new CommandLoad(context))
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
