package Commands;

import Expectations.Argument;
import Expectations.ExpectedFile.*;
import Utils.Context;
import Utils.TempFileManager;

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
		
		this.context.csvSaver.saveCollectionToCSVFile(this.context.collectionManager.getCollection(), filePath);
		System.out.println("Коллекция сохранена в файл");
		
		if (TempFileManager.isTempFileExist()) {
			TempFileManager.deleteTempFile();
			System.out.println("Временный файл удален, т.к. есть нормальная версия");
		}
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
