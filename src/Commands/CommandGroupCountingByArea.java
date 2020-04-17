package Commands;

import Utils.Context;

public class CommandGroupCountingByArea extends Command {
	public CommandGroupCountingByArea(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
	
	}
	
	@Override
	public String getName() {
		return "group_counting_by_area";
	}
	
	@Override
	public String getDescription() {
		return "сгруппировать элементы коллекции по значению поле area, вывести количество элементов в каждой группе";
	}
}
