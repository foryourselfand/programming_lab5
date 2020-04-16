package Commands;

import Expectables.Argument;
import Expectables.ExpectablesFile.ExpectableFileExist;
import Expectables.ExpectablesFile.ExpectableFileIsRegularFile;
import Expectables.ExpectablesFile.ExpectableFileReadable;
import Expectables.ExpectablesFile.ExpectableFileWritable;
import SourseReader.SourceReaderFile;
import Utils.Context;

import java.io.FileNotFoundException;
import java.util.List;

public class CommandExecuteScript extends Command {
	public CommandExecuteScript(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		try {
			context.lineReader.addSourceReader(new SourceReaderFile(String.valueOf(commandArguments[0])));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void addArgumentValidators(List<Argument> arguments) {
		arguments.add(new Argument(
				"file_name",
				new ExpectableFileExist(),
				new ExpectableFileIsRegularFile(),
				new ExpectableFileReadable(),
				new ExpectableFileWritable()));
	}
	
	@Override
	public String getNameOfCommand() {
		return "execute_script";
	}
}
