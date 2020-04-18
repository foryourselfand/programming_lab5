package Utils;

import Errors.InputErrors.InputErrorFull;
import Errors.ScriptAlreadyExecutedError;
import Expected.Argument;
import Input.Variable;
import SourseReaders.SourceReader;
import SourseReaders.SourceReaderTerminal;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LineReader {
	private Set<String> sourceReaderFilePaths;
	private SourceReader sourceReaderActive;
	private Stack<SourceReader> sourceReaderStack;
	private boolean repeatOnException;
	
	public LineReader() {
		this.sourceReaderFilePaths = new HashSet<>();
		this.sourceReaderStack = new Stack<>();
		this.addSourceReader(new SourceReaderTerminal(System.in));
	}
	
	public SourceReader getSourceReaderActive() {
		return sourceReaderActive;
	}
	
	public String readLine(SourceReader sourceReader, String prefix, Argument argument) {
		while (this.hasSomethingToRead()) {
			
			System.out.print(prefix);
			
			try {
				String lineRead = sourceReader.getLineReadPrintPostfix();
				argument.checkArgument(lineRead);
				
				return lineRead;
			} catch (InputErrorFull inputErrorFull) {
				if (! this.repeatOnException)
					throw inputErrorFull;
				System.out.println(inputErrorFull.getMessage());
			}
		}
		
		return "";
	}
	
	public void setRepeatOnException(boolean repeatOnException) {
		this.repeatOnException = repeatOnException;
	}
	
	public String readLine(String prefix, Argument argument) {
		return readLine(this.sourceReaderActive, prefix, argument);
	}
	
	public String readLine(String prefix) {
		return readLine(this.sourceReaderActive, prefix, new Argument(""));
	}
	
	public String readLine(SourceReader sourceReader, Variable variable) {
		Argument argument = Variable.variableToArgument.get(variable);
		return this.readLine(sourceReader, variable.getVariableNameWithPrefix(argument), argument);
	}
	
	public String readLine(Variable variable) {
		return readLine(this.sourceReaderActive, variable);
	}
	
	public boolean hasSomethingToRead() {
		while (! this.sourceReaderActive.hasSomethingToRead()) {
			SourceReader sourceReader = this.sourceReaderStack.pop();
			String sourceReaderFilePath = sourceReader.getSource();
			this.sourceReaderFilePaths.remove(sourceReaderFilePath);
			
			this.sourceReaderActive = sourceReaderStack.peek();
		}
		
		return true;
	}
	
	public void addSourceReader(SourceReader sourceReaderToAdd) {
		String sourceReaderFilePath = sourceReaderToAdd.getSource();
		
		if (this.sourceReaderFilePaths.contains(sourceReaderFilePath))
			throw new ScriptAlreadyExecutedError();
		this.sourceReaderFilePaths.add(sourceReaderFilePath);
		
		this.sourceReaderStack.add(sourceReaderToAdd);
		this.sourceReaderActive = sourceReaderStack.peek();
	}
	
}
