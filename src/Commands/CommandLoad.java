package Commands;

import Expected.Argument;
import Expected.ExpectedFile.ExpectedFileExist;
import Expected.ExpectedFile.ExpectedFileExtensionCsv;
import Expected.ExpectedFile.ExpectedFileReadable;
import Expected.ExpectedFile.ExpectedFileRegular;
import Generators.IdGenerator;
import Utils.CSVLoader;
import Utils.Context;

import java.util.List;

public class CommandLoad extends Command {
	private CSVLoader csvLoader;
	
	public CommandLoad(Context context) {
		super(context);
		csvLoader = new CSVLoader();
	}
	
	@Override
	protected void addArgumentValidators(List<Argument> arguments) {
		arguments.add(new Argument(
				"file_name",
				new ExpectedFileExist(),
				new ExpectedFileRegular(),
				new ExpectedFileReadable(),
				new ExpectedFileExtensionCsv()
		));
	}
	
	@Override
	public String getNameOfCommand() {
		return "load";
	}
	
	@Override
	public void execute(String[] commandArguments) {
		this.context.collectionManager.clearCollection();
		IdGenerator.clear();
		this.csvLoader.createCollectionFromFile(commandArguments[0], context.collectionManager);
		this.context.collectionManager.changeInitializationDate();
	}
}
