package Commands;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
	private List<Argument> arguments;
	
	public Command() {
		arguments = new ArrayList<>();
	}
	
	public abstract void execute();
	
	public abstract String getNameOfCommand();
	
	protected void addArguments() {
	}
}
