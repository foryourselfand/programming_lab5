package Expectables;

import Errors.InputError;
import Errors.ArgumentErrors.WrongArgumentError;

import java.util.Arrays;
import java.util.List;

public class Argument {
	private String name;
	private List<Expectable> expectables;
	
	public Argument(String name, Expectable... expectables) {
		this.name = name;
		this.expectables = Arrays.asList(expectables);
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
	
	public List<Expectable> getExpectables() {
		return expectables;
	}
}
