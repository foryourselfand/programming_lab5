package Commands.CommandsWithNotEmptyCollection;

import Expected.Argument;
import Expected.ExpectedIdExist;
import Expected.ExpectedType.ExpectedLong;
import Input.Flat;
import Utils.Context;

import java.util.List;

public class CommandRemoveById extends CommandWithNotEmptyCollection {
	public CommandRemoveById(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		long idToDelete = Long.parseLong(commandArguments[0]);
		removeFlatOld(idToDelete);
		addFlatNew();
	}
	
	private void removeFlatOld(long idToDelete) {
		Flat flatOld = getFlatOld(idToDelete);
		context.collectionManager.removeFlatFromCollection(flatOld);
	}
	
	private Flat getFlatOld(long idToDelete) {
		Flat flatOld = null;
		for (Flat flat : context.collectionManager.getCollection()) {
			long idCurrent = flat.getId();
			if (idCurrent == idToDelete) {
				flatOld = flat;
				break;
			}
		}
		return flatOld;
	}
	
	private void addFlatNew() {
		Flat flatNew = context.flatCreator.getCreatedFlatFromTerminal(this.context.lineReader);
		context.collectionManager.addFlatToCollection(flatNew);
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
