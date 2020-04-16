package Commands;

import Utils.Context;

public class CommandInfo extends Command {
	public CommandInfo(Context context) {
		super(context);
	}
	
	@Override
	public String getNameOfCommand() {
		return "info";
	}
	
	@Override
	public void execute(String[] commandArguments) {
		System.out.println("Тип коллекции: " + context.collectionManager.getCollectionType());
		System.out.println("Тип элементов коллекции: " + context.collectionManager.getCollectionElementType());
		System.out.println("Дата инициализации коллекции: " + context.collectionManager.getInitializationDate());
		System.out.println("Количество элементов в коллекции: " + context.collectionManager.getCollectionSize());
	}
}
