package Commands;

import Expectations.Argument;
import Expectations.ExpectedFile.ExpectedFileExist;
import Expectations.ExpectedFile.ExpectedFileReadable;
import Expectations.ExpectedFile.ExpectedFileRegular;
import Expectations.ExpectedFile.ExpectedFileWritable;
import SourseReaders.SourceReaderFile;
import Utils.Context;

import java.util.List;

/**
 * Команда исполнения скрипта
 */
public class CommandExecuteScript extends Command {
	public CommandExecuteScript(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		context.lineReader.addSourceReader(new SourceReaderFile(String.valueOf(commandArguments[0])));
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
	public String getName() {
		return "execute_script";
	}
	
	@Override
	public String getDescription() {
		return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
	}
}
