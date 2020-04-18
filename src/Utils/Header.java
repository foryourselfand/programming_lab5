package Utils;

import Input.Variable;

import java.util.*;

public class Header {
	private List<String> list;
	private Set<String> set;
	private int length;
	
	public Header(List<String> list) {
		this.list = list;
		setSetAndLength(list);
	}
	
	public Header(String[] array) {
		this(Arrays.asList(array));
	}
	
	public Header(Variable[] values) {
		this.list = new ArrayList<>();
		for (Variable variable : values)
			this.list.add(variable.getVariableName());
		setSetAndLength(list);
	}
	
	public void setSetAndLength(List<String> list) {
		this.set = new HashSet<>(list);
		this.length = list.size();
	}
	
	public List<String> getList() {
		return list;
	}
	
	public String[] getArray() {
		return list.toArray(new String[list.size()]);
	}
	
	public Set<String> getSet() {
		return set;
	}
	
	public int getLength() {
		return length;
	}
}
