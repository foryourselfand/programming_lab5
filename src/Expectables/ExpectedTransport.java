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
		return "Должно быть одно из значений Transport: " + Arrays.toString(Transport.values());
	}
	
}
