package Commands;

import Expectations.Argument;
import Expectations.ExpectedFile.ExpectedFileExist;
import Expectations.ExpectedFile.ExpectedFileExtensionCsv;
import Expectations.ExpectedFile.ExpectedFileReadable;
import Expectations.ExpectedFile.ExpectedFileRegular;
import Generators.IdGenerator;
import Utils.CSVLoader;
import Utils.Context;

import java.util.List;

/**
 * Команда загрузки коллекции из файла
 */
public class CommandLoad extends CommandSaveAfterExecute {
	private final CSVLoader csvLoader;
	
	public CommandLoad(Context context) {
		super(context);
		csvLoader = new CSVLoader();
	}
	
	@Override
	protected void addArgumentValidators(List<Argument> arguments) {
		arguments.add(new Argument(
				"file_name",
				new ExpectedFileExtensionCsv(),
				new ExpectedFileExist(),
				new ExpectedFileRegular(),
				new ExpectedFileReadable()
		));
	}
	
	/**
	 * Очищает коллекцию
	 * Очищает id
	 * Создает коллекцию из файла
	 * Меняет дату инициализации
	 * @param commandArguments аргументы
	 */
	@Override
	public void execute(String[] commandArguments) {
		this.context.collectionManager.clearCollection();
		IdGenerator.clear();
		this.csvLoader.createCollectionFromFile(commandArguments[0], context.lineReader, context.collectionManager);
		this.context.collectionManager.changeInitializationDate();
	}
	
	@Override
	public String getName() {
		return "load";
	}
	
	@Override
	public String getDescription() {
		return "загрузить коллекцию из файла";
	}
}
