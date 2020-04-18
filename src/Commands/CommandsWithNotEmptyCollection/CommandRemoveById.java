package Commands.CommandsWithNotEmptyCollection;

import Expected.Argument;
import Expected.ExpectedIdExist;
import Expected.ExpectedType.ExpectedLong;
import Utils.Context;

import java.util.List;

public class CommandRemoveById extends CommandWithNotEmptyCollection {
	public CommandRemoveById(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		long idToRemove = Long.parseLong(commandArguments[0]);
		this.context.flatRemover.removeFlatsById(idToRemove);
	}
	
	@Override
	protected void addArgumentValidators(List<Argument> arguments) {
		arguments.add(new Argument("id",
				new ExpectedLong(),
				new ExpectedIdExist()));
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
