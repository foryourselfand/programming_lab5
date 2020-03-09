import Commands.CommandHelp;
import Commands.CommandHistory;
import Commands.CommandShow;
import Commands.CommandsHolder;
import SourseReader.SourceReaderFactory;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		CommandsHolder commandsHolder = new CommandsHolder();
		CommandsExecutor commandsExecutor = new CommandsExecutor(commandsHolder);
		
		
		commandsHolder
				.addCommand(new CommandHelp(commandsHolder))
				.addCommand(new CommandShow())
				.addCommand(new CommandHistory())
		;
		
		LineReader lineReader = new LineReader();
		lineReader.setSourceReader(SourceReaderFactory.getSourceReaderFile("/Users/foryourselfand/Documents/Java/itmo/programming_lab5/src/script"));
		
		while (lineReader.hasSomethingToRead()) {
			String lineRead = lineReader.readLine(">>> ");
			System.out.println(lineRead);
		}
	}
}
                        
