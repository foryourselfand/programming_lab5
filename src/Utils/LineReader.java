package Utils;

import Errors.InputErrorFull;
import Errors.ScriptAlreadyExecutedError;
import Expectables.Argument;
import Input.Variable;
import SourseReader.SourceReader;
import SourseReader.SourceReaderFile;
import SourseReader.SourceReaderTerminal;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LineReader {
	private SourceReader sourceReaderActive;
	private Stack<SourceReader> sourceReaderStack;
	private Set<String> sourceReaderFilePaths;
	
	public LineReader() {
		this.sourceReaderStack = new Stack<>();
		this.addSourceReader(new SourceReaderTerminal(System.in));
		
		this.sourceReaderFilePaths = new HashSet<>();
	}
	
	public String readLine(SourceReader sourceReader, String prefix, Argument argument) {
		while (this.hasSomethingToRead()) {
			
			System.out.print(prefix);
			
			try {
				String lineRead = sourceReader.getLineReadPrintPostfix();
				argument.checkArgument(lineRead);
				
				return lineRead;
			} catch (InputErrorFull inputErrorFull) {
				if (! this.sourceReaderActive.repeatOnException())
					throw inputErrorFull;
				System.out.println(inputErrorFull.getMessage());
			}
		}
		
		return "";
	}
	
	
	public String readLine(String prefix, Argument argument) {
		return readLine(this.sourceReaderActive, prefix, argument);
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
			if (sourceReader instanceof SourceReaderFile) {
				SourceReaderFile sourceReaderFile = (SourceReaderFile) sourceReader;
				String sourceReaderFilePath = sourceReaderFile.getPath();
				this.sourceReaderFilePaths.remove(sourceReaderFilePath);
			}
			
			this.sourceReaderActive = sourceReaderStack.peek();
		}
		
		return true;
	}
	
	public void addSourceReader(SourceReader sourceReaderToAdd) {
		if (sourceReaderToAdd instanceof SourceReaderFile) {
			SourceReaderFile sourceReaderFile = (SourceReaderFile) sourceReaderToAdd;
			String sourceReaderFilePath = sourceReaderFile.getPath();
			
			if (this.sourceReaderFilePaths.contains(sourceReaderFilePath))
				throw new ScriptAlreadyExecutedError();
			this.sourceReaderFilePaths.add(sourceReaderFilePath);
		}
		this.sourceReaderStack.add(sourceReaderToAdd);
		this.sourceReaderActive = sourceReaderStack.peek();
	}
	
}
