import Expected.Argument;
import Utils.Context;

public class Main {
	public static void main(String[] args) {
		Context context = new Context();
		
		while (context.lineReader.hasSomethingToRead()) {
			String lineRead = context.lineReader.readLine(">>> ", new Argument("commandName"));
			context.commandsExecutor.executeCommandByName(lineRead);
		}
	}
}

// execute_script /Users/foryourselfand/Documents/java/itmo/programming_lab5/res/script_3
// load /Users/foryourselfand/Documents/java/itmo/programming_lab5/res/example.csv
// group_counting_by_area
