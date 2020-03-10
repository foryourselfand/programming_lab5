package Expectables.ExpectablesType;

public class ExpectedType extends ExpectableType {
	private Class numberClass;
	
	public ExpectedType(Class numberClass) {
		this.numberClass = numberClass;
	}
	
	@Override
	public Class getNumberClass() {
		return numberClass;
	}
}
