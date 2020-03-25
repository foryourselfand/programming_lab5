import Commands.*;
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
		
		LineReader lineReader = new LineReader();
//		lineReader.setSourceReader(SourceReaderFactory.getSourceReaderFile("/Users/foryourselfand/Documents/java/itmo/programming_lab5_test/res/script"));
		
		while (lineReader.hasSomethingToRead()) {
			String lineRead = lineReader.readLine(">>> ");
			commandsExecutor.executeCommandByName(lineRead);
//			System.out.println(lineRead);
			
		}
	}
}
                        
