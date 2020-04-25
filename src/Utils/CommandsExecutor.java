package Utils;

import Commands.Command;
import Errors.InputErrors.InputError;

import java.util.Arrays;

/**
 * Исполнитель команд
 */
public class CommandsExecutor {
	/**
	 * Дежратель команд
	 */
	private final CommandsHolder commandsHolder;
	
	/**
	 * @param commandsHolder держатель комманд
	 */
	public CommandsExecutor(CommandsHolder commandsHolder) {
		this.commandsHolder = commandsHolder;
	}
	
	/**
	 * Пытается исполнить команду
	 * Если возникает какая то ошибка(неправильное имя, параметры), выводит сообщение
	 *
	 * @param line строка содержащая имя команды и параметры
	 */
	public void tryToExecuteCommand(String line) {
		if (line.equals(""))
			return;
		
		String[] lineSplit = this.getLineSplit(line);
		
		String commandName = this.getCommandName(lineSplit);
		String[] commandArguments = this.getCommandArguments(lineSplit);
		
		try {
			Command commandToExecute = commandsHolder.getCommandByName(commandName);
			commandToExecute.executeWithArgumentsValidation(commandArguments);
		} catch (InputError error) {
			System.out.println(error.getMessage());
		}
	}
	
	/**
	 * Возвразает разбиту строку по пробельным символам из неразбитая строка
	 *
	 * @param lineRaw неразбитая строка
	 * @return разбиту строку по пробельным символам
	 */
	private String[] getLineSplit(String lineRaw) {
		String lineTrim = lineRaw.trim();
		return lineTrim.split("\\s+");
	}
	
	/**
	 * Возвращает имя команды из массива, разбитого по пробельным символам
	 * Перый элемент - имя комады
	 *
	 * @param lineSplit массив, разбитый по пробельным символам
	 * @return имя команды
	 */
	private String getCommandName(String[] lineSplit) {
		return lineSplit[0].toLowerCase();
	}
	
	/**
	 * Возвращает массив аргументов из массив, разбитый по пробельным символам
	 * Аргументы - начиная после имени команды и до последнего элемента
	 *
	 * @param lineSplit массив, разбитый по пробельным символам
	 * @return массив аргументов
	 */
	private String[] getCommandArguments(String[] lineSplit) {
		return Arrays.copyOfRange(lineSplit, 1, lineSplit.length);
	}
}
