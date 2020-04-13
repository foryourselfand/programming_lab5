package Input;

import Expectables.*;
import Expectables.ExpectablesBorder.ExpectedGreater;
import Expectables.ExpectablesBorder.ExpectedLess;
import Expectables.ExpectablesType.*;

import java.util.HashMap;

public enum Variable {
	ID("id"),
	FLAT_NAME("flatName"),
	CREATION_DATE("creationDate"),
	AREA("area"),
	NUMBER_OF_ROOMS("numberOfRooms"),
	HEIGHT("height"),
	IS_NEW("isNew"),
	TRANSPORT("transport"),
	X("x"),
	Y("y"),
	HOUSE_NAME("houseName"),
	YEAR("year"),
	NUMBER_OF_FLOORS("numberOfFloors"),
	NUMBER_OF_LIFTS("numberOfLifts");
	
	public static HashMap<Variable, Argument> variableToArgument = new HashMap<>();
	
	static {
		putArgumentToVariable(ID, new ExpectedLong(), new ExpectedNotNull(), new ExpectedGreater(0));
		putArgumentToVariable(FLAT_NAME, new ExpectedNotNull(), new ExpectedStringLengthNotEmpty());
		putArgumentToVariable(X, new ExpectedFloat(), new ExpectedGreater(- 292));
		putArgumentToVariable(Y, new ExpectedDouble(), new ExpectedGreater(- 747), new ExpectedNotNull());
		putArgumentToVariable(CREATION_DATE, new ExpectedLocalDate(), new ExpectedNotNull());
		putArgumentToVariable(AREA, new ExpectedInteger(), new ExpectedGreater(0));
		putArgumentToVariable(NUMBER_OF_ROOMS, new ExpectedInteger(), new ExpectedLess(11), new ExpectedGreater(0));
		putArgumentToVariable(HEIGHT, new ExpectedInteger(), new ExpectedGreater(0));
		putArgumentToVariable(IS_NEW, new ExpectedBoolean(), new ExpectedNotNull());
		putArgumentToVariable(TRANSPORT, new ExpectedTransport(), new ExpectedNotNull());
		putArgumentToVariable(HOUSE_NAME, new ExpectedNotNull());
		putArgumentToVariable(YEAR, new ExpectedInteger(), new ExpectedGreater(0));
		putArgumentToVariable(NUMBER_OF_FLOORS, new ExpectedLong(), new ExpectedNotNull(), new ExpectedGreater(0));
		putArgumentToVariable(NUMBER_OF_LIFTS, new ExpectedLong(), new ExpectedGreater(0));
	}
	
	private String variableName;
	
	
	Variable(String variableName) {
		this.variableName = variableName;
	}
	
	public static void putArgumentToVariable(Variable variable, Expectable... expectables) {
		variableToArgument.put(variable, new Argument(variable, expectables));
	}
	
	public String getVariableName() {
		return this.variableName;
	}
	
	public String getVariableNameWithPrefix(Argument argument) {
		String message = argument.getExpectablesMessage();
		return String.format("\n%s\nВведите %s: ", message, this.variableName);
	}
}
