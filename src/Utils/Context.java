package Utils;

import Commands.*;
import Commands.CommandsWithNotEmptyCollection.*;

import java.time.LocalDate;

public class Context {
	public static final LocalDate INITIALIZATION_DATE = LocalDate.now();
	
	public CommandsHolder commandsHolder;
	public CommandsExecutor commandsExecutor;
	public LineReader lineReader;
	public CollectionManager collectionManager;
	
	public Context() {
		this.collectionManager = new CollectionManager();
		this.lineReader = new LineReader();
		this.commandsHolder = new CommandsHolder();
		this.commandsExecutor = new CommandsExecutor(commandsHolder);
		
		setUpCommands();
	}
	
	public void setUpCommands() {
		this.commandsHolder
				.addCommand(new CommandHelp(this))
				.addCommand(new CommandInfo(this))
				.addCommand(new CommandShow(this))
				.addCommand(new CommandAdd(this))
				.addCommand(new CommandUpdate(this))
				.addCommand(new CommandRemoveById(this))
				.addCommand(new CommandClear(this))
				.addCommand(new CommandLoad(this))
				.addCommand(new CommandSave(this))
				.addCommand(new CommandExecuteScript(this))
				.addCommand(new CommandExit(this))
				.addCommand(new CommandAddIfMax(this))
				.addCommand(new CommandRemoveGreater(this))
				.addCommand(new CommandHistory(this))
				.addCommand(new CommandAverageOfHeight(this))
				.addCommand(new CommandGroupCountingByArea(this))
				.addCommand(new CommandPrintUniqueHouse(this))
		;
	}
}
