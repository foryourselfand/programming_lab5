package Commands;

import Expected.Argument;
import Expected.ExpectedFile.ExpectedFileExist;
import Expected.ExpectedFile.ExpectedFileRegular;
import Expected.ExpectedFile.ExpectedFileReadable;
import Expected.ExpectedFile.ExpectedFileWritable;
import SourseReaders.SourceReaderFile;
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
				new ExpectedFileExist(),
				new ExpectedFileRegular(),
				new ExpectedFileReadable(),
				new ExpectedFileWritable()));
	}
	
	@Override
	public String getNameOfCommand() {
		return "execute_script";
	}
}
