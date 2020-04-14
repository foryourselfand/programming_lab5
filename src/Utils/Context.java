package Utils;

public class Context {
	public CommandsHolder commandsHolder;
	public CommandsExecutor commandsExecutor;
	public LineReader lineReader;
	public CollectionManager collectionManager;
	
	public void setCommandsHolder(CommandsHolder commandsHolder) {
		this.commandsHolder = commandsHolder;
	}
	
	public void setCommandsExecutor(CommandsExecutor commandsExecutor) {
		this.commandsExecutor = commandsExecutor;
	}
	
	public void setLineReader(LineReader lineReader) {
		this.lineReader = lineReader;
	}
	
	public void setCollectionManager(CollectionManager collectionManager) {
		this.collectionManager = collectionManager;
	}
}
