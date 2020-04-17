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
	
	public void executeWithValidation(String[] commandArguments) {
		this.validateArguments(commandArguments);
		this.execute(commandArguments);
	}
	
	private void validateArguments(String[] commandArguments) {
		int argumentsLengthExpected = this.argumentsLength;
		int argumentsLengthActual = commandArguments.length;
		
		if (argumentsLengthExpected != argumentsLengthActual)
			throw new WrongArgumentLengthError(this.getNameWithArguments(), argumentsLengthExpected, argumentsLengthActual);
		
		for (int i = 0; i < argumentsLengthActual; i++)
			this.arguments.get(i).checkArgument(commandArguments[i]);
	}
	
	public String getNameWithArguments() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(getName());
		
		for (Argument argument : this.arguments) {
			stringBuilder.append(" {");
			stringBuilder.append(argument.getName());
			stringBuilder.append(": ");
			stringBuilder.append(argument.getExpectablesMessage());
			stringBuilder.append("}");
			stringBuilder.append("; ");
		}
		
		if (! this.arguments.isEmpty())
			stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
		return stringBuilder.toString();
	}
	
	public String getFullInformation() {
		return getNameWithArguments() +
				": " +
				this.getDescription();
	}
	
	public abstract void execute(String[] commandArguments);
	
	public abstract String getName();
	
	public abstract String getDescription();
	
	protected void addArgumentValidators(List<Argument> arguments) {
	}
}
