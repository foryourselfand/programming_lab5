package Input;

import Expectations.*;
import Expectations.ExpectedBorder.ExpectedGreater;
import Expectations.ExpectedBorder.ExpectedLess;
import Expectations.ExpectedDate.ExpectedLocalDate;
import Expectations.ExpectedDate.ExpectedNoLaterThanNow;
import Expectations.ExpectedType.*;
import Utils.Header;

import java.util.HashMap;

public enum Variable {
	ID("id"),
	FLAT_NAME("flatName"),
	X("x"),
	Y("y"),
	CREATION_DATE("creationDate"),
	AREA("area"),
	NUMBER_OF_ROOMS("numberOfRooms"),
	HEIGHT("height"),
	IS_NEW("isNew"),
	TRANSPORT("transport"),
	HOUSE_NAME("houseName"),
	YEAR("year"),
	NUMBER_OF_FLOORS("numberOfFloors"),
	NUMBER_OF_LIFTS("numberOfLifts");
	
	public static HashMap<Variable, Argument> variableToArgument = new HashMap<>();
	public static Header headerRequired = new Header(Variable.values());
	
	static {
		putArgumentToVariable(ID, new ExpectedNotNull(), new ExpectedLong(), new ExpectedGreater(0), new ExpectedUnique());
		putArgumentToVariable(FLAT_NAME, new ExpectedNotNull(), new ExpectedStringLengthNotEmpty());
		putArgumentToVariable(X, new ExpectedNotNull(), new ExpectedFloat(), new ExpectedGreater(- 292));
		putArgumentToVariable(Y, new ExpectedNotNull(), new ExpectedDouble(), new ExpectedGreater(- 747));
		putArgumentToVariable(CREATION_DATE, new ExpectedNotNull(), new ExpectedLocalDate(), new ExpectedNoLaterThanNow());
		putArgumentToVariable(AREA, new ExpectedNotNull(), new ExpectedInteger(), new ExpectedGreater(0));
		putArgumentToVariable(NUMBER_OF_ROOMS, new ExpectedNotNull(), new ExpectedInteger(), new ExpectedLess(11), new ExpectedGreater(0));
		putArgumentToVariable(HEIGHT, new ExpectedInteger(), new ExpectedGreater(0));
		putArgumentToVariable(IS_NEW, new ExpectedNotNull(), new ExpectedBoolean());
		putArgumentToVariable(TRANSPORT, new ExpectedNotNull(), new ExpectedTransport());
		putArgumentToVariable(HOUSE_NAME, new ExpectedNotNull());
		putArgumentToVariable(YEAR, new ExpectedInteger(), new ExpectedGreater(0));
		putArgumentToVariable(NUMBER_OF_FLOORS, new ExpectedLong(), new ExpectedGreater(0));
		putArgumentToVariable(NUMBER_OF_LIFTS, new ExpectedNotNull(), new ExpectedLong(), new ExpectedGreater(0));
	}
	
	private String variableName;
	
	
	Variable(String variableName) {
		this.variableName = variableName;
	}
	
	public static void putArgumentToVariable(Variable variable, Expectation... expectations) {
		variableToArgument.put(variable, new Argument(variable, expectations));
	}
	
	public String getVariableName() {
		return this.variableName;
	}
	
	public String getVariableNameWithPrefix(Argument argument) {
		return String.format("Введите %s (%s): ", argument.getName(), argument.getExpectationsMessage());
	}
}
