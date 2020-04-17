package Commands;

import Utils.Context;

public class CommandAddIfMax extends Command {
	public CommandAddIfMax(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
	
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
