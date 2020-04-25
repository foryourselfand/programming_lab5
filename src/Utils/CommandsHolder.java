package Utils;

import Commands.Command;
import Errors.NoSuchCommandError;

import java.util.*;

public class CommandsHolder {
	/**
	 * Словарь. Ключ: имя команды. Значение: команда
	 */
	private final Map<String, Command> commands;
	
	/**
	 * Дэк истории команд
	 */
	private final Deque<Command> commandsHistory;
	
	public CommandsHolder() {
		commands = new LinkedHashMap<>();
		commandsHistory = new ArrayDeque<>();
	}
	
	/**
	 * Добавляет команду в словарь по имени
	 *
	 * @param command Команда для добавления в словарь по имени
	 * @return эеземпляр CommandsHolder, что бы сразу можно было снова вызвать addCommand
	 */
	public CommandsHolder addCommand(Command command) {
		commands.put(command.getName(), command);
		return this;
	}
	
	/**
	 * Возвращает команду по имени
	 * Добавляет команду в историю команд
	 *
	 * @param name имя команды
	 * @return команду
	 * @throws NoSuchCommandError Если команды соответствующей имени нет
	 */
	public Command getCommandByName(String name) {
		if (! this.commands.containsKey(name))
			throw new NoSuchCommandError(name);
		
		Command command = this.commands.get(name);
		addCommandToHistory(command);
		return command;
	}
	
	/**
	 * Добавляет команду в историю команщд
	 *
	 * @param command команда для добавления в истрпию
	 */
	private void addCommandToHistory(Command command) {
		if (commandsHistory.size() == Context.HISTORY_SIZE)
			commandsHistory.pollFirst();
		commandsHistory.addLast(command);
	}
	
	/**
	 * Возвращает итератор команд
	 *
	 * @return итератор команд
	 */
	public Iterator<Command> getCommands() {
		return commands.values().iterator();
	}
	
	/**
	 * Возвращает итератор истории команд
	 *
	 * @return итератор истории команд
	 */
	public Iterator<Command> getCommandsHistory() {
		return commandsHistory.iterator();
	}
}
