package Commands.CommandsWithNotEmptyCollection;

import Expected.Argument;
import Expected.ExpectedType.ExpectedInteger;
import Utils.Context;

import java.util.List;

public class CommandRemoveById extends CommandWithNotEmptyCollection {
	public CommandRemoveById(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		int id = Integer.parseInt(commandArguments[0]);
		System.out.println("id: " + id);
	}
	
	@Override
	protected void addArgumentValidators(List<Argument> arguments) {
		arguments.add(new Argument("id", new ExpectedInteger()));
	}
	
	@Override
	public String getName() {
		return "remove_by_id";
	}
	
	@Override
	public String getDescription() {
		return "удалить элемент из коллекции по его id";
	}
}
