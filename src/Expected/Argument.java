package Expected;

import Errors.WrongArgumentErrors.WrongArgumentError;
import Errors.InputErrors.InputErrorShort;
import Input.Variable;

import java.util.Arrays;
import java.util.List;

public class Argument {
	private String name;
	private List<Expected> expecteds;
	
	public Argument(String name, Expected... expecteds) {
		this.name = name;
		this.expecteds = Arrays.asList(expecteds);
	}
	
	public Argument(Variable variable, Expected... expecteds) {
		this(variable.getVariableName(), expecteds);
	}
	
	public void checkArgument(String argument) {
		for (Expected expected : this.expecteds) {
			try {
				expected.checkValueCorrectness(argument);
			} catch (InputErrorShort inputError) {
				throw new WrongArgumentError(this.getName(), inputError.getMessage());
			}
		}
	}
	
	public String getExpectablesMessage() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Expected expected : this.expecteds) {
			stringBuilder.append(expected.getErrorMessage());
			stringBuilder.append("; ");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		
		return stringBuilder.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public List<Expected> getExpecteds() {
		return expecteds;
	}
}
