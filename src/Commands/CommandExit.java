package Commands;

import Utils.Context;
import Utils.TempFileManager;

/**
 * Команда выхода
 */
public class CommandExit extends Command {
	public CommandExit(Context context) {
		super(context);
	}
	
	/**
	 * Если есть несохраненные данные, убеждается что точно нужно выйти
	 * @param commandArguments аргументы
	 */
	@Override
	public void execute(String[] commandArguments) {
		if (TempFileManager.isTempFileExist()) {
			System.out.println("Есть несохраненные данные. Уверены что хотите выйти без сохранения данных?");
			
			String choice;
			do {
				choice = this.context.lineReader.readLine("Выйти без сохранения данных? y / n: ").trim().toLowerCase();
			} while (! choice.equals("y") && ! choice.equals("n"));
			
			if (choice.equals("y")) {
				System.out.println("Программа завершена без сохранения в файл");
				TempFileManager.deleteTempFile();
				exit();
			} else {
				System.out.println("Программа не завершена");
			}
		} else {
			exit();
		}
		
	}
	
	public void exit() {
		System.exit(42);
	}
	
	@Override
	public String getName() {
		return "exit";
	}
	
	@Override
	public String getDescription() {
		return "завершить программу (без сохранения в файл)";
	}
}
