package Commands;

import Errors.WrongArgumentErrors.WrongArgumentLengthError;
import Expected.Argument;
import Utils.Context;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
	protected Context context;
	private List<Argument> arguments;
	private int argumentsLength;
	
	public Command(Context context) {
		this.context = context;
		
		arguments = new ArrayList<>();
		addArgumentValidators(this.arguments);
		
		this.argumentsLength = this.arguments.size();
	}
	
	public abstract String getNameOfCommand();
	
	public void executeWithValidation(String[] commandArguments) {
		this.validateArguments(commandArguments);
		this.execute(commandArguments);
	}
	
	public abstract void execute(String[] commandArguments);
	
	private void validateArguments(String[] commandArguments) {
		int argumentsLengthExpected = this.argumentsLength;
		int argumentsLengthActual = commandArguments.length;
		
		if (argumentsLengthExpected != argumentsLengthActual)
			throw new WrongArgumentLengthError(argumentsLengthExpected, argumentsLengthActual);
		
		for (int i = 0; i < argumentsLengthActual; i++)
			this.arguments.get(i).checkArgument(commandArguments[i]);
	}
	
	protected void addArgumentValidators(List<Argument> arguments) {
	}
}
