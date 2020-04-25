import Utils.Context;

public class Main {
	public static void main(String[] args) {
		Context context = new Context();
		context.loadCollectionFromArgsOrRestoreFromTempFile(args);
		context.readCommandAndTryToExecute();
	}
}
