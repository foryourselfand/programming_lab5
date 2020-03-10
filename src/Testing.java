import Expectables.Expectable;
import Expectables.ExpectablesBorder.ExpectedGreater;
import Expectables.ExpectablesType.ExpectedDouble;
import Expectables.ExpectablesType.ExpectedInteger;
import Expectables.ExpectablesType.ExpectedLong;

public class Testing {
	public static void main(String[] args) {
//		String value = "9223372036854775807";
		String value = "5.5";
		
		Expectable expectedType = new ExpectedDouble();
		Expectable expectedBoarder = new ExpectedGreater(50);
		try {
			expectedType.checkValueValidnes(value);
			expectedBoarder.checkValueValidnes(value);
		} catch (Error e) {
			System.out.println(e.getMessage());
		}
	}
}
