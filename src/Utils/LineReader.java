package Utils;

import Errors.InputError;
import Expectables.Argument;
import Input.Variable;
import SourseReader.SourceReader;
import SourseReader.SourceReaderFactory;

public class LineReader {
	private SourceReader sourceReader;
	
	public LineReader(SourceReader sourceReader) {
		this.sourceReader = sourceReader;
	}
	
	public String readLine(SourceReader sourceReader, String prefix, Argument argument) {
		while (this.hasSomethingToRead()) {
			
			System.out.print(prefix);
			
			try {
				String lineRead = sourceReader.getLineReadPrintPostfix();
				argument.checkArgument(lineRead);
				
				return lineRead;
			} catch (InputError inputError) {
				if (! this.sourceReader.repeatOnException())
					throw inputError;
				System.out.println(inputError.getMessage());
			}
		}
		
		return "";
	}
	
	
	public String readLine(String prefix, Argument argument) {
		return readLine(this.sourceReader, prefix, argument);
	}
	
	public String readLine(SourceReader sourceReader, Variable variable) {
		Argument argument = Variable.variableToArgument.get(variable);
		return this.readLine(sourceReader, variable.getVariableNameWithPrefix(argument), argument);
	}
	
	public String readLine(Variable variable) {
		return readLine(this.sourceReader, variable);
	}
	
	public boolean hasSomethingToRead() {
		if (! this.sourceReader.hasSomethingToRead())
			this.sourceReader = SourceReaderFactory.getSourceReaderTerminal();
		return this.sourceReader.hasSomethingToRead();
	}
	
	public void setSourceReader(SourceReader sourceReader) {
		this.sourceReader = sourceReader;
	}
	
}
