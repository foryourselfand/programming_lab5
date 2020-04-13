package Expectables;

import Errors.ArgumentErrors.WrongArgumentError;
import Errors.InputErrorShort;
import Input.Variable;

import java.util.Arrays;
import java.util.List;

public class Argument {
	private String name;
	private List<Expectable> expectables;
	
	public Argument(String name, Expectable... expectables) {
		this.name = name;
		this.expectables = Arrays.asList(expectables);
	}
	
	public Argument(Variable variable, Expectable... expectables) {
		this(variable.getVariableName(), expectables);
	}
	
	public void checkArgument(String argument) {
		for (Expectable expectable : this.expectables) {
			try {
				expectable.checkValueValidnes(argument);
			} catch (InputErrorShort inputError) {
				throw new WrongArgumentError(this.getName(), inputError.getMessage());
			}
		}
	}
	
	public String getExpectablesMessage() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Expectable expectable : this.expectables) {
			stringBuilder.append(expectable.getErrorMessage());
			stringBuilder.append("; ");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		
		return stringBuilder.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public List<Expectable> getExpectables() {
		return expectables;
	}
}
