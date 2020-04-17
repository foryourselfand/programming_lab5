package Utils;

import Commands.Command;
import Errors.NoSuchCommandError;

import java.util.*;

public class CommandsHolder {
	private Map<String, Command> commands;
	private Deque<Command> commandsHistory;
	
	public CommandsHolder() {
		commands = new LinkedHashMap<>();
		commandsHistory = new ArrayDeque<>();
	}
	
	public CommandsHolder addCommand(Command command) {
		commands.put(command.getName(), command);
		return this;
	}
	
	public Command getCommandByName(String name) {
		if (! this.commands.containsKey(name))
			throw new NoSuchCommandError(name);
		
		Command command = this.commands.get(name);
		
		if (commandsHistory.size() == Context.HISTORY_SIZE)
			commandsHistory.pollFirst();
		commandsHistory.addLast(command);
		
		return command;
	}
	
	public List<Command> getCommands() {
		return new ArrayList<>(commands.values());
	}
	
	public Iterator<Command> getCommandsHistory() {
		return commandsHistory.iterator();
	}
}
