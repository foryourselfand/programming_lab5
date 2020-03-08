package Commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandsHolder {
	private Map<String, Command> commands;
	
	public CommandsHolder() {
		commands = new HashMap<>();
		
		ArrayList<Command> valueList = new ArrayList(commands.values());
	}
	
	public CommandsHolder addCommand(Command command) {
		commands.put(command.getNameOfCommand(), command);
		return this;
	}
	
	public Command getCommandByName(String name) {
		return this.commands.get(name);
	}
	
	public List<Command> getCommands() {
		return new ArrayList<>(commands.values());
	}
}
