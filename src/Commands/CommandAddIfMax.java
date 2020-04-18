package Commands;

import Input.Flat;
import Utils.Context;

public class CommandAddIfMax extends Command {
	public CommandAddIfMax(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		Flat flatNew = getFlatNew();
		Flat flatMax = getFlatMax();
		addFlatNewToCollectionIfGreaterThatFlatMax(flatNew, flatMax);
	}
	
	private Flat getFlatNew() {
		Flat flatNew = context.flatCreator.getCreatedFlatFromTerminal(this.context.lineReader);
		System.out.println("Новый элемент " + flatNew.toString());
		return flatNew;
	}
	
	private Flat getFlatMax() {
		Flat flatMax = context.collectionManager.getFlatMax();
		System.out.println("Наибольший элемент коллекции " + flatMax.toString());
		return flatMax;
	}
	
	private void addFlatNewToCollectionIfGreaterThatFlatMax(Flat flatNew, Flat flatMax) {
		if (flatNew.compareTo(flatMax) > 0)
			addFlatNewToCollection(flatNew);
		else
			dontAddFlatNewToCollection();
	}
	
	private void addFlatNewToCollection(Flat flatNew) {
		System.out.println("Значение нового элемента превышает значение наибольшего элемента коллекции");
		context.collectionManager.addFlatToCollection(flatNew);
	}
	
	private void dontAddFlatNewToCollection() {
		System.out.println("Значение нового элемента не превышает значение наибольшего элемента коллекции");
		System.out.println("В коллекцию элемент не добавлен");
	}
	
	@Override
	public String getName() {
		return "add_if_max";
	}
	
	@Override
	public String getDescription() {
		return "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
	}
}
