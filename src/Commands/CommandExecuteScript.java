package Commands;

import Expectables.Argument;
import Expectables.ExpectablesFile.ExpectableFileExist;
import Expectables.ExpectablesFile.ExpectableFileIsRegularFile;
import Expectables.ExpectablesFile.ExpectableFileReadable;
import Utils.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CommandExecuteScript extends Command {
	public CommandExecuteScript(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		super.execute(commandArguments);
		
		File file = new File(String.valueOf(commandArguments[0]));
		System.out.println(file.length());
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		System.out.println(file.canExecute());
		System.out.println();
		
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
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
				new ExpectableFileReadable()));
	}
	
	@Override
	public String getNameOfCommand() {
		return "execute_script";
	}
}
