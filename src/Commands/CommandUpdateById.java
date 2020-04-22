package Commands;

import Expected.Argument;
import Expected.ExpectedIdExist;
import Expected.ExpectedType.ExpectedLong;
import Input.Flat;
import Utils.Context;

import java.util.List;

public class CommandUpdateById extends CommandWithNotEmptyCollectionSaveAfterExecute {
	public CommandUpdateById(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		long idToRemove = Long.parseLong(commandArguments[0]);
		Flat flatNew = createFlatNew();
		removeFlatOld(idToRemove);
		addFlatNew(flatNew);
	}
	
	private Flat createFlatNew() {
		return context.flatCreator.getCreatedFlatFromTerminal(this.context.lineReader);
	}
	
	private void removeFlatOld(long idToRemove) {
		context.flatRemover.removeFlatsById(idToRemove);
	}
	
	private void addFlatNew(Flat flatNew) {
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
		return "update_by_id";
	}
	
	@Override
	public String getDescription() {
		return "обновить значение элемента коллекции, id которого равен заданному";
	}
}
