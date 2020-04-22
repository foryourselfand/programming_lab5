package Commands;

import Expected.Argument;
import Expected.ExpectedFile.*;
import Utils.Context;

import java.util.List;

public class CommandSave extends CommandWithNotEmptyCollection {
	public CommandSave(Context context) {
		super(context);
	}
	
	@Override
	protected void addArgumentValidators(List<Argument> arguments) {
		arguments.add(new Argument(
				"file_name",
				new ExpectedFileExtensionCsv(),
				new ExpectedCreateFileIfNotExist(),
				new ExpectedFileExist(),
				new ExpectedFileRegular(),
				new ExpectedFileWritable()
		));
	}
	
	@Override
	public void execute(String[] commandArguments) {
		String filePath = commandArguments[0];
		
		this.context.csvSaver.saveCollectionCSV(this.context.collectionManager.getCollection(), filePath);
		System.out.println("Коллекция сохранена в файл");
	}
	
	
	@Override
	public String getName() {
		return "save";
	}
	
	@Override
	public String getDescription() {
		return "сохранить коллекцию в файл";
	}
}
