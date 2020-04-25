package Commands;

import Errors.WrongArgumentErrors.WrongArgumentLengthError;
import Errors.WrongArgumentErrors.WrongArgumentLengthFullError;
import Expectations.Argument;
import Utils.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Команда
 */
public abstract class Command {
	/**
	 * Лист аргументов
	 */
	private final List<Argument> arguments;
	/**
	 * Количество элементов в листе аргументов
	 */
	private final int argumentsLength;
	
	/**
	 * Для легкого доступа ресурсам, требуемым для исполнения команды
	 */
	protected Context context;
	
	/**
	 * Создается команда
	 * Добавляются аргументы
	 *
	 * @param context контекст
	 */
	public Command(Context context) {
		this.context = context;
		
		arguments = new ArrayList<>();
		addArgumentValidators(this.arguments);
		
		this.argumentsLength = this.arguments.size();
	}
	
	/**
	 * Проверяет аргументы на правильность
	 * Длина аргументов
	 * Соответствие значений аргументов на правильность
	 *
	 * @param commandArguments аргументы комманды
	 */
	protected void validateArguments(String[] commandArguments) {
		int argumentsLengthExpected = this.argumentsLength;
		int argumentsLengthActual = commandArguments.length;
		
		if (argumentsLengthExpected != argumentsLengthActual) {
			if (argumentsLengthExpected == 0)
				throw new WrongArgumentLengthError(argumentsLengthExpected, argumentsLengthActual);
			else
				throw new WrongArgumentLengthFullError(argumentsLengthExpected, argumentsLengthActual, getArgumentsDescription());
		}
		
		for (int i = 0; i < argumentsLengthActual; i++)
			this.arguments.get(i).checkArgument(commandArguments[i]);
	}
	
	/**
	 * Исполнить команду с валидацией аргументов
	 *
	 * @param commandArguments аргументы комманды
	 */
	public void executeWithArgumentsValidation(String[] commandArguments) {
		this.validateArguments(commandArguments);
		this.printDescriptionAndExecute(commandArguments);
	}
	
	/**
	 * Вывести описание команды и исполнить команду
	 *
	 * @param commandArguments аргументы комманды
	 */
	public void printDescriptionAndExecute(String[] commandArguments) {
		System.out.println(getDescription());
		this.execute(commandArguments);
	}
	
	/**
	 * Возвращает описание аргументов
	 *
	 * @return описание аргументов
	 */
	public String getArgumentsDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (Argument argument : this.arguments) {
			stringBuilder.append(" {");
			stringBuilder.append(argument.getName());
			stringBuilder.append(": ");
			stringBuilder.append(argument.getExpectationsMessage());
			stringBuilder.append("}");
			stringBuilder.append("; ");
		}
		
		if (! this.arguments.isEmpty())
			stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
		
		return stringBuilder.toString();
	}
	
	/**
	 * возвращает имя с описанием аргументов
	 *
	 * @return имя с описанием аргументов
	 */
	public String getNameWithArgumentsDescription() {
		return getName() + getArgumentsDescription();
	}
	
	/**
	 * Возвращает имя с описанием аргументов и с описанием команды
	 *
	 * @return имя с описанием аргументов и с описанием команды
	 */
	public String getFullInformation() {
		return getNameWithArgumentsDescription() +
				": " +
				this.getDescription();
	}
	
	/**
	 * Исполнение
	 *
	 * @param commandArguments аргументы
	 */
	public abstract void execute(String[] commandArguments);
	
	/**
	 * Возвращает имя команды
	 *
	 * @return имя команды
	 */
	public abstract String getName();
	
	/**
	 * Возвращает описание команды
	 *
	 * @return описание команды
	 */
	public abstract String getDescription();
	
	/**
	 * Шаблонный метод
	 * Какой команде нужны обязательные аргументы - та переопределит этот метод и добавит обязательные аргументы
	 *
	 * @param arguments аргументы, передаются по ссылке
	 */
	protected void addArgumentValidators(List<Argument> arguments) {
	}
}
