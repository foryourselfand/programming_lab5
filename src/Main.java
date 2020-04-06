import Commands.*;
import Expectables.Argument;
import SourseReader.SourceReaderFactory;
import Utils.CommandsExecutor;
import Utils.CommandsHolder;
import Utils.Context;
import Utils.LineReader;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		CommandsHolder commandsHolder = new CommandsHolder();
		
		CommandsExecutor commandsExecutor = new CommandsExecutor(commandsHolder);
		
		Context context = new Context(commandsHolder);
		
		commandsHolder
				.addCommand(new CommandHelp(context))
				.addCommand(new CommandShow(context))
				.addCommand(new CommandRemoveById(context))
				.addCommand(new CommandExecuteScript(context))
				.addCommand(new CommandHistory(context))
		;
		
		LineReader lineReader = new LineReader(SourceReaderFactory.getSourceReaderTerminal());
		
		while (lineReader.hasSomethingToRead()) {
			String lineRead = lineReader.readLine(">>> ", new Argument("commandName"));
			commandsExecutor.executeCommandByName(lineRead);
		}
	}
}
                        
