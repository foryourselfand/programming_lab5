package Utils;

import Commands.Command;
import Errors.InputErrorFull;

import java.util.Arrays;

public class CommandsExecutor {
	private CommandsHolder commandsHolder;
	
	public CommandsExecutor(CommandsHolder commandsHolder) {
		this.commandsHolder = commandsHolder;
	}
	
	public void executeCommandByName(String line) {
		if (line.equals(""))
			return;
		
		String[] lineSplit = this.getLineSplit(line);
		
		String commandName = this.getCommandName(lineSplit);
		String[] commandArguments = this.getCommandArguments(lineSplit);
		
		try {
			Command commandToExecute = commandsHolder.getCommandByName(commandName);
			commandToExecute.execute(commandArguments);
		} catch (InputErrorFull error) {
			System.out.println(error.getMessage());
		}
	}
	
	private String[] getLineSplit(String lineRaw) {
		String lineTrim = lineRaw.trim();
		String[] lineSplit = lineTrim.split("\\s+");
		return lineSplit;
	}
	
	private String getCommandName(String[] lineSplit) {
		return lineSplit[0].toLowerCase();
	}
	
	private String[] getCommandArguments(String[] lineSplit) {
		return Arrays.copyOfRange(lineSplit, 1, lineSplit.length);
	}
}
