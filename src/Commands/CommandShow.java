package Commands;

import Utils.Context;

public class CommandShow extends Command {
	public CommandShow(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		context.collectionManager.showCollection();
	}
	
	@Override
	public String getNameOfCommand() {
		return "show";
	}
}
