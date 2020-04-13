package Expectables;

import Errors.ArgumentErrors.WrongArgumentError;
import Errors.InputError;
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
			} catch (InputError inputError) {
				throw new WrongArgumentError(this.getName(), inputError.getMessage());
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getExpectablesMessage() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Expectable expectable : this.expectables) {
			stringBuilder.append(expectable.getErrorMessage());
			stringBuilder.append(". ");
		}
		return stringBuilder.toString();
	}
	
	public List<Expectable> getExpectables() {
		return expectables;
	}
}
