package Expected.ExpectedType;

public class ExpectedTypeConcrete extends ExpectedType {
	private Class numberClass;
	
	public ExpectedTypeConcrete(Class numberClass) {
		this.numberClass = numberClass;
	}
	
	@Override
	public Class getNumberClass() {
		return numberClass;
	}
}
