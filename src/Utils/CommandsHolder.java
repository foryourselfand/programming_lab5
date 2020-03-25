package Utils;

import Commands.Command;
import Errors.NoSuchCommandError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandsHolder {
	private Map<String, Command> commands;
	
	public CommandsHolder() {
		commands = new HashMap<>();
	}
	
	public CommandsHolder addCommand(Command command) {
		commands.put(command.getNameOfCommand(), command);
		return this;
	}
	
	public Command getCommandByName(String name) {
		if (! this.commands.containsKey(name))
			throw new NoSuchCommandError(name);
		return this.commands.get(name);
	}
	
	public List<Command> getCommands() {
		return new ArrayList<>(commands.values());
	}
}
