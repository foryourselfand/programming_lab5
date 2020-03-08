public abstract class LineValidator {
	private LineReader lineReader;
	
	public LineValidator(LineReader lineReader) {
		this.lineReader = lineReader;
	}
	
	public String getValidatedLine(String prefix) {
		
		boolean isNeedToRead = true;
		String lineReaded = "";
		
		do {
			try {
				lineReaded = this.lineReader.readLine(prefix);
				
			} catch (Exception e) {
				lineReaded = "";
				isNeedToRead = this.isNeedToReadOnFail();
			}
		} while (isNeedToRead);
		
		return lineReaded;
	}
	
	abstract public boolean isNeedToReadOnFail();
}
