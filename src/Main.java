import Utils.Context;
import Utils.TempFileManager;

public class Main {
	public static void main(String[] args) {
		Context context = new Context();
		
		if (args.length == 1)
			context.commandsExecutor.executeCommand("load " + args[0]);
		else {
			context.tryToLoadTempFile();
		}
		
		while (context.lineReader.hasSomethingToRead()) {
			String lineRead = context.lineReader.readLine(">>> ");
			context.commandsExecutor.executeCommand(lineRead);
		}
		
	}
}
