package Commands;

import Expectables.Argument;
import Expectables.ExpectablesFile.ExpectableFileExist;
import Expectables.ExpectablesFile.ExpectableFileIsRegularFile;
import Expectables.ExpectablesFile.ExpectableFileReadable;
import Input.Flat;
import Utils.CSVLoader;
import Utils.Context;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.LinkedHashSet;
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
				new ExpectableFileExist(),
				new ExpectableFileIsRegularFile(),
				new ExpectableFileReadable()
		));
	}
	
	@Override
	public String getNameOfCommand() {
		return "load";
	}
	
	@Override
	public void execute(String[] commandArguments) {
		super.execute(commandArguments);
		
		LinkedHashSet<Flat> collection;
		
		try {
			collection = this.csvLoader.getCollectionFromCSVFile(commandArguments[0]);
			context.collectionManager.initializeCollection(collection);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}
}
