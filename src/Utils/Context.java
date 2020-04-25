package Utils;

import Commands.*;
import Generators.CreationDateGenerator;

import java.time.LocalDate;

/**
 * Передается в каждую команду, для легкого доступа ресурсам, требуемым для исполнения команды
 */
public class Context {
	/**
	 * Дата инициализации
	 */
	public static final LocalDate INITIALIZATION_DATE = CreationDateGenerator.generateCreationDate();
	
	/**
	 * Размер стека истории команд
	 */
	public static final int HISTORY_SIZE = 12;
	
	public CommandsHolder commandsHolder;
	public CommandsExecutor commandsExecutor;
	public LineReader lineReader;
	public CollectionManager collectionManager;
	public FlatRemover flatRemover;
	public CSVSaver csvSaver;
	
	public Context() {
		this.collectionManager = new CollectionManager();
		this.lineReader = new LineReader();
		this.commandsHolder = new CommandsHolder();
		this.commandsExecutor = new CommandsExecutor(commandsHolder);
		this.flatRemover = new FlatRemover(collectionManager);
		this.csvSaver = new CSVSaver();
		
		setUpCommands();
	}
	
	/**
	 * Устанавливает команды
	 */
	public void setUpCommands() {
		this.commandsHolder
				.addCommand(new CommandHelp(this))
				.addCommand(new CommandInfo(this))
				.addCommand(new CommandShow(this))
				.addCommand(new CommandAdd(this))
				.addCommand(new CommandUpdateById(this))
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
	
	/**
	 * Загружает коллекцию из аргумента командной коммандной строки
	 * Или пытается загрузить временный файл
	 *
	 * @param args Аргументы командной строки
	 */
	public void loadCollectionFromArgsOrRestoreFromTempFile(String[] args) {
		if (args.length == 1)
			this.commandsExecutor.tryToExecuteCommand("load " + args[0]);
		else
			this.tryToLoadTempFile();
	}
	
	/**
	 * Пытается загрузить временный файл
	 */
	public void tryToLoadTempFile() {
		if (TempFileManager.isTempFileExist()) {
			System.out.println("Найден временный файл");
			
			String choice;
			do {
				choice = this.lineReader.readLine("Восстановить коллекцию из временного файла? y / n: ").trim().toLowerCase();
			} while (! choice.equals("y") && ! choice.equals("n"));
			
			if (choice.equals("y"))
				this.commandsExecutor.tryToExecuteCommand("load " + TempFileManager.getTempFilePath());
		}
	}
	
	/**
	 * Считывает команду (имя с аргументами) из доступного источника ввода
	 * Пытается исполнить команду
	 */
	public void readCommandAndTryToExecute() {
		while (this.lineReader.hasSomethingToRead()) {
			String lineRead = this.lineReader.readLine(">>> ");
			this.commandsExecutor.tryToExecuteCommand(lineRead);
		}
	}
}
