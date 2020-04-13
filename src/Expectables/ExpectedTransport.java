package Expectables;

import Input.Transport;

import java.util.Arrays;

public class ExpectedTransport implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		try {
			Transport.valueOf(valueRaw);
		} catch (IllegalArgumentException exception) {
			throw createInputError();
		}
	}
	
	@Override
	public String getErrorMessage() {
		String transportValuesFull = Arrays.toString(Transport.values());
		String transportValuesShort = transportValuesFull.substring(1, transportValuesFull.length() - 1);
		return "Должно быть одно из значений: " + transportValuesShort;
	}
	
}
