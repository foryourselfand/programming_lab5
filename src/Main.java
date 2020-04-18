import Utils.Context;

public class Main {
	public static void main(String[] args) {
		Context context = new Context();
		
		if (args.length == 1)
			context.commandsExecutor.executeCommand("load " + args[0]);
		
		while (context.lineReader.hasSomethingToRead()) {
			String lineRead = context.lineReader.readLine(">>> ");
			context.commandsExecutor.executeCommand(lineRead);
		}
		
	}
}

// execute_script /Users/foryourselfand/Documents/java/itmo/programming_lab5/res/script_3
// load /Users/foryourselfand/Documents/java/itmo/programming_lab5/res/example.csv
// save /Users/foryourselfand/Documents/java/itmo/programming_lab5/res/output.csv
// remove_by_id
