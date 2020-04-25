package Input;

import Expectations.*;
import Expectations.ExpectedBorder.ExpectedGreater;
import Expectations.ExpectedBorder.ExpectedLess;
import Expectations.ExpectedDate.ExpectedLocalDate;
import Expectations.ExpectedDate.ExpectedNoLaterThanNow;
import Expectations.ExpectedType.*;
import Utils.Header;

import java.util.HashMap;
import java.util.Map;

/**
 * Содержит имена переменных в виде перечисляемых значений
 * К каждой переменной поставлены в соответствие ожидания
 */
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
	
	/**
	 * Словарь. Ключ: переменная. Значение: аргумент
	 */
	public static Map<Variable, Argument> variableToArgument;
	
	/**
	 * Ожидаемый заголовок
	 */
	public static Header headerRequired;
	
	static {
		variableToArgument = new HashMap<>();
		headerRequired = new Header(Variable.values());
		
		putArgumentToVariable(ID, new ExpectedNotNull(), new ExpectedLong(), new ExpectedGreater(0), new ExpectedIdUnique());
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
	
	/**
	 * Имя переменной
	 */
	private final String variableName;
	
	/**
	 * Создает элемент с именем переменной
	 *
	 * @param variableName имя переменной
	 */
	Variable(String variableName) {
		this.variableName = variableName;
	}
	
	/**
	 * Ставит аргумент в соответствии с переменной
	 *
	 * @param variable     переменная
	 * @param expectations аргумент
	 */
	public static void putArgumentToVariable(Variable variable, Expectation... expectations) {
		variableToArgument.put(variable, new Argument(variable, expectations));
	}
	
	/**
	 * Возвращает имя переменной
	 *
	 * @return имя переменной
	 */
	public String getVariableName() {
		return this.variableName;
	}
	
	/**
	 * Возвращает имя переменной с сообщением об ожиданиях
	 *
	 * @param argument аргумент
	 * @return имя переменной с сообщением об ожиданиях
	 */
	public String getVariableNameWithExpectationsMessage(Argument argument) {
		return String.format("Введите %s (%s): ", argument.getName(), argument.getExpectationsMessage());
	}
}
